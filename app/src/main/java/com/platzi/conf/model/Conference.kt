package com.platzi.conf.model

import java.io.Serializable
import java.util.*

class Conference() : Serializable {
    lateinit var title: String
    lateinit var description: String
    lateinit var topic: String
    lateinit var dateTime: Date
    lateinit var tag: String
    lateinit var speaker: String
}