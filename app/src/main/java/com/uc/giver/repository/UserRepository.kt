package com.uc.giver.repository

import com.uc.giver.retrofit.EndPointApi
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val api:
    EndPointApi
) {
    suspend fun login(
        nama: String,
        password: String,
    ) {
        val requestBody: RequestBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("username", nama)
            .addFormDataPart("password", password)
            .build()

        api.login(requestBody)
    }
    suspend fun register(
        nama: String,
        email: String,
        password: String,
    ) {
        val requestBody: RequestBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("nama", nama)
            .addFormDataPart("email", email)
            .addFormDataPart("password", password)
            .build()

        api.register(requestBody)
    }
}