package com.uc.giver.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uc.giver.model.DataXQuiz
import com.uc.giver.model.QuizState
import com.uc.giver.repository.QuizRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(private val repository: QuizRepository) :
    ViewModel() {

        var state by mutableStateOf(QuizState())

        //get data quiz subbab

        val _dataQuizSubbab: MutableLiveData<ArrayList<DataXQuiz>> by lazy {
            MutableLiveData<ArrayList<DataXQuiz>>()
        }

        val dataQuizSubbab: LiveData<ArrayList<DataXQuiz>>
            get() = _dataQuizSubbab

        fun getDataQuizSubbab(subbab: Int) = viewModelScope.launch {
            repository.getDataQuizSubbab(subbab)
                .let { response ->
                    if (response.isSuccessful) {
                        _dataQuizSubbab.postValue(response.body()?.data as ArrayList<DataXQuiz>?)
                    } else {
                        Log.e("Get Data Quiz Subbab ", "Failed")
                    }
                }
        }

        fun addQuiz(
        ) {
            viewModelScope.launch {
                repository.addQuiz(
                    pertanyaan = state.pertanyaan,
                    jawaban = state.jawaban,
                    subbab_id = state.subbab_id,
                )
            }
        }
    }
