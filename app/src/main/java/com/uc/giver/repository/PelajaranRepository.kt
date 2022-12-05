package com.uc.giver.repository

import com.uc.giver.retrofit.EndPointApi
import javax.inject.Inject

class PelajaranRepository @Inject constructor(
    private val api:
    EndPointApi
) {
    suspend fun getAllDataPljrn() =
        api.getAllDataPljrn()

}