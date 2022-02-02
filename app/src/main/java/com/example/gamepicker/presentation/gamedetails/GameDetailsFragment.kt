package com.example.gamepicker.presentation.gamedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.domain.Status
import com.example.gamepicker.R
import com.example.gamepicker.databinding.FragmentGameDetailsBinding
import com.example.gamepicker.presentation.SharedViewModel
import com.example.gamepicker.presentation.home.HomeViewModelFactory
import com.example.gamepicker.utils.disableShimmer

class GameDetailsFragment : Fragment() {

    private val viewModel: SharedViewModel by activityViewModels { HomeViewModelFactory() }

    private var _binding: FragmentGameDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentGameDetailsBinding.inflate(inflater, container, false)

        val gameId = GameDetailsFragmentArgs.fromBundle(requireArguments()).gameId

        initObservers()

        viewModel.loadGameDetailsById(gameId)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initObservers() {
        viewModel.gameDetails.observe(viewLifecycleOwner) { status ->
            when(status) {
                is Status.Loading -> {
//                    binding.scrollViewGameDetails.visibility = View.GONE
//                    binding.shimmerGameDetails.visibility = View.VISIBLE
                }
                is Status.Success -> {
                    binding.shimmerGameDetails.disableShimmer()
                    binding.scrollViewGameDetails.visibility = View.VISIBLE

                    val gameDetails = status.data

                    setGameCardRating(gameDetails.metacritic)
                    loadPoster(gameDetails.background_image)

                    binding.textViewDetailsGameName.text = gameDetails.name
                    binding.textViewDetailsAboutContent.text = gameDetails.description
                    binding.textViewDetailsGenresContent.text = gameDetails.genre_names
                    binding.textViewDetailsReleasedContent.text = gameDetails.released
                    binding.textViewDetailsPlatformsContent.text = gameDetails.platform_names
                    binding.textViewDetailsDevelopersContent.text = gameDetails.developer_names
                    binding.textViewDetailsTagsContent.text = gameDetails.tags

                }
                is Status.Failure -> {}
            }
        }
    }

    private fun loadPoster(uri: String) {
        Glide.with(requireContext())
            .load(uri)
            .into(binding.imageViewGameDetailsPoster)
    }

    private fun setGameCardRating(rating: Int) {
        if (rating == 0) {
            binding.textViewDetailsRating.visibility = View.GONE
            return
        }

        binding.textViewDetailsRating.visibility = View.VISIBLE
        binding.textViewDetailsRating.apply {
            text = rating.toString()
            when (rating) {
                in 1..49 -> setBackgroundById(R.drawable.shape_round_rectangle_red_filled)
                in 50..74 -> setBackgroundById(R.drawable.shape_round_rectangle_yellow_filled)
                else -> setBackgroundById(R.drawable.shape_round_rectangle_green_filled)
            }
        }
    }

    private fun TextView.setBackgroundById(id: Int) {
        background = ContextCompat.getDrawable(requireContext(), id)
    }
}