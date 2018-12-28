package com.application.firmak

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.content.res.ResourcesCompat
import android.support.v4.graphics.drawable.DrawableCompat
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//3.1.1 studio
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView)

        bottomNavigationView.selectedItemId = R.id.menu_item3
        BottomNavigationViewHelper.addBadge(bottomNavigationView,this,3)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            if(bottomNavigationView.selectedItemId != item.itemId) {
                when (item.itemId) {
                    R.id.menu_item1 -> selectedFragment = Urunlerim()
                    R.id.menu_item2 -> selectedFragment = Fragment2()
                    R.id.menu_item3 -> selectedFragment = Fragment3()
                    R.id.menu_item4 -> {
                        selectedFragment = Fragment4()
                        BottomNavigationViewHelper.removeBadge(bottomNavigationView,this,3)
                    }
                    R.id.menu_item5 -> selectedFragment = Fragment5()
                }
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.framelayout, selectedFragment)
                transaction.commit()
            }
            true


        }

        initToolbar()

    }

    private fun initToolbar() {
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        //CUSTOME ACTIONBAR
        // Specify that tabs should be displayed in the action bar.
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowTitleEnabled(false)
        val mInflater = LayoutInflater.from(this)
        val mCustomView = mInflater.inflate(R.layout.toolbar_layout, null)
        val params = ActionBar.LayoutParams(//Center the textview in the ActionBar !
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.MATCH_PARENT,
                Gravity.CENTER)

        actionBar.setCustomView(mCustomView, params)
        actionBar.setDisplayShowCustomEnabled(true)

        actionBar.setStackedBackgroundDrawable(ColorDrawable(Color.WHITE))

        actionBar.setBackgroundDrawable(ColorDrawable(Color.WHITE))

        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(false)

        var drawable = ResourcesCompat.getDrawable(resources, R.mipmap.ic_launcher, null)
        drawable = DrawableCompat.wrap(drawable!!)
        toolbar.navigationIcon = drawable
    }

}

