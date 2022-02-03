package com.example.gamepicker.presentation.gamedetails

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.domain.Status
import com.example.domain.entity.game.GameDetails
import com.example.gamepicker.R
import com.example.gamepicker.databinding.FragmentGameDetailsBinding
import com.example.gamepicker.presentation.SharedViewModel
import com.example.gamepicker.presentation.SharedViewModelFactory
import com.example.gamepicker.utils.disableShimmer
import com.example.gamepicker.utils.makeGone
import com.example.gamepicker.utils.makeVisible

class GameDetailsFragment : Fragment() {

    private val viewModel: SharedViewModel by activityViewModels { SharedViewModelFactory() }

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
                is Status.Loading -> binding.shimmerGameDetails.makeVisible()
                is Status.Success -> showGameDetails(status.data)
                is Status.Failure -> {}
            }
        }
    }

    private fun showGameDetails(gameDetails: GameDetails) {
        setGameCardRating(gameDetails.metacritic)

        with(binding) {
            textViewDetailsGameName.text = gameDetails.name
            textViewDetailsAboutContent.text = gameDetails.description
            textViewDetailsGenresContent.text = gameDetails.genre_names
            textViewDetailsPlatformsContent.text = gameDetails.platform_names
            textViewDetailsDevelopersContent.text = gameDetails.developer_names
            textViewDetailsReleasedContent.text = gameDetails.released
            textViewDetailsTagsContent.text = gameDetails.tags
            scrollViewGameDetails.makeVisible()
        }

        loadPoster(gameDetails.image)
    }

    private fun loadPoster(uri: String) {
        Glide.with(requireContext())
            .load(uri)
            .listener(glideListener)
            .into(binding.imageViewGameDetailsPoster)
    }

    private val glideListener = object: RequestListener<Drawable> {

        override fun onLoadFailed(
            e: GlideException?,
            model: Any?,
            target: Target<Drawable>?,
            isFirstResource: Boolean,
        ): Boolean {
            binding.shimmerGameDetails.disableShimmer()
            return false
        }


        override fun onResourceReady(
            resource: Drawable?,
            model: Any?,
            target: Target<Drawable>?,
            dataSource: DataSource?,
            isFirstResource: Boolean,
        ): Boolean {
            binding.shimmerGameDetails.disableShimmer()
            return false
        }
    }

    private fun setGameCardRating(rating: Int) {

        if (rating == 0) {
            binding.textViewDetailsRating.makeGone()
            return
        }

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