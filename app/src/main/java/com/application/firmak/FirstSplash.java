package com.application.firmak;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;


public class FirstSplash extends AppCompatActivity{
    ImageView img;
    public int xCount = 0;

    public static boolean perms = false;
    public static final String MY_PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_splash);

        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        ApplicationClass.width = size.x;
        ApplicationClass.height = size.y;

        ImageView imag = (ImageView) findViewById(R.id.imageView);
        ViewGroup.LayoutParams lp2 = (ViewGroup.LayoutParams) imag.getLayoutParams();
        lp2.width = (ApplicationClass.width/2);
        imag.setLayoutParams(lp2);


        /*new AsyncTask<String, Void, String>() {


            @Override
            protected void onPreExecute() {


            }

            @Override
            protected String doInBackground(String... params) {


                ApiInterface apiService = RetrofitAdapter.getClient().create(ApiInterface.class);
                Call<Sabit> cons = apiService.getConst(new TokenRequest(ApplicationClass.TOKEN));

                cons.enqueue(new Callback<Sabit>() {
                    @Override
                    public void onResponse(Call<Sabit> call, Response<Sabit> response) {

                        ApplicationClass.sabt = response.body().getList();
                        ApplicationClass.baslik.add(ApplicationClass.sabt.get(0));
                        ApplicationClass.baslik.add(ApplicationClass.sabt.get(2));
                        ApplicationClass.baslik.add(ApplicationClass.sabt.get(4));
                        ApplicationClass.baslik.add(ApplicationClass.sabt.get(6));

                        ApplicationClass.aciklama.add(ApplicationClass.sabt.get(1));
                        ApplicationClass.aciklama.add(ApplicationClass.sabt.get(3));
                        ApplicationClass.aciklama.add(ApplicationClass.sabt.get(5));
                        ApplicationClass.aciklama.add(ApplicationClass.sabt.get(7));
                        xCount++;

                    }

                    @Override
                    public void onFailure(Call<Sabit> call, Throwable t) {
                        System.out.println(t.getMessage());
                    }
                });

                while(xCount!=1){
                    try {
                        sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


                return null;
            }
            @Override
            protected void onPostExecute(String result) {


            }
        }.execute();*/



        ApplicationClass.baslik.add(ApplicationClass.sabt.get(0));
        ApplicationClass.baslik.add(ApplicationClass.sabt.get(1));
        ApplicationClass.baslik.add(ApplicationClass.sabt.get(2));
        ApplicationClass.baslik.add(ApplicationClass.sabt.get(3));

        ApplicationClass.aciklama.add(ApplicationClass.sabt.get(0));
        ApplicationClass.aciklama.add(ApplicationClass.sabt.get(1));
        ApplicationClass.aciklama.add(ApplicationClass.sabt.get(2));
        ApplicationClass.aciklama.add(ApplicationClass.sabt.get(3));

        Intent i = new Intent(FirstSplash.this, SplashActivity.class);
        startActivity(i);
        finish();



    }

    /*@Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    perms = false;
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }
            // other 'case' lines to check for other
            // permissions this app might request
        }
    }*/

}
