package com.ballboycorp.welaaa.classviewer.classteacher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ballboycorp.welaaa.R

/**
 * Created by musooff on 07/01/2019.
 */

class ClassTeacherFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_classteacher, container, false)
    }
}