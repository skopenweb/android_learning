package com.skay.imdb.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(Constants.TAG, "onAttach# details frag")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(Constants.TAG, "onCreate# details frag")
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(Constants.TAG, "onCreateView# details frag")
        _binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        Log.d(Constants.TAG, "onViewCreated# details frag")
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

    override fun onResume() {
        super.onResume()
        Log.d(Constants.TAG, "onResume# details frag")
    }
    override fun onPause() {
        super.onPause()
        Log.d(Constants.TAG, "onPause# details frag")
    }

    override fun onStop() {
        super.onStop()
        Log.d(Constants.TAG, "onStop# details frag")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun getInstance(movie: Movie): MovieDetailsFragment =
            MovieDetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(Constants.KEY_MOVIE, movie)
                }
            }
    }
}