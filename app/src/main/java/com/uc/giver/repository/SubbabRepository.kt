package com.uc.giver.repository

import com.uc.giver.retrofit.EndPointApi
import javax.inject.Inject

class SubbabRepository @Inject constructor(
    private val api:
    EndPointApi
) {
    suspend fun getDataSubbabBab(bab: Int) =
        api.getDataSubbabBab(bab)
}