package com.ballboycorp.welaaa.main.classfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ballboycorp.welaaa.R
import com.ballboycorp.welaaa.main.model.Banner
import com.ballboycorp.welaaa.main.model.Image
import com.ballboycorp.welaaa.room.AppDatabase
import com.ballboycorp.welaaa.utils.Ln
import com.bumptech.glide.Glide
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_class.*
import kotlinx.android.synthetic.main.fragment_class.view.*

class ClassFragment : Fragment() {

    private lateinit var repository: ClassRepository
    private lateinit var classFirstViewPagerAdapter: ClassFirstViewPagerAdapter
    private lateinit var classPremiumAdapter: ClassPremiumAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_class, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        repository = ClassRepository(context!!)

        classFirstViewPagerAdapter = ClassFirstViewPagerAdapter(context!!)

        view.class_first_vp.adapter = classFirstViewPagerAdapter
        class_first_tl.setupWithViewPager(view.class_first_vp)


        repository.getBanners().subscribe({
            classFirstViewPagerAdapter.submitList(it) }, {
            Ln.e(it)})


        addRecommended(view.class_recommend)

        classPremiumAdapter = ClassPremiumAdapter()
        class_premium_rv.layoutManager = LinearLayoutManager(context)
        class_premium_rv.adapter = classPremiumAdapter

        repository.getPremiumClasses()
                .subscribe({
                    classPremiumAdapter.submitList(it[3].item)
                },{
                    Ln.e(it)
                })


    }

    private fun addRecommended(view: LinearLayout){
        val recommendUrls = resources.getStringArray(R.array.recommend_urls)
        recommendUrls.forEach {
            val imageView = ImageView(context)
            val params = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            )
            imageView.layoutParams = params
            Glide.with(context!!).load(it).into(imageView)
            view.addView(imageView)

        }
    }

}
