package com.uc.giver.retrofit

import com.uc.giver.model.BabData
import com.uc.giver.model.BukuData
import com.uc.giver.model.PelajaranData
import com.uc.giver.model.SubbabData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface EndPointApi {

    @GET("pelajaran")
    suspend fun getAllDataPljrn(): Response<PelajaranData>

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
}