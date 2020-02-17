package com.example.challenge1.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.challenge1.R
import com.example.challenge1.glide.GlideApp
import com.example.challenge1.service.Guide

class GuideAdapter(recycler: RecyclerView): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val data = ArrayList<Guide>()

    init {
        setHasStableIds(true)
        recycler.adapter = this
        recycler.layoutManager = LinearLayoutManager(recycler.context)
    }

    fun updateData(updatedData: List<Guide>) {
        data.clear()
        data.addAll(updatedData)
        notifyDataSetChanged()
    }

    //super overrides
    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemId(position: Int): Long {
        return data[position].name.hashCode().toLong()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_guide, parent, false)
        return GuideViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is GuideViewHolder -> {
                holder.bind(data[position])
            }
        }
    }

    //viewholders
    class GuideViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        @BindView(R.id.guide_icon)
        lateinit var icon: ImageView
        @BindView(R.id.guide_name)
        lateinit var name: TextView
        @BindView(R.id.guide_location)
        lateinit var location: TextView
        @BindView(R.id.guide_end_date)
        lateinit var endDate: TextView

        lateinit var guide: Guide

        init {
            ButterKnife.bind(this, itemView)
        }

        fun bind(boundGuide: Guide) {
            guide = boundGuide

            GlideApp.with(icon.context).load(guide.icon).into(icon)
            name.text = guide.name
            location.text = "${guide.venue.city}, ${guide.venue.state}"
            endDate.text = guide.endDate
        }
    }
}