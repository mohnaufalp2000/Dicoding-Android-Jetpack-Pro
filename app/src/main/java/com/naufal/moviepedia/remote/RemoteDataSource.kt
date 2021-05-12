package com.naufal.moviepedia.remote

import android.content.Context
import android.widget.Toast
import com.naufal.moviepedia.activity.MainActivity
import com.naufal.moviepedia.fragment.MoviesFragment
import com.naufal.moviepedia.fragment.TVShowsFragment
import com.naufal.moviepedia.model.*
import com.naufal.moviepedia.network.ConfigNetwork
import com.naufal.moviepedia.response.*
import com.naufal.moviepedia.util.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {

    private val idling = EspressoIdlingResource

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource().apply { instance = this }
            }
    }

    fun getMovies(callback: LoadMoviesCallback, context: Context?) {
        idling.increment()
        ConfigNetwork.getApi().getMovies().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val body = response.body()?.results
                val movieResults = ArrayList<MovieResp>()
                if (body != null) {
                    for (movie in body){
                        val movieResponse = MovieResp(
                            id = movie?.id,
                            title = movie?.title,
                            posterPath = movie?.posterPath,
                            rate = movie?.voteAverage,
                            language = movie?.originalLanguage
                        )
                        movieResults.add(movieResponse)
                    }
                }

                callback.onMoviesReceived(movieResults)

            }
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
            }
        })
        idling.decrement()
    }

    fun getTV(callback: LoadTVCallback, context: Context?) {
        idling.increment()
        ConfigNetwork.getApi().getShows().enqueue(object : Callback<TVResponse> {
            override fun onResponse(call: Call<TVResponse>, response: Response<TVResponse>) {
                val body = response.body()?.results

                val tvResults = ArrayList<TVResp>()
                if (body != null) {
                    for (tv in body){
                        val tvResponse = TVResp(
                            id = tv?.id,
                            title = tv?.name,
                            posterPath = tv?.posterPath,
                            rate = tv?.voteAverage,
                            language = tv?.originalLanguage
                        )
                        tvResults.add(tvResponse)
                    }
                }

                callback.onTVReceived(tvResults)

            }
            override fun onFailure(call: Call<TVResponse>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
            }
        })
        idling.decrement()

    }

    fun getDetailMovie(id: Int?, callback: LoadDetailMovieCallback, context: Context?) {
        idling.increment()
        ConfigNetwork.getApi().getDetailMovie(id).enqueue(object : Callback<DetailMovieResponse>{
            override fun onResponse(
                call: Call<DetailMovieResponse>,
                response: Response<DetailMovieResponse>
            ) {
                val body = response.body()
                val genreItems = response.body()?.genres
                val genreResults = ArrayList<MovieGenreResp>()

                if (genreItems != null) {
                    for (item in genreItems){
                        val genreResponse = MovieGenreResp(
                            id = item?.id,
                            name = item?.name
                        )
                        genreResults.add(genreResponse)
                    }
                }

                val detailMovie = DetailMovieResp(
                    id = body?.id,
                    title = body?.title,
                    posterPath = body?.posterPath,
                    rate = body?.voteAverage,
                    language = body?.originalLanguage,
                    overview = body?.overview,
                    runtime = body?.runtime,
                    release = body?.releaseDate,
                    genres = genreResults
                )

                callback.onDetailMovieReceived(detailMovie)
            }

            override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
            }
        })
        idling.decrement()
    }

    fun getDetailTV(id: Int?, callback: LoadDetailTVCallback, context: Context?) {
        idling.increment()
        ConfigNetwork.getApi().getDetailTV(id).enqueue(object : Callback<DetailTVResponse>{
            override fun onResponse(
                call: Call<DetailTVResponse>,
                response: Response<DetailTVResponse>
            ) {
                val body = response.body()
                val genreItems = response.body()?.genres
                val genreResults = ArrayList<TVGenreResp>()

                if (genreItems != null) {
                    for (item in genreItems){
                        val genreResponse = TVGenreResp(
                            id = item?.id,
                            name = item?.name
                        )
                        genreResults.add(genreResponse)
                    }
                }

                val detailTV = DetailTVResp(
                    id = body?.id,
                    title = body?.name,
                    posterPath = body?.posterPath,
                    rate = body?.voteAverage,
                    language = body?.originalLanguage,
                    overview = body?.overview,
                    runtime = body?.episodeRunTime,
                    released = body?.firstAirDate,
                    genres = genreResults
                )
             callback.onDetailTVReceived(detailTV)
            }

            override fun onFailure(call: Call<DetailTVResponse>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
            }
        })
        idling.decrement()
    }

    interface LoadMoviesCallback{
        fun onMoviesReceived(movieResp : ArrayList<MovieResp>)
    }

    interface LoadTVCallback{
        fun onTVReceived(tvResp: ArrayList<TVResp>)
    }

    interface LoadDetailMovieCallback {
        fun onDetailMovieReceived(detailMovieResp : DetailMovieResp)
    }

    interface LoadDetailTVCallback {
        fun onDetailTVReceived(detailTvResp: DetailTVResp)
    }


}
