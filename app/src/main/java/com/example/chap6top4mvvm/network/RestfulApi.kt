package com.example.chap6top4mvvm.network

import com.example.chap6top4mvvm.model.ResponseDataCarItem
import retrofit2.Call
import retrofit2.http.GET

interface RestfulApi {
    @GET("admin/car")
    fun getAllCar() : Call<List<ResponseDataCarItem>>
}