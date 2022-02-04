package com.example.gamepicker.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.example.gamepicker.R
import com.example.gamepicker.databinding.FragmentHomeBinding
import com.example.gamepicker.presentation.GamesFragmentDirections

class HomeFragment : Fragment(), GameListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeNavController by lazy {
        val homeNavHost = childFragmentManager.findFragmentById(R.id.fragmentContainerViewHome) as NavHostFragment
        homeNavHost.navController
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onGameCardClicked(gameId: Int) {
        val action = GamesFragmentDirections.actionGamesFragmentToGameDetailsFragment(gameId)
        homeNavController.navigate(action)
    }


}