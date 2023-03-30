package com.skay.imdb.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.skay.imdb.data.MoviesRepository
import com.skay.imdb.data.model.Movie
import com.skay.imdb.databinding.FragmentAllMoviesBinding
import com.skay.imdb.ui.contract.MoviesListener

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MoviesListFragment : Fragment() {

    private var _binding: FragmentAllMoviesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var listener: MoviesListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener = context as? MoviesListener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
        binding.moviesList.apply {
            adapter = MoviesListAdapter(MoviesRepository.getMovies(), ::onMovieClick)
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun onMovieClick(item: Movie) {
        listener?.onRowClick(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}