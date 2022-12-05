package com.uc.giver.retrofit

import com.uc.giver.model.Data
import com.uc.giver.model.MahasiswaData
import com.uc.giver.model.PelajaranData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EndPointApi {

    @GET("pelajaran")
    suspend fun getAllDataPljrn(): Response<PelajaranData>


}