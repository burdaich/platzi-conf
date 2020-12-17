package com.platzi.conf.view.ui.fragments

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.platzi.conf.R
import com.platzi.conf.model.Ubication
import kotlinx.android.synthetic.main.fragment_ubication_detail_dialog.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UbicationDetailDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UbicationDetailDialogFragment : DialogFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.fullscreenDialogStyle)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ubication_detail_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbarUbication.navigationIcon =
            ContextCompat.getDrawable(view.context, R.drawable.ic_close)
        toolbarUbication.setTitleTextColor(Color.WHITE)
        toolbarUbication.setNavigationOnClickListener { dismiss() }

        val ubication = Ubication()
        toolbarUbication.title = ubication.name
        tvDetailLocationName.text = ubication.name
        tvDetailLocationPlace.text = ubication.address
        tvDetailLocationPhoneNumber.text = ubication.phone
        tvDetailLocationWebsite.text = ubication.website

        llDetailTelephone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
                .apply { data = Uri.parse("tel:${ubication.phone}") }

            startActivity(intent)
        }

        llDetailWebsite.setOnClickListener {
            val browserIntent =
                Intent(Intent.ACTION_VIEW, Uri.parse(ubication.website))
            startActivity(browserIntent)
        }
    }


    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }
}