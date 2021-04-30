package com.example.android.thescores.ui.teams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.android.thescores.databinding.FragmentTeamsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TeamsFragment : Fragment() {

    private val teamsViewModel : TeamsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding = FragmentTeamsBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = viewLifecycleOwner
        val teamsAdapter = TeamsAdapter(TeamClickListener { teamItem ->
            Toast.makeText(requireContext(), teamItem.email, Toast.LENGTH_LONG).show()
        })

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = teamsAdapter
            addItemDecoration(GridLayoutDecorator(40))
        }
        lifecycleScope.launch {
            teamsViewModel.loadTeamPicture().observe(viewLifecycleOwner){teamItemList->
                teamsAdapter.submitList(teamItemList)
            }
        }

        return binding.root
    }

}