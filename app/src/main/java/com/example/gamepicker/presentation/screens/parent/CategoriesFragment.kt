package com.example.gamepicker.presentation.screens.parent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.example.domain.entities.enums.Category
import com.example.gamepicker.R
import com.example.gamepicker.databinding.FragmentCategoriesBinding
import com.example.gamepicker.presentation.listeners.CategoryListener
import com.example.gamepicker.presentation.listeners.GameListener
import com.example.gamepicker.presentation.screens.CategoriesListFragmentDirections
import com.example.gamepicker.presentation.screens.ResultFragmentDirections

class CategoriesFragment : Fragment(), CategoryListener, GameListener {

    private var _binding: FragmentCategoriesBinding? = null
    private val binding get() = _binding!!

    private val categoriesNavController by lazy {
        val homeNavHost =
            childFragmentManager.findFragmentById(R.id.fragmentContainerViewCategories) as NavHostFragment
        homeNavHost.navController
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoriesBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onGameCardClicked(gameId: Int) {
        val action = ResultFragmentDirections.actionResultFragmentToGameDetailsFragment(gameId)
        categoriesNavController.navigate(action)
    }

    override fun onCategoryClicked(category: Category) {
        val action =
            CategoriesListFragmentDirections.actionCategoriesListFragmentToResultFragment(category)
        categoriesNavController.navigate(action)
    }
}