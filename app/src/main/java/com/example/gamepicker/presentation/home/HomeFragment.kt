package com.example.gamepicker.presentation.home

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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

        startAllShimmers()

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
        viewModel.headerGame.observe(viewLifecycleOwner, { game ->
            Glide.with(requireContext())
                .load(game.background_image)
                .into(binding.imageViewHeaderGame)
            binding.shimmerHeader.disableShimmer()
            binding.constraintLayoutHeader.visibility = ConstraintLayout.VISIBLE
            binding.textViewHeaderGameName.text = game.name
        })

        viewModel.popularGames.observe(viewLifecycleOwner, {
            binding.recyclerViewPopular.setup(it)
            binding.shimmerPopular.disableShimmer()
            binding.textViewPopular.makeVisible()
            binding.recyclerViewPopular.makeVisible()
        })

        viewModel.openWorldGames.observe(viewLifecycleOwner, {
            binding.recyclerViewOpenWorld.setup(it)
            binding.shimmerOpenWorld.disableShimmer()
            binding.textViewOpenWorld.makeVisible()
            binding.recyclerViewOpenWorld.makeVisible()
        })

        viewModel.multiplayerGames.observe(viewLifecycleOwner, {
            binding.recyclerViewMultiplayer.setup(it)
            binding.shimmerMultiplayer.disableShimmer()
            binding.textViewMultiplayer.makeVisible()
            binding.recyclerViewMultiplayer.makeVisible()
        })

        viewModel.metacriticChoiceGames.observe(viewLifecycleOwner, {
            binding.recyclerViewMetacriticChoice.setup(it)
            binding.shimmerMetacriticChoice.disableShimmer()
            binding.textViewMetacriticChoice.makeVisible()
            binding.recyclerViewMetacriticChoice.makeVisible()
        })
        
        viewModel.fromSoftwareGames.observe(viewLifecycleOwner, {
            binding.recyclerViewFromSoftwareGames.setup(it)
            binding.shimmerFromSoftwareGames.disableShimmer()
            binding.textViewFromSoftwareGames.makeVisible()
            binding.recyclerViewFromSoftwareGames.makeVisible()
        })

        viewModel.playstationGames.observe(viewLifecycleOwner, {
            binding.recyclerViewPlaystationCollection.setup(it)
            binding.shimmerPlaystationCollection.disableShimmer()
            binding.textViewPlaystationCollection.makeVisible()
            binding.recyclerViewPlaystationCollection.makeVisible()
        })
    }

    private fun startAllShimmers() {
        with(binding) {
            shimmerHeader.startShimmer()
            shimmerPopular.startShimmer()
            shimmerOpenWorld.startShimmer()
            shimmerMultiplayer.startShimmer()
            shimmerMetacriticChoice.startShimmer()
            shimmerFromSoftwareGames.startShimmer()
            shimmerPlaystationCollection.startShimmer()
        }
    }

}