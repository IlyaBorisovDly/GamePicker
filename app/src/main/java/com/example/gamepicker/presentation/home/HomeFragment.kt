package com.example.gamepicker.presentation.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.domain.entity.Status
import com.example.gamepicker.R
import com.example.gamepicker.databinding.FragmentHomeBinding
import com.example.gamepicker.presentation.home.recyclerview.adapter.HomeAdapter
import com.example.gamepicker.utils.disableShimmer
import com.example.gamepicker.utils.makeVertical
import com.example.gamepicker.utils.setVerticalDividersInPx

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

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
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(
            owner = this,
            factory = HomeViewModelFactory()
        )[HomeViewModel::class.java]

        initObservers()

        return binding.root
    }

    private fun initObservers() {

        viewModel.items.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Status.Success -> {
                    binding.shimmerHome.disableShimmer()
                    binding.recyclerViewHome.apply {
                        adapter = HomeAdapter(result.data)
                        setVerticalDividersInPx(innerDivider, outerDivider)
                        makeVertical()
                    }
                }
                is Status.Failure -> {
                    binding.shimmerHome.disableShimmer()
                }
            }
        }
    }
}