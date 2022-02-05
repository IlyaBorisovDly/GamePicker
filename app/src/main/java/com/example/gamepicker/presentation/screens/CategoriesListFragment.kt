package com.example.gamepicker.presentation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.domain.Category
import com.example.gamepicker.databinding.FragmentCategoriesListBinding
import com.example.gamepicker.presentation.listener.CategoryListener

class CategoriesListFragment : Fragment() {

    private var _binding: FragmentCategoriesListBinding? = null
    private val binding get() = _binding!!

    private val listener by lazy {
        requireParentFragment().requireParentFragment() as CategoryListener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentCategoriesListBinding.inflate(inflater, container, false)

        initOnClickListeners()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initOnClickListeners() {
        with(binding) {
            textViewCategoriesCreators.setOnClickCategoryTransfer(Category.Creators)
            textViewCategoriesPublishers.setOnClickCategoryTransfer(Category.Publishers)
            textViewCategoriesGenres.setOnClickCategoryTransfer(Category.Genres)
            textViewCategoriesDevelopers.setOnClickCategoryTransfer(Category.Developers)
            textViewCategoriesPlatforms.setOnClickCategoryTransfer(Category.Platforms)
        }
    }

    private fun TextView.setOnClickCategoryTransfer(category: Category) {
        setOnClickListener {
            listener.onCategoryClicked(category)
        }
    }
}