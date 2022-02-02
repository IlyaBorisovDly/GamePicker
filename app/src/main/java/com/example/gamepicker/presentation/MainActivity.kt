package com.example.gamepicker.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.gamepicker.R
import com.example.gamepicker.databinding.ActivityMainBinding
import com.example.gamepicker.presentation.home.HomeFragmentDirections
import com.example.gamepicker.presentation.home.GameListener

class MainActivity : AppCompatActivity(), GameListener {

    private lateinit var binding: ActivityMainBinding

    private val navController by lazy {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navHostFragment.navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setupWithNavController(navController)
    }

    override fun onGameCardClicked(gameId: Int) {
        val action = HomeFragmentDirections.actionHomeFragmentToGameDetailsFragment(gameId)
        navController.navigate(action)
    }
}