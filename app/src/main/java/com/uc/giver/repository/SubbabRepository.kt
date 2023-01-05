package com.uc.giver.repository

import com.uc.giver.retrofit.EndPointApi
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

class SubbabRepository @Inject constructor(
    private val api:
    EndPointApi
) {
    suspend fun getDataSubbabBab(bab: Int) =
        api.getDataSubbabBab(bab)

    suspend fun addSubbab(
        materi: String,
        imageBanner: String,
        bab_id: Int,
    ) {
        val requestBody: RequestBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("materi", materi)
            .addFormDataPart("imageBanner", imageBanner)
            .addFormDataPart("bab_id", bab_id.toString())
            .build()

        api.addSubbab(requestBody)
    }
}