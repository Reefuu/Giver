package com.uc.giver.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uc.giver.model.BabState
import com.uc.giver.model.Data
import com.uc.giver.repository.BabRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BabViewModel @Inject constructor(private val repository: BabRepository) :
    ViewModel() {

    var state by mutableStateOf(BabState())

    //get data pelajaran kelas

    val _dataBabBuku: MutableLiveData<ArrayList<Data>> by lazy {
        MutableLiveData<ArrayList<Data>>()
    }

    val dataBabBuku: LiveData<ArrayList<Data>>
        get() = _dataBabBuku

    fun getDataBabBuku(buku: Int) = viewModelScope.launch {
        repository.getDataBabBuku(buku)
            .let { response ->
                if (response.isSuccessful) {
                    _dataBabBuku.postValue(response.body()?.data as ArrayList<Data>?)
                } else {
                    Log.e("Get Data Bab Buku", "Failed")
                }
            }
    }

    fun addBab(
    ){
        viewModelScope.launch {
            repository.addBab(
                bab_nama = state.bab_nama,
                buku_id = state.buku_id,
                imageCover = state.imageCover,
                imageBanner = state.imageBanner,
            )
        }
    }
}