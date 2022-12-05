package com.uc.giver.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uc.giver.model.Data
import com.uc.giver.model.DataX
import com.uc.giver.repository.PelajaranRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class PelajaranViewModel @Inject constructor(private val repository: PelajaranRepository) :
    ViewModel() {

    //get all data mahasiswa

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


}