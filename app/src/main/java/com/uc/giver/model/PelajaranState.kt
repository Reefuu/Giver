package com.uc.giver.model

data class PelajaranState(
    val nama_pelajaran: String = "",
    val kelas: Int = 0,
    val image: String = "",
    val imageBanner: String = "",
    val isLoading:  Boolean = false,
)
