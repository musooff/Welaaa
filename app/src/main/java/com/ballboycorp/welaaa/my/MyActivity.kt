package com.ballboycorp.welaaa.my

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.ballboycorp.welaaa.R
import com.ballboycorp.welaaa.utils.DisplayUtils
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.activity_my.*

/**
 * Created by musooff on 06/01/2019.
 */

class MyActivity : AppCompatActivity(){

    companion object {
        fun newIntent(context: Context){
            val intent = Intent(context, MyActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my)


        setSupportActionBar(my_toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)


        my_appbar.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener{
            var isShow = true
            var scrollRange = -1

            override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
                if (scrollRange == -1) {
                    scrollRange = my_appbar.totalScrollRange
                }
                if (scrollRange + verticalOffset == 0) {
                    my_collapsing.title = getString(R.string.title_mywelaaa)
                    isShow = true
                } else if(isShow) {
                    my_collapsing.title = " "
                    isShow = false
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.clear()
        menuInflater.inflate(R.menu.my, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}