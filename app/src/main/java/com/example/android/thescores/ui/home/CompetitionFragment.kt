package com.example.android.thescores.ui.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.android.thescores.databinding.FragmentCompetitionBinding
import com.example.android.thescores.utils.isOnline
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class CompetitionFragment : Fragment() {

    private lateinit var binding : FragmentCompetitionBinding
    private val competitionViewModel : CompetitionViewModel by viewModels()
    private lateinit var footballCompetitionAdapter: FootballCompetitionAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCompetitionBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = viewLifecycleOwner

        footballCompetitionAdapter = FootballCompetitionAdapter(FootballCompetitionClickListener { competitionID ->
            Timber.d("ID clicked is $competitionID")
        })

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = footballCompetitionAdapter
            setHasFixedSize(true)
        }

        lifecycleScope.launch {
            competitionViewModel.loadDataFromDb().collect {footballCompetitionList->
                if (footballCompetitionList.isNotEmpty()){
                    footballCompetitionAdapter.submitList(footballCompetitionList)
                }else{
                    if (isOnline(requireContext())){
                        val dialog = createLoadingDialog()
                        dialog.show()
                        competitionViewModel.loadDataFromNetwork().observe(viewLifecycleOwner){competitionList->
                            footballCompetitionAdapter.submitList(competitionList)
                            dialog.dismissWithAnimation()
                        }
                    }else{
                        SweetAlertDialog(requireContext(), SweetAlertDialog.ERROR_TYPE)
                            .setTitleText("No internet Connection")
                            .setContentText("No connection detected, please switch on your data or try again later")
                            .setConfirmClickListener {
                                it.dismissWithAnimation()
                                exitApp()
                            }.show()
                    }

                }
            }
        }

        return binding.root
    }

    private fun createLoadingDialog() : SweetAlertDialog{
        val dialog = SweetAlertDialog(requireContext(), SweetAlertDialog.PROGRESS_TYPE)
        dialog.progressHelper.barColor = Color.parseColor("#24ac64")
        dialog.titleText = "Loading...."
        dialog.setCancelable(false)
        return dialog
    }

    private fun exitApp(){
        activity?.finishAffinity()
    }
}