package com.uc.giver.repository

import com.uc.giver.retrofit.EndPointApi
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

class BabRepository @Inject constructor(
    private val api:
    EndPointApi
) {
    suspend fun getDataBabBuku(buku: Int) =
        api.getDataBabBuku(buku)

    suspend fun addBab(
        bab_nama: String,
        buku_id: Int,
        imageCover: String,
        imageBanner: String,
    ) {
        val requestBody: RequestBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("bab_nama", bab_nama)
            .addFormDataPart("buku_id", buku_id.toString())
            .addFormDataPart("imageCover", imageCover)
            .addFormDataPart("imageBanner", imageBanner)
            .build()

        api.addBab(requestBody)
    }
}