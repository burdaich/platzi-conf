package com.platzi.conf.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.platzi.conf.R
import com.platzi.conf.model.Speaker

class SpeakersAdapter(val speakersListener: SpeakersListener) :
    RecyclerView.Adapter<SpeakersAdapter.ViewHolder>() {

    private var listSpeakers = ArrayList<Speaker>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivItemSpeakerImage = itemView.findViewById<ImageView>(R.id.ivItemSpeakerImage);
        val tvItemSpeakerName = itemView.findViewById<TextView>(R.id.tvItemSpeakerName);
        val tvItemSpeakerWork = itemView.findViewById<TextView>(R.id.tvItemSpeakerWork);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SpeakersAdapter.ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_speakers, parent, false
        )
    )

    override fun getItemCount() = listSpeakers.size

    override fun onBindViewHolder(holder: SpeakersAdapter.ViewHolder, position: Int) {
        val speaker = listSpeakers[position] as Speaker
        holder.tvItemSpeakerName.text = speaker.name
        holder.tvItemSpeakerWork.text = speaker.workplace

        Glide.with(holder.itemView.context).load(speaker.image)
            .apply(RequestOptions.circleCropTransform()).into(holder.ivItemSpeakerImage)

        holder.itemView.setOnClickListener {
            speakersListener.onSpeakerClick(speaker, position)
        }
    }

    fun updateData(data: List<Speaker>) {
        listSpeakers.clear()
        listSpeakers.addAll(data)
        notifyDataSetChanged()
    }
}
