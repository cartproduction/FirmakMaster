package com.application.firmak

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//3.1.1 studio
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView)

        supportFragmentManager.beginTransaction().replace(R.id.framelayout,Fragment3()).commit()
        bottomNavigationView.selectedItemId = R.id.menu_item3
        BottomNavigationViewHelper.addBadge(bottomNavigationView,this,3)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            if(bottomNavigationView.selectedItemId != item.itemId) {
                when (item.itemId) {
                    R.id.menu_item1 -> selectedFragment = Fragment1()
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



    }

}

