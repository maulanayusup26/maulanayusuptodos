package com.example.maulanayusuptodos.data.repository

import com.example.maulanayusuptodos.data.network.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TodoRepository {
    private val api: ApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(ApiService::class.java)
    }

    suspend fun getTodos() = api.getTodos()
    suspend fun getTodoDetail(id: Int) = api.getTodoDetail(id)
}