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
import com.uc.giver.model.DataXXXX
import com.uc.giver.model.PelajaranState
import com.uc.giver.model.UserState
import com.uc.giver.repository.PelajaranRepository
import com.uc.giver.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class UserViewModel @Inject constructor(private val repository: UserRepository) :
    ViewModel() {

    var state by mutableStateOf(UserState())

//    get data user

    val _dataUser: MutableLiveData<ArrayList<DataXXXX>> by lazy {
        MutableLiveData<ArrayList<DataXXXX>>()
    }

    val dataUser: LiveData<ArrayList<DataXXXX>>
        get() = _dataUser

    fun getDataUser() = viewModelScope.launch {
        repository.getDataUser()
            .let { response ->
                if (response.isSuccessful) {
                    _dataUser.postValue(response.body()?.data as ArrayList<DataXXXX>?)
                } else {
                    Log.e("Get Data User", "Failed")
                }
            }
    }


    fun login(
    ){
        viewModelScope.launch {
            repository.login(
                nama = state.nama,
                password = state.password,
            )
        }
    }
    fun addKoin(
    ){
        viewModelScope.launch {
            repository.addKoin(
                nama = state.nama,
                koin = state.koin,
            )
        }
    }
    fun register(
    ){
        viewModelScope.launch {
            repository.register(
                nama = state.nama,
                email = state.email,
                password = state.password,
            )
        }
    }


}
