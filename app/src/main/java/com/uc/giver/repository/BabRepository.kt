package com.uc.giver.repository

import com.uc.giver.retrofit.EndPointApi
import javax.inject.Inject

class BabRepository @Inject constructor(
    private val api:
    EndPointApi
) {
    suspend fun getDataBabBuku(buku: Int) =
        api.getDataBabBuku(buku)
}