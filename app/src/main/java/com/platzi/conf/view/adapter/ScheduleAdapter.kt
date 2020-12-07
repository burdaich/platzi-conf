package com.platzi.conf.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.platzi.conf.R
import com.platzi.conf.model.Conference
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ScheduleAdapter(val scheduleListener: ScheduleListener) :
    RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {

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

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val conference = listConference[position] as Conference
        holder.tvItemScheduleConferenceName.text = conference.title
        holder.tvItemScheduleConferenceSpeaker.text = conference.speaker
        holder.tvItemScheduleConferenceTag.text = conference.tag

        val simpleDateFormat = SimpleDateFormat("HH:mm")
        val simpleDateFormatAMPM = SimpleDateFormat("a")

        val cal = Calendar.getInstance()
        cal.time = conference.dateTime
        val hourFormat = simpleDateFormat.format(conference.dateTime)

        holder.tvItemScheduleHour.text = hourFormat
        holder.tvItemScheduleAMPM.text =
            simpleDateFormatAMPM.format(conference.dateTime).toUpperCase()

        holder.itemView.setOnClickListener {
            scheduleListener.onConferenceClick(conference, position)
        }
    }

    fun updateData(data: List<Conference>) {
        listConference.clear()
        listConference.addAll(data)
        notifyDataSetChanged()
    }

}
