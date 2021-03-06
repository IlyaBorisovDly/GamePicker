package com.example.gamepicker.presentation.screens

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.domain.entities.states.Status
import com.example.domain.entities.GameDetails
import com.example.domain.entities.Platform
import com.example.domain.entities.Screenshot
import com.example.domain.entities.enums.ParentPlatform
import com.example.gamepicker.R
import com.example.gamepicker.databinding.FragmentGameDetailsBinding
import com.example.gamepicker.presentation.viewmodels.SharedViewModel
import com.example.gamepicker.presentation.viewmodels.SharedViewModelFactory
import com.example.gamepicker.presentation.recyclerview.adapters.ScreenshotsAdapter
import com.example.gamepicker.utils.*
import java.text.SimpleDateFormat
import java.util.*

class GameDetailsFragment : Fragment() {

    private val viewModel: SharedViewModel by activityViewModels { SharedViewModelFactory() }

    private var _binding: FragmentGameDetailsBinding? = null
    private val binding get() = _binding!!

    private val args:GameDetailsFragmentArgs by navArgs()

    private val innerDivider by lazy {
        requireContext().resources.getDimension(R.dimen.game_details_screenshots_inner_margin).toInt()
    }

    private val outerDivider by lazy {
        requireContext().resources.getDimension(R.dimen.game_details_screenshots_outer_margin).toInt()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentGameDetailsBinding.inflate(inflater, container, false)

        initObservers()

        if (savedInstanceState == null || viewModel.gameDetails.value is Status.Failure) {
            viewModel.loadGameDetailsById(args.gameId)
        }

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
                is Status.Failure -> showErrorLayout()
            }
        }

        viewModel.gameScreenshots.observe(viewLifecycleOwner) { status ->
            when(status) {
                is Status.Loading -> binding.recyclerViewGameDetailsScreenshots.makeInvisible()
                is Status.Success -> {
                    showScreenshotsRecycler(status.data)
                    binding.shimmerGameDetails.disableShimmer()
                }
                is Status.Failure -> showErrorLayout()
            }
        }
    }

    private fun showErrorLayout() {
        with(binding) {
            containerErrorGameDetails.root.makeVisible()
            recyclerViewGameDetailsScreenshots.makeGone()
            shimmerGameDetails.disableShimmer()
        }
    }

    private fun showGameDetails(gameDetails: GameDetails) {
        viewModel.loadGameScreenshotsById(gameDetails.id)
        setGameCardRating(gameDetails.metacritic)
        hideAllPlatformIcons()
        showGamePlatformIcons(gameDetails.parentPlatforms)
        setDetailsText(gameDetails)
        loadPoster(gameDetails.image)
        binding.scrollViewGameDetails.makeVisible()
    }

    private fun showScreenshotsRecycler(screenshots: List<Screenshot>) {
        binding.recyclerViewGameDetailsScreenshots.apply {
            if (itemDecorationCount == 0) setHorizontalDividersInPx(innerDivider, outerDivider)
            makeHorizontal()
            adapter = ScreenshotsAdapter(screenshots)
            makeVisible()
        }
    }

    private fun showGamePlatformIcons(parentPlatforms: List<Platform>) {
        parentPlatforms.forEach { platform ->
            when(platform.id) {
                ParentPlatform.Pc.id -> {
                    binding.imageViewGameDetailsPlatformPc.makeVisible()
                }
                ParentPlatform.Playstation.id -> {
                    binding.imageViewGameDetailsPlatformPlaystation.makeVisible()
                }
                ParentPlatform.Xbox.id -> {
                    binding.imageViewGameDetailsPlatformXbox.makeVisible()
                }
                ParentPlatform.MacOs.id -> {
                    binding.imageViewGameDetailsPlatformMacOs.makeVisible()
                }
            }
        }
    }

    private fun hideAllPlatformIcons() {
        with(binding) {
            imageViewGameDetailsPlatformPc.makeGone()
            imageViewGameDetailsPlatformPlaystation.makeGone()
            imageViewGameDetailsPlatformXbox.makeGone()
            imageViewGameDetailsPlatformMacOs.makeGone()
        }
    }

    private fun setDetailsText(gameDetails: GameDetails) {
        with(binding) {
            textViewGameDetailsName.text = gameDetails.name
            textViewGameDetailsAboutContent.text = gameDetails.description
            textViewGameDetailsGenresContent.text = gameDetails.genreNames
            textViewGameDetailsPlatformsContent.text = gameDetails.parentPlatformNames
            textViewGameDetailsDevelopersContent.text = gameDetails.developerNames
            textViewGameDetailsReleasedContent.text = getReleaseDate(gameDetails.released)
            textViewGameDetailsTagsContent.text = gameDetails.tags
        }
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
            binding.textViewGameDetailsRating.makeGone()
            return
        }

        binding.textViewGameDetailsRating.apply {
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

    private fun getReleaseDate(release: String?): String {
        if (release.isNullOrBlank()) return "N/A"

        val inputFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        val outputFormatter = SimpleDateFormat("dd MMMM yyyy", Locale.US)
        val releaseFormatted = inputFormatter.parse(release)!!

        return outputFormatter.format(releaseFormatted)
    }
}