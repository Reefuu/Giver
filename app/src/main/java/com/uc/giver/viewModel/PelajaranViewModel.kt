package com.uc.giver.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uc.giver.model.DataX
import com.uc.giver.model.PelajaranState
import com.uc.giver.repository.PelajaranRepository
import com.uc.giver.view.events.AddPljrnEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class PelajaranViewModel @Inject constructor(private val repository: PelajaranRepository) :
    ViewModel() {

    var state by mutableStateOf(PelajaranState())

    //get all data pelajaran

    val _dataPljrn: MutableLiveData<ArrayList<DataX>> by lazy {
        MutableLiveData<ArrayList<DataX>>()
    }

    val dataPljrn: LiveData<ArrayList<DataX>>
        get() = _dataPljrn

    fun getAllDataPljrn() = viewModelScope.launch {
        repository.getAllDataPljrn()
            .let { response ->
                if (response.isSuccessful) {
                    _dataPljrn.postValue(response.body()?.data as ArrayList<DataX>?)
                } else {
                    Log.e("Get All Data Pelajaran", "Failed")
                }
            }
    }

    //get data pelajaran kelas

    val _dataPljrnKelas: MutableLiveData<ArrayList<DataX>> by lazy {
        MutableLiveData<ArrayList<DataX>>()
    }

    val dataPljrnKelas: LiveData<ArrayList<DataX>>
        get() = _dataPljrnKelas

    fun getDataPljrnKelas(kelas: Int) = viewModelScope.launch {
        repository.getDataPljrnKelas(kelas)
            .let { response ->
                if (response.isSuccessful) {
                    _dataPljrnKelas.postValue(response.body()?.data as ArrayList<DataX>?)
                } else {
                    Log.e("Get Data Pelajaran Kelas", "Failed")
                }
            }
    }

    fun onEvent(event: AddPljrnEvent){
        when(event){
            is AddPljrnEvent.OnPljrnNameChange -> {
                state = state.copy(nama_pelajaran = event.content)
            }
        }
    }

    fun addPljrn(
    ){
        viewModelScope.launch {
            repository.addPljrn(
                nama_pelajaran = state.nama_pelajaran,
                kelas = state.kelas,
                image = state.image,
                imageBanner = state.imageBanner,
            )
        }
    }


}
