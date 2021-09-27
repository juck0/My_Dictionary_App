package com.theChance2.mydictionaryapp

import android.util.Log
import com.google.gson.Gson
import okhttp3.FormBody

import okhttp3.OkHttpClient
import okhttp3.Request

object Network {
    var result = ""
    private val client = OkHttpClient()
    private val gson = Gson()
    private val builder = FormBody.Builder()
    fun makeRequestUsingOkhttp(): State<Questions> {
        val request = Request.Builder()
            .url(UrlModifier.url)
            .post(builder.build())
            .build()
        val response = client.newCall(request).execute()
        return if (response.isSuccessful){
            val responseQuiz = gson.fromJson(response.body?.string(), Questions::class.java)
            Log.i("responseQuiz", responseQuiz.toString())
             result = responseQuiz.translatedText.toString()
            State.Success(responseQuiz)
        }else{
            State.Error(response.message)
        }

    }
}
