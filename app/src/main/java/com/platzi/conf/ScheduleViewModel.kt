package com.platzi.conf

import androidx.lifecycle.MutableLiveData
import com.platzi.conf.model.Conference
import com.platzi.conf.network.Callback
import com.platzi.conf.network.FirestoreService

class ScheduleViewModel {
    val firestoreService = FirestoreService()
    var listSchedule: MutableLiveData<List<Conference>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>();

    fun refresh() {
        getScheduleFromFirebase();
    }

    private fun getScheduleFromFirebase() {
        firestoreService.getSchedule(object : Callback<List<Conference>> {
            override fun onFailed(exception: Exception) {
                processFinished()
            }

            override fun onSuccess(result: List<Conference>?) {
                processFinished()
            }
        })
    }

    private fun processFinished() {
        isLoading.value = true
    }
}