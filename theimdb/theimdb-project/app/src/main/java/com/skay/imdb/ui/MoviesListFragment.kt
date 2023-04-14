package com.skay.imdb.ui

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.skay.imdb.business.Presenter
import com.skay.imdb.business.PresenterImpl
import com.skay.imdb.common.DependencyContainer
import com.skay.imdb.data.model.Movie
import com.skay.imdb.databinding.FragmentAllMoviesBinding
import com.skay.imdb.ui.contract.IView
import com.skay.imdb.ui.contract.MoviesListener

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MoviesListFragment : Fragment(), IView {

    private var _binding: FragmentAllMoviesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var _presenter: Presenter? = null
    private val presenter get() = _presenter!!

    private var listener: MoviesListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        _presenter = PresenterImpl(this)
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
        presenter.loadMovies()
    }

    private fun initView() {
        binding.moviesList.apply {
            adapter =
                MoviesListAdapter(emptyList(), ::onRowClick)
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        presenter.clear()
        _presenter = null
    }

    override fun updateView(movies: List<Movie>) {
        Handler(Looper.getMainLooper()).post {
            (binding.moviesList.adapter as MoviesListAdapter).setItems(movies)
        }
    }

    override fun onRowClick(movie: Movie) {
        listener?.onRowClick(movie)
    }
}