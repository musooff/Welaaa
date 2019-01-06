package com.ballboycorp.welaaa.main.classfragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import com.ballboycorp.welaaa.R
import com.ballboycorp.welaaa.main.model.Banner
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.class_first_vp_item.view.*



/**
 * Created by muso on 31/12/2018.
 */

class ClassFirstViewPagerAdapter(private val context: Context) : PagerAdapter() {

    private val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    private var banners: List<Banner> = arrayListOf()

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as LinearLayout
    }

    override fun getCount(): Int {
        return banners.size
    }

    fun submitList(banners: List<Banner>){
        this.banners = banners
        notifyDataSetChanged()
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = layoutInflater.inflate(R.layout.class_first_vp_item, container, false)
        val mDefaultBackground = context.resources.getDrawable(R.drawable.src_images_bgmy)

        Glide.with(context).load(banners[position].images!!.defaultUrl)
                .into(view.class_first_vp_item_thumb)
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }

}