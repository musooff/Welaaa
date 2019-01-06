package com.ballboycorp.welaaa.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ballboycorp.welaaa.main.audiobookfragment.AudiobookFragment
import com.ballboycorp.welaaa.main.classfragment.ClassFragment

/**
 * Created by musooff on 06/01/2019.
 */

class MainViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    companion object {
        const val CLASS_FRAGMENT = "크래스"
        const val AUDIOBOOK_FRAGMENT = "오디오북"
    }
    override fun getItem(position: Int): Fragment {
        return when (position){
            0 -> ClassFragment()
            1 -> AudiobookFragment()
            else -> Fragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0 -> CLASS_FRAGMENT
            1 -> AUDIOBOOK_FRAGMENT
            else -> ""
        }
    }
}