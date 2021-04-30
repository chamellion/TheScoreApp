package com.example.android.thescores.ui.teamDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.thescores.R
import com.example.android.thescores.databinding.FragmentTeamDetailsBinding


class TeamDetailsFragment : Fragment() {

    private lateinit var binding  : FragmentTeamDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentTeamDetailsBinding.inflate(inflater, container, false)



        return binding.root
    }

}