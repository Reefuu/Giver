package com.uc.giver.repository

import com.uc.giver.retrofit.EndPointApi
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject


class PelajaranRepository @Inject constructor(
    private val api:
    EndPointApi
) {
    suspend fun getAllDataPljrn() =
        api.getAllDataPljrn()

    suspend fun getDataPljrnKelas(kelas: Int) =
        api.getDataPljrnKelas(kelas)

    suspend fun addPljrn(
        nama_pelajaran: String,
        kelas: Int,
        image: String,
        imageBanner: String,
    ) {
        val requestBody: RequestBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("nama_pelajaran", nama_pelajaran)
            .addFormDataPart("kelas", kelas.toString())
            .addFormDataPart("image", image)
            .addFormDataPart("imageBanner", imageBanner)
            .build()

        api.addPljrn(requestBody)
    }

}