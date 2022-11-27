package com.uc.giver.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uc.giver.model.Data
import com.uc.giver.repository.MahasiswaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class MahasiswaViewModel @Inject constructor(private val repository: MahasiswaRepository) :
    ViewModel() {

    //get all data mahasiswa

    val _dataMhs: MutableLiveData<ArrayList<Data>> by lazy {
        MutableLiveData<ArrayList<Data>>()
    }

    val dataMhs: LiveData<ArrayList<Data>>
        get() = _dataMhs

    fun getAllDataMhsw() = viewModelScope.launch {
        repository.getAllDataMhsw()
            .let { response ->
                if (response.isSuccessful) {
                    _dataMhs.postValue(response.body()?.data as ArrayList<Data>?)
                } else {
                    Log.e("Get All Data Mahasiswa", "Failed")
                }
            }
    }


}