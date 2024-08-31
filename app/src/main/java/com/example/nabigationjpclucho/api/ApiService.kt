package com.example.nabigationjpclucho.api

import com.example.nabigationjpclucho.model.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getUsers(): Call<List<User>>
}