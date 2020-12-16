package com.platzi.conf.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.platzi.conf.R
import com.platzi.conf.model.Conference
import com.platzi.conf.model.Speaker
import com.platzi.conf.view.adapter.SpeakersAdapter
import com.platzi.conf.view.adapter.SpeakersListener
import com.platzi.conf.viewmodel.ScheduleViewModel
import com.platzi.conf.viewmodel.SpeakersViewModel
import kotlinx.android.synthetic.main.fragment_schedule.*
import kotlinx.android.synthetic.main.fragment_speakers.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SpeakersFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SpeakersFragment : Fragment(), SpeakersListener {
    // TODO: Rename and change types of parameters
    private lateinit var speakersAdapter: SpeakersAdapter
    private lateinit var speakersViewModel: SpeakersViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_speakers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        speakersViewModel = ViewModelProvider(this).get(SpeakersViewModel::class.java)
        speakersViewModel.refresh()

        speakersAdapter = SpeakersAdapter(this)

        rvSpeakers.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = speakersAdapter
        }
        observeViewModel()
    }

    private fun observeViewModel() {
        speakersViewModel.listSpeakers.observe(
            viewLifecycleOwner,
            Observer<List<Speaker>> { speaker ->
                speakersAdapter.updateData(speaker)
            })

        speakersViewModel.isLoading.observe(viewLifecycleOwner, Observer<Boolean> {
            if (it != null)
                rlBase.visibility = View.INVISIBLE
        })
    }

    override fun onSpeakerClick(speaker: Speaker, position: Int) {
        var bundle = bundleOf("speaker" to speaker)

        findNavController().navigate(R.id.speakerDetailFragmentDialog, bundle)
    }
}