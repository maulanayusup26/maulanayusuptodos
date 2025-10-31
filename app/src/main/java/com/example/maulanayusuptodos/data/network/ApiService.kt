package com.example.maulanayusuptodos.data.network

import com.example.maulanayusuptodos.data.model.Todo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("todos")
    suspend fun getTodos(): Response<List<Todo>>

    @GET("todos/{id}")
    suspend fun getTodoDetail(@Path("id") id: Int): Response<Todo>
}