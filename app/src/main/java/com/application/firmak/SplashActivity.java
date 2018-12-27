package com.application.firmak;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class SplashActivity extends AppCompatActivity{
    private Button login, register;
    //public List<Sbit> sabt = new ArrayList<Sbit>();
    private static final String SAVING_STATE_SLIDER_ANIMATION = "SliderAnimationSavingState";
    private boolean isSliderAnimation = false;
    ViewPager viewPager;
    TextView titleView;
    TextView hintView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        login = (Button) findViewById(R.id.login);
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        titleView = (TextView) findViewById(R.id.landing_txt_title);
        hintView = (TextView) findViewById(R.id.landing_txt_hint);

        titleView.setText(getResources().obtainTypedArray(R.array.titles).getString(0));
        hintView.setText(getResources().obtainTypedArray(R.array.hints).getString(0));

        hintView.setMovementMethod(new ScrollingMovementMethod());
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(myIntent);
            }
        });

        viewPager = (ViewPager) findViewById(R.id.pager);

        viewPager.setAdapter(new ViewPagerAdapter(R.array.icons));

        viewPager.setPageTransformer(true, new CustomPageTransformer());

        ViewGroup.LayoutParams lp = (ViewGroup.LayoutParams) viewPager.getLayoutParams();
        lp.height = (ApplicationClass.height/3)*2-100;
        viewPager.setLayoutParams(lp);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                titleView.setText(getResources().obtainTypedArray(R.array.titles).getString(position));
                hintView.setText(getResources().obtainTypedArray(R.array.hints).getString(position));
                if(position == 2)
                    login.setVisibility(View.VISIBLE);
                else
                    login.setVisibility(View.GONE);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        CirclePageIndicator mIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
        mIndicator.setViewPager(viewPager);

    }

    public class ViewPagerAdapter extends PagerAdapter {

        private int iconResId;

        public ViewPagerAdapter(int iconResId) {

            this.iconResId = iconResId;
        }

        @Override
        public int getCount() {
            return getResources().getIntArray(iconResId).length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            Drawable icon = getResources().obtainTypedArray(iconResId).getDrawable(position);

            View itemView = getLayoutInflater().inflate(R.layout.viewpager_item, container, false);

            ImageView iconView = (ImageView) itemView.findViewById(R.id.landing_img_slide);

            ViewGroup.LayoutParams lp = (ViewGroup.LayoutParams) iconView.getLayoutParams();
            lp.height = (ApplicationClass.height/3)*2-100;
            iconView.setLayoutParams(lp);

            iconView.setImageDrawable(icon);

            container.addView(itemView);

            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((RelativeLayout) object);

        }
    }

    public class CustomPageTransformer implements ViewPager.PageTransformer {


        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();

            View imageView = view.findViewById(R.id.landing_img_slide);
            View contentView = view.findViewById(R.id.landing_txt_hint);
            View txt_title = view.findViewById(R.id.landing_txt_title);
            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left
            } else if (position <= 0) { // [-1,0]
                // This page is moving out to the left

                // Counteract the default swipe
                setTranslationX(view,pageWidth * -position);
                if (contentView != null) {
                    // But swipe the contentView
                    setTranslationX(contentView,pageWidth * position);
                    setTranslationX(txt_title,pageWidth * position);

                    setAlpha(contentView,1 + position);
                    setAlpha(txt_title,1 + position);
                }

                if (imageView != null) {
                    // Fade the image in
                    setAlpha(imageView,1 + position);
                }

            } else if (position <= 1) { // (0,1]
                // This page is moving in from the right

                // Counteract the default swipe
                setTranslationX(view, pageWidth * -position);
                if (contentView != null) {
                    // But swipe the contentView
                    setTranslationX(contentView,pageWidth * position);
                    setTranslationX(txt_title,pageWidth * position);

                    setAlpha(contentView, 1 - position);
                    setAlpha(txt_title, 1 - position);

                }
                if (imageView != null) {
                    // Fade the image out
                    setAlpha(imageView,1 - position);
                }

            }
        }
    }

    /**
     * Sets the alpha for the view. The alpha will be applied only if the running android device OS is greater than honeycomb.
     * @param view - view to which alpha to be applied.
     * @param alpha - alpha value.
     */
    private void setAlpha(View view, float alpha) {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB && ! isSliderAnimation) {
            view.setAlpha(alpha);
        }
    }

    /**
     * Sets the translationX for the view. The translation value will be applied only if the running android device OS is greater than honeycomb.
     * @param view - view to which alpha to be applied.
     * @param translationX - translationX value.
     */
    private void setTranslationX(View view, float translationX) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB && ! isSliderAnimation) {
            view.setTranslationX(translationX);
        }
    }

    public void onSaveInstanceState(Bundle outstate) {

        if(outstate != null) {
            outstate.putBoolean(SAVING_STATE_SLIDER_ANIMATION,isSliderAnimation);
        }

        super.onSaveInstanceState(outstate);
    }

    public void onRestoreInstanceState(Bundle inState) {

        if(inState != null) {
            isSliderAnimation = inState.getBoolean(SAVING_STATE_SLIDER_ANIMATION,false);
        }
        super.onRestoreInstanceState(inState);

    }
}