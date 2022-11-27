package com.uc.giver.repository

import com.uc.giver.retrofit.EndPointApi
import javax.inject.Inject

class MahasiswaRepository @Inject constructor(
    private val api:
    EndPointApi
) {
    suspend fun getAllDataMhsw() =
        api.getAllDataMhs()

}