package com.example.gamepicker.presentation.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.game.Game
import com.example.gamepicker.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(
            owner = this,
            factory = HomeViewModelFactory()
        )[HomeViewModel::class.java]

        initializeObservers()

        return binding.root
    }

    private fun initializeObservers() {
        viewModel.popularGames.observe(viewLifecycleOwner, {
            binding.recyclerViewPopular.setup(it)
        })

        viewModel.openWorldGames.observe(viewLifecycleOwner, {
            binding.recyclerViewNew.setup(it)
        })

        viewModel.multiplayerGames.observe(viewLifecycleOwner, {
            binding.recyclerViewMultiplayer.setup(it)
        })

        viewModel.metacriticChoiceGames.observe(viewLifecycleOwner, {
            binding.recyclerViewMetacriticChoice.setup(it)
        })
        
        viewModel.fromSoftwareGames.observe(viewLifecycleOwner, {
            binding.recyclerViewFromSoftwareGames.setup(it)
        })

        viewModel.playstationGames.observe(viewLifecycleOwner, {
            binding.recyclerViewPlaystationCollection.setup(it)
        })
    }

    private fun RecyclerView.setup(games: List<Game>) {
        apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = HomeAdapter(games)
        }
    }
}