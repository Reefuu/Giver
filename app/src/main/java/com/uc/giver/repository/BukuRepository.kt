package com.uc.giver.repository

import com.uc.giver.retrofit.EndPointApi
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

class BukuRepository @Inject constructor(
    private val api:
    EndPointApi
) {
    suspend fun getDataBukuPljrn(pelajaran: Int) =
        api.getDataBukuPljrn(pelajaran)

    suspend fun addBuku(
        nama_buku: String,
        pelajaran_id: Int,
        imageCover: String,
        imageBanner: String,
    ) {
        val requestBody: RequestBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("nama_buku", nama_buku)
            .addFormDataPart("pelajaran_id", pelajaran_id.toString())
            .addFormDataPart("imageCover", imageCover)
            .addFormDataPart("imageBanner", imageBanner)
            .build()

        api.addBuku(requestBody)
    }
}