package com.example.gamepicker.presentation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.domain.entities.states.Status
import com.example.domain.entities.items.Item
import com.example.gamepicker.R
import com.example.gamepicker.databinding.FragmentResultBinding
import com.example.gamepicker.presentation.listeners.GameListener
import com.example.gamepicker.presentation.recyclerview.adapters.ItemsAdapter
import com.example.gamepicker.presentation.viewmodels.SharedViewModel
import com.example.gamepicker.presentation.viewmodels.SharedViewModelFactory
import com.example.gamepicker.utils.*

class ResultFragment : Fragment() {

    private val viewModel: SharedViewModel by activityViewModels { SharedViewModelFactory() }

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    private val args: ResultFragmentArgs by navArgs()

    private val listener by lazy {
        requireParentFragment().requireParentFragment() as GameListener
    }

    private val innerDivider by lazy { requireContext().resources.getDimension(R.dimen.game_details_screenshots_outer_margin).toInt() }
    private val outerDivider by lazy { requireContext().resources.getDimension(R.dimen.game_details_screenshots_outer_margin).toInt() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)

        initObservers()

        if (savedInstanceState == null || viewModel.gameDetails.value is Status.Failure) {
            viewModel.loadCategoryResults(args.category)
        }

        return binding.root
    }

    private fun initObservers() {
        viewModel.categoryResults.observe(viewLifecycleOwner) { status ->
            when(status) {
                is Status.Loading -> binding.recyclerViewResult.makeInvisible()
                is Status.Success -> showGrid(status.data)
                is Status.Failure -> {}
            }
        }
    }

    private fun showGrid(items: List<Item>) {
        binding.recyclerViewResult.apply {
            setGridHorizontalDividersInPx(innerDivider, outerDivider)
            setGridVerticalDividersInPx(innerDivider, outerDivider)
            makeVerticalGrid(2)
            makeVisible()
            adapter = ItemsAdapter(items, listener)
        }
    }
}