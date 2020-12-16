package com.platzi.conf.viewmodel

import androidx.lifecycle.MutableLiveData
import com.platzi.conf.model.Speaker
import com.platzi.conf.network.Callback
import com.platzi.conf.network.FirestoreService

class SpeakersViewModel {
    val firestoreService = FirestoreService()
    var listSpeakers: MutableLiveData<List<Speaker>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>();

    fun refresh() {
        getSpeakersFromFirebase();
    }

    private fun getSpeakersFromFirebase() {
        firestoreService.getSpeakers(object : Callback<List<Speaker>> {
            override fun onFailed(exception: Exception) {
                processFinished()
            }

            override fun onSuccess(result: List<Speaker>?) {
                listSpeakers.postValue(result)
                processFinished()
            }
        })

    }

    private fun processFinished() {
        isLoading.value = true
    }
}