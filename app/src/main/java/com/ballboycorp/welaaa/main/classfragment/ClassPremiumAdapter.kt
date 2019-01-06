package com.ballboycorp.welaaa.main.classfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ballboycorp.welaaa.R
import com.ballboycorp.welaaa.main.classfragment.model.Item
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.premium_item.view.*

/**
 * Created by musooff on 07/01/2019.
 */

class ClassPremiumAdapter: RecyclerView.Adapter<ClassPremiumAdapter.ClassPremiumViewHolder>() {
    private var premiums: List<Item> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassPremiumViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.premium_item, parent, false)
        return ClassPremiumViewHolder(view)
    }

    override fun getItemCount(): Int {
        return premiums.size
    }

    fun submitList(premiums: List<Item>){
        this.premiums = premiums
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ClassPremiumViewHolder, position: Int) {
        holder.bind(premiums[position])
    }

    inner class ClassPremiumViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        fun bind(item: Item) {
            view.premium_title.text = item.headline
            Glide.with(view.context).load(item.images!!.wide).into(view.premium_thumb)
            view.premium_thumb_title.text = item.teacher!!.headline
        }

    }
}