package com.example.chap6top4mvvm.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClien {
    const val BASE_URL = "https://rent-cars-api.herokuapp.com/"

    private val logging : HttpLoggingInterceptor
        get(){
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            return  httpLoggingInterceptor.apply {
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            }
        }
    private val clint = OkHttpClient.Builder().addInterceptor(logging).build()

    val instance : RestfulApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(RestfulApi::class.java)
    }
}