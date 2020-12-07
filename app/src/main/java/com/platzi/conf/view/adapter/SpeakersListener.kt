package com.platzi.conf.view.adapter

import com.platzi.conf.model.Speaker

interface SpeakersListener {
    fun onSpeakerClick(speaker: Speaker, position: Int)

}