package com.uc.giver.retrofit

import com.uc.giver.model.*
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path


interface EndPointApi {

    @GET("pelajaran")
    suspend fun getAllDataPljrn(): Response<PelajaranData>

    @POST("pelajaran")
    suspend fun addPljrn(@Body body: RequestBody?):ResponseBody?

    @POST("buku")
    suspend fun addBuku(@Body body: RequestBody?):ResponseBody?

    @POST("bab")
    suspend fun addBab(@Body body: RequestBody?):ResponseBody?

    @POST("subbab")
    suspend fun addSubbab(@Body body: RequestBody?):ResponseBody?

    @POST("login")
    suspend fun login(@Body body: RequestBody?):ResponseBody?

    @POST("register")
    suspend fun register(@Body body: RequestBody?):ResponseBody?

    @GET("users")
    suspend fun getDataUser(): Response<UserData>

    @PATCH("koin")
    suspend fun addKoin(@Body body: RequestBody?):ResponseBody?

    @GET("pelajaran/kelas/{kelas}")
    suspend fun getDataPljrnKelas(
        @Path("kelas")id:Int
    ):Response<PelajaranData>

    @GET("bab/buku/{buku}")
    suspend fun getDataBabBuku(
        @Path("buku")id:Int
    ):Response<BabData>

    @GET("buku/pelajaran/{pelajaran}")
    suspend fun getDataBukuPljrn(
        @Path("pelajaran")id:Int
    ):Response<BukuData>

    @GET("subbab/bab/{bab}")
    suspend fun getDataSubbabBab(
        @Path("bab")id:Int
    ):Response<SubbabData>

    @GET("quiz/subbab/{subbab}")
    suspend fun getDataQuizSubbab(
        @Path("subbab")id:Int
    ):Response<QuizData>

    @POST("quiz")
    suspend fun addQuiz(@Body body: RequestBody?):ResponseBody?
}