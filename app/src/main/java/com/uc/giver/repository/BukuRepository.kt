package com.uc.giver.repository

import com.uc.giver.retrofit.EndPointApi
import javax.inject.Inject

class BukuRepository @Inject constructor(
    private val api:
    EndPointApi
) {
    suspend fun getDataBukuPljrn(pelajaran: Int) =
        api.getDataBukuPljrn(pelajaran)
}