package com.ballboycorp.welaaa.main.classfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ballboycorp.welaaa.R
import com.ballboycorp.welaaa.main.model.Banner
import com.ballboycorp.welaaa.main.model.Image
import com.ballboycorp.welaaa.room.AppDatabase
import com.ballboycorp.welaaa.utils.Ln
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_class.*
import kotlinx.android.synthetic.main.fragment_class.view.*

class ClassFragment : Fragment() {

    private lateinit var repository: ClassRepository

    private lateinit var adapter: ClassFirstViewPagerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_class, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        repository = ClassRepository(context!!)

        adapter = ClassFirstViewPagerAdapter(context!!)

        view.class_first_vp.adapter = adapter
        class_first_tl.setupWithViewPager(view.class_first_vp)

        repository.getBanners().subscribe({
            adapter.submitList(it) }, {
            Ln.e(it)})


    }

}
