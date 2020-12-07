package com.platzi.conf.view.adapter

import android.telecom.Conference
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.platzi.conf.R

class ScheduleAdapter() : RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {

    private var listConference = ArrayList<Conference>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvItemScheduleHour = itemView.findViewById<TextView>(R.id.tvItemScheduleHour)
        val tvItemScheduleAMPM = itemView.findViewById<TextView>(R.id.tvItemScheduleAMPM)
        val tvItemScheduleConferenceName =
            itemView.findViewById<TextView>(R.id.tvItemScheduleConferenceName)
        val tvItemScheduleConferenceSpeaker =
            itemView.findViewById<TextView>(R.id.tvItemScheduleConferenceSpeaker)
        val tvItemScheduleConferenceTag =
            itemView.findViewById<TextView>(R.id.tvItemScheduleConferenceTag)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_schedule, parent, false
        )
    )

    override fun getItemCount() = listConference.size

    override fun onBindViewHolder(holder: ScheduleAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}
