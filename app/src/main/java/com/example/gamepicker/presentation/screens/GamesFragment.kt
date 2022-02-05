package com.example.gamepicker.presentation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.states.Status
import com.example.domain.entities.items.Item
import com.example.gamepicker.R
import com.example.gamepicker.databinding.FragmentGamesBinding
import com.example.gamepicker.presentation.listeners.GameListener
import com.example.gamepicker.presentation.viewmodels.SharedViewModel
import com.example.gamepicker.presentation.viewmodels.SharedViewModelFactory
import com.example.gamepicker.presentation.recyclerview.adapters.ItemsAdapter
import com.example.gamepicker.utils.disableShimmer
import com.example.gamepicker.utils.makeVertical
import com.example.gamepicker.utils.makeVisible
import com.example.gamepicker.utils.setVerticalDividersInPx

class GamesFragment : Fragment() {

    private val viewModel: SharedViewModel by activityViewModels { SharedViewModelFactory() }

    private var _binding: FragmentGamesBinding? = null
    private val binding get() = _binding!!

    private val listener by lazy {
        requireParentFragment().requireParentFragment() as GameListener
    }

    private val innerDivider by lazy {
        requireContext().resources.getDimension(R.dimen.fragment_home_inner_margin).toInt()
    }

    private val outerDivider by lazy {
        requireContext().resources.getDimension(R.dimen.fragment_home_outer_margin).toInt()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGamesBinding.inflate(inflater, container, false)

        initObservers()

        if (viewModel.homeItems.value == null || viewModel.homeItems.value is Status.Failure) {
            viewModel.loadHomeItems()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



    private fun initObservers() {
        viewModel.homeItems.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Status.Loading -> binding.shimmerHome.showShimmer(true)
                is Status.Success -> showItemsRecycler(result.data)
                is Status.Failure -> showErrorLayout()
            }
        }
    }

    private fun showErrorLayout() {
        binding.shimmerHome.disableShimmer()
        binding.errorLayoutHome.root.makeVisible()
    }

    private fun showItemsRecycler(items: List<Item>) {
        binding.shimmerHome.disableShimmer()
        binding.recyclerViewHome.apply {
            makeVertical()
            setVerticalDividersInPx(innerDivider, outerDivider)
            adapter = ItemsAdapter(items, listener)
            visibility = RecyclerView.VISIBLE
        }
    }
}