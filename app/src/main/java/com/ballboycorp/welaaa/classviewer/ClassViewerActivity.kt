package com.ballboycorp.welaaa.classviewer

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.ballboycorp.welaaa.R
import com.ballboycorp.welaaa.utils.Ln
import com.bumptech.glide.Glide
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.activity_classviewer.*

/**
 * Created by musooff on 07/01/2019.
 */

class ClassViewerActivity : AppCompatActivity() {

    companion object {

        private const val ITEM_ID = "itemId"
        private const val ITEM_HEADLINE = "itemHeadline"

        fun newIntent(context: Context, itemId: Int, itemHeadline: String) {
            val intent = Intent(context, ClassViewerActivity::class.java)
            intent.putExtra(ITEM_ID, itemId)
            intent.putExtra(ITEM_HEADLINE, itemHeadline)
            context.startActivity(intent)
        }
    }

    private var itemId: Int = 0
    private var itemHeadline: String = ""
    private lateinit var repository: ClassViewerRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_classviewer)

        itemId = intent!!.extras!!.getInt(ITEM_ID)
        itemHeadline = intent!!.extras!!.getString(ITEM_HEADLINE)!!

        repository = ClassViewerRepository(this)

        setSupportActionBar(classviewer_toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)


        repository.getItem(itemId)
                .subscribe({
                    classviewer_item_header.text = it.headline
                    Glide.with(this).load(it.teacher!!.images!!.defaultUrl).into(classviewer_backdrop)

                }, { Ln.e(it)})


        my_appbar.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener{
            var isShow = true
            var scrollRange = -1

            override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
                if (scrollRange == -1) {
                    scrollRange = my_appbar.totalScrollRange
                }
                if (scrollRange + verticalOffset == 0) {
                    my_collapsing.title = itemHeadline
                    isShow = true
                } else if(isShow) {
                    my_collapsing.title = " "
                    isShow = false
                }
            }
        })

        classviewer_vp.adapter = ClassViewerViewPagerAdapter(supportFragmentManager)
        classviewer_tl.setupWithViewPager(classviewer_vp)
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