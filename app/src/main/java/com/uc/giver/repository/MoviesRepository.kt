//package com.uc.giver.repository
//
//import com.uc.week4retrofit.retrofit.EndPointApi
//import javax.inject.Inject
//
//class MoviesRepository @Inject constructor(
//    private val api:
//    EndPointApi
//) {
//    suspend fun getNowPlayingResults(apiKey: String, language: String, page: Int) =
//        api.getNowPlaying(apiKey, language, page)
//
//    suspend fun getMovieDetailsResults(movieId: Int, apiKey: String) =
//        api.getMovieDetails(movieId, apiKey)
//
//}