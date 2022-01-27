package com.example.gamepicker.presentation.home

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.LoadResult
import com.example.domain.entity.game.Game
import com.example.gamepicker.DimensionConverter
import com.example.gamepicker.databinding.FragmentHomeBinding
import com.example.gamepicker.presentation.home.adapter.GameCardsAdapter
import com.example.gamepicker.utils.disableShimmer
import com.example.gamepicker.utils.makeHorizontal
import com.example.gamepicker.utils.makeVisible
import com.example.gamepicker.utils.setDividersInPx

private const val INNER_DIVIDER_DP = 8
private const val OUTER_DIVIDER_DP = 16

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    private lateinit var converter: DimensionConverter
    private val innerDivider by lazy { converter.convertDpToPx(INNER_DIVIDER_DP) }
    private val outerDivider by lazy { converter.convertDpToPx(OUTER_DIVIDER_DP) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        converter = DimensionConverter(context)
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

        initializeObservers()

        return binding.root
    }

    private fun RecyclerView.setup(games: List<Game>) {
        makeHorizontal()
        setDividersInPx(innerDivider = innerDivider, outerDivider = outerDivider)
        adapter = GameCardsAdapter(games)
    }

    private fun initializeObservers() {
        viewModel.headerGame.observe(viewLifecycleOwner, { result ->
            when (result) {
                is LoadResult.Success -> {
                    val game = result.data

                    Glide.with(requireContext())
                        .load(game.background_image)
                        .into(binding.imageViewHeaderGame)
                    binding.shimmerHeader.disableShimmer()
                    binding.constraintLayoutHeader.visibility = ConstraintLayout.VISIBLE
                    binding.textViewHeaderGameName.text = game.name
                }
                is LoadResult.Failure -> {
                    Toast.makeText(
                        requireContext(),
                        "Error ${result.message}",
                        Toast.LENGTH_LONG).show()
                }
            }
        })

        viewModel.popularGames.observe(viewLifecycleOwner, { result ->
            when (result) {
                is LoadResult.Success -> {
                  binding.recyclerViewPopular.setup(result.data)
                  binding.shimmerPopular.disableShimmer()
                  binding.textViewPopular.makeVisible()
                  binding.recyclerViewPopular.makeVisible()
              }
                is LoadResult.Failure -> {}
            }
        })

        viewModel.openWorldGames.observe(viewLifecycleOwner, { result ->
            when (result) {
                is LoadResult.Success -> {
                    binding.recyclerViewOpenWorld.setup(result.data)
                    binding.shimmerOpenWorld.disableShimmer()
                    binding.textViewOpenWorld.makeVisible()
                    binding.recyclerViewOpenWorld.makeVisible()
                }
                is LoadResult.Failure -> {}
            }
        })

        viewModel.multiplayerGames.observe(viewLifecycleOwner, { result ->
            when (result) {
                is LoadResult.Success -> {
                    binding.recyclerViewMultiplayer.setup(result.data)
                    binding.shimmerMultiplayer.disableShimmer()
                    binding.textViewMultiplayer.makeVisible()
                    binding.recyclerViewMultiplayer.makeVisible()
                }
                is LoadResult.Failure -> {}
            }
        })

        viewModel.metacriticChoiceGames.observe(viewLifecycleOwner, { result ->
            when (result) {
                is LoadResult.Success -> {
                    binding.recyclerViewMetacriticChoice.setup(result.data)
                    binding.shimmerMetacriticChoice.disableShimmer()
                    binding.textViewMetacriticChoice.makeVisible()
                    binding.recyclerViewMetacriticChoice.makeVisible()
                }
                is LoadResult.Failure -> {}
            }
        })

        viewModel.fromSoftwareGames.observe(viewLifecycleOwner, { result ->
            when (result) {
                is LoadResult.Success -> {
                    binding.recyclerViewFromSoftwareGames.setup(result.data)
                    binding.shimmerFromSoftwareGames.disableShimmer()
                    binding.textViewFromSoftwareGames.makeVisible()
                    binding.recyclerViewFromSoftwareGames.makeVisible()
                }
                is LoadResult.Failure -> {}
            }
        })

        viewModel.playstationGames.observe(viewLifecycleOwner, { result ->
            when (result) {
                is LoadResult.Success -> {
                    binding.recyclerViewPlaystationCollection.setup(result.data)
                    binding.shimmerPlaystationCollection.disableShimmer()
                    binding.textViewPlaystationCollection.makeVisible()
                    binding.recyclerViewPlaystationCollection.makeVisible()
                }
                is LoadResult.Failure -> {}
            }
        })
    }
}