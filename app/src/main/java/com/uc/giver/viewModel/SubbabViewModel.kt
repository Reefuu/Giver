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
import com.uc.giver.model.DataXXX
import com.uc.giver.model.SubbabState
import com.uc.giver.repository.SubbabRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SubbabViewModel @Inject constructor(private val repository: SubbabRepository) :
    ViewModel() {

    var state by mutableStateOf(SubbabState())

    //get data pelajaran kelas

    val _dataSubbabBab: MutableLiveData<ArrayList<DataXXX>> by lazy {
        MutableLiveData<ArrayList<DataXXX>>()
    }

    val dataSubbabBab: LiveData<ArrayList<DataXXX>>
        get() = _dataSubbabBab

    fun getDataSubbabBab(bab: Int) = viewModelScope.launch {
        repository.getDataSubbabBab(bab)
            .let { response ->
                if (response.isSuccessful) {
                    _dataSubbabBab.postValue(response.body()?.data as ArrayList<DataXXX>?)
                } else {
                    Log.e("Get Data Subbab Bab", "Failed")
                }
            }
    }

    fun addSubbab(
    ){
        viewModelScope.launch {
            repository.addSubbab(
                materi = state.materi,
                imageBanner = state.imageBanner,
                bab_id = state.bab_id,
            )
        }
    }
}