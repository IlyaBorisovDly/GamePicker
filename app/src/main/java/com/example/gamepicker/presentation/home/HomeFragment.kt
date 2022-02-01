package com.example.gamepicker.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.Status
import com.example.domain.entity.item.Item
import com.example.gamepicker.R
import com.example.gamepicker.databinding.FragmentHomeBinding
import com.example.gamepicker.presentation.SharedViewModel
import com.example.gamepicker.presentation.home.recyclerview.adapter.HomeAdapter
import com.example.gamepicker.utils.disableShimmer
import com.example.gamepicker.utils.makeVertical
import com.example.gamepicker.utils.setVerticalDividersInPx

class HomeFragment : Fragment() {

    private val viewModel: SharedViewModel by activityViewModels { HomeViewModelFactory() }

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

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
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        initObservers()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initObservers() {
        viewModel.items.observe(viewLifecycleOwner) { result ->
            binding.shimmerHome.disableShimmer()
            when (result) {
                is Status.Success -> showItemsRecycler(result.data)
                is Status.Failure -> showErrorLayout()
            }
        }
    }

    private fun showErrorLayout() {
        binding.layoutError.root.visibility = View.VISIBLE
    }

    private fun showItemsRecycler(items: List<Item>) {
        binding.recyclerViewHome.apply {
            makeVertical()
            setVerticalDividersInPx(innerDivider, outerDivider)
            adapter = HomeAdapter(items)
            visibility = RecyclerView.VISIBLE
        }
    }
}