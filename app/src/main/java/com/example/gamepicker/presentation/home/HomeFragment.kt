package com.example.gamepicker.presentation.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        viewModel.gamesLiveData.observe(viewLifecycleOwner, { game ->
            binding.textViewPopular.text = game.name
        })

        viewModel.publisherLiveData.observe(viewLifecycleOwner, { publisher ->
            binding.textViewGenres.text = publisher.name
        })

        return binding.root
    }
}