package com.uc.giver.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uc.giver.model.BukuState
import com.uc.giver.model.DataXX
import com.uc.giver.repository.BukuRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BukuViewModel @Inject constructor(private val repository: BukuRepository) :
    ViewModel() {

    var state by mutableStateOf(BukuState())

    //get data pelajaran kelas

    val _dataBukuPljrn: MutableLiveData<ArrayList<DataXX>> by lazy {
        MutableLiveData<ArrayList<DataXX>>()
    }

    val dataBukuPljrn: LiveData<ArrayList<DataXX>>
        get() = _dataBukuPljrn

    fun getDataBukuPljrn(pelajaran: Int) = viewModelScope.launch {
        repository.getDataBukuPljrn(pelajaran)
            .let { response ->
                if (response.isSuccessful) {
                    _dataBukuPljrn.postValue(response.body()?.data as ArrayList<DataXX>?)
                } else {
                    Log.e("Get Data Buku Pelajaran", "Failed")
                }
            }
    }

    fun addBuku(
    ){
        viewModelScope.launch {
            repository.addBuku(
                nama_buku = state.nama_buku,
                pelajaran_id = state.pelajaran_id,
                imageCover = state.imageCover,
                imageBanner = state.imageBanner,
            )
        }
    }
}