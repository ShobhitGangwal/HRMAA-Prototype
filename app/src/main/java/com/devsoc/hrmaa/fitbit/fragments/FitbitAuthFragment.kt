package com.devsoc.hrmaa.fitbit.fragments

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.databinding.DataBindingUtil
import com.devsoc.hrmaa.R
import com.devsoc.hrmaa.databinding.FragmentFitbitAuthBinding

class FitbitAuthFragment : Fragment() {

    private lateinit var binding: FragmentFitbitAuthBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_fitbit_auth, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.authBtBvFaf.setOnClickListener {
            val url : String = "https://www.fitbit.com/oauth2/authorize?client_id=238QCY&redirect_url=hrma://www.example.com/getCode&response_type=code&scope=activity heartrate nutrition oxygen_saturation%20respiratory_rate%20settings%20sleep%20temperature%20weight"
            val builder : CustomTabsIntent.Builder = CustomTabsIntent.Builder()
            val customTabsIntent = builder.build()
            customTabsIntent.launchUrl(requireContext(), Uri.parse(url))
        }
    }

}