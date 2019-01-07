package com.ballboycorp.welaaa.classviewer

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ballboycorp.welaaa.classviewer.classteacher.ClassTeacherFragment
import com.ballboycorp.welaaa.main.classfragment.ClassFragment

/**
 * Created by musooff on 07/01/2019.
 */

class ClassViewerViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    companion object {
        const val CLASS_TEACHER = "크래스종보"
        const val CLASS_CONTENTS = "강의복차"
    }
    override fun getItem(position: Int): Fragment {
        return when (position){
            0 -> ClassTeacherFragment()
            1 -> Fragment()
            else -> Fragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0 -> CLASS_TEACHER
            1 -> CLASS_CONTENTS
            else -> ""
        }
    }
}