package com.example.android.thescores.ui.teamDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.thescores.databinding.FragmentTeamDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TeamDetailsFragment : Fragment() {

    private lateinit var binding  : FragmentTeamDetailsBinding
    private val teamDetailViewModel : TeamDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentTeamDetailsBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.teamDetailVM = teamDetailViewModel
        val teamPlayerAdapter = TeamPlayerAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = teamPlayerAdapter
        }
        binding.progressWheel.visibility = View.VISIBLE

        lifecycleScope.launch {
            teamDetailViewModel.loadTeamPlayerLiveData().observe(viewLifecycleOwner){playerList->
                if (playerList.isNotEmpty()){
                    teamPlayerAdapter.submitList(playerList)
                    binding.progressWheel.visibility = View.GONE
                }
            }
        }


        return binding.root
    }

}