package com.skay.imdb.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.skay.imdb.R
import com.skay.imdb.common.Constants
import com.skay.imdb.data.model.Movie
import com.skay.imdb.databinding.FragmentMovieDetailsBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MovieDetailsFragment : Fragment() {

    private var _binding: FragmentMovieDetailsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
        val movie = arguments?.getParcelable(Constants.KEY_MOVIE) as Movie?

        movie?.let {
            binding.title.text = it.name

            binding.rating.tvLabel.text = "Ratings"
            binding.rating.icon.setImageResource(android.R.drawable.star_big_on)
            binding.rating.tvValue.text = it.rating.toString()

            binding.popularity.tvLabel.text = "Popularity"
            binding.popularity.icon.setImageResource(R.drawable.ic_favorite_24)
            binding.popularity.tvValue.text = it.popularity.toString()

            binding.releaseData.tvLabel.text = "Release Date"
            binding.releaseData.tvValue.text = it.releaseDate
            binding.releaseData.icon.isVisible = false
            Glide.with(requireActivity()).load(it.imageUrl).into(binding.image)

            binding.tvOverviewText.text = it.description
        }

        binding.backImage.setOnClickListener {
            activity?.onBackPressedDispatcher?.onBackPressed()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun getInstance(movie: Movie): MovieDetailsFragment {
            val bundle = Bundle().apply {
                putParcelable(Constants.KEY_MOVIE, movie)
            }
            val frag = MovieDetailsFragment()
            frag.arguments = bundle
            return frag
        }
    }
}