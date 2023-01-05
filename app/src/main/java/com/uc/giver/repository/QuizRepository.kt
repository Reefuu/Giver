package com.uc.giver.repository

import com.uc.giver.mod.DataOrException
import com.uc.giver.model.DataXQuiz
import com.uc.giver.retrofit.EndPointApi
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

class QuizRepository @Inject constructor(
    private val api: EndPointApi
//    private val dataOrException: DataOrException<ArrayList<DataXQuiz>, Boolean, Exception>
    ) {
//        suspend fun getDataQuizSubbab(subbab: Int) =
//            api.getDataQuizSubbab(subbab)

    suspend fun getDataQuizSubbab(subbab: Int) =
        api.getDataQuizSubbab(subbab)

        suspend fun addQuiz(
            pertanyaan: String,
            jawaban: String,
            subbab_id: Int,
        ) {
            val requestBody: RequestBody = MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("pertanyaan", pertanyaan)
                .addFormDataPart("jawaban", jawaban)
                .addFormDataPart("subbab_id", subbab_id.toString())
                .build()

            api.addQuiz(requestBody)
        }

}