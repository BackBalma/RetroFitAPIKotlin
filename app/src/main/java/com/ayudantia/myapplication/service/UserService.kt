package com.ayudantia.myapplication.service

import com.ayudantia.myapplication.model.UserItem
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface UserService {
    @GET("/users")
    suspend fun getAllUsers():ArrayList<UserItem>
}
object UserServiceFactory{
    fun makeUserService(): UserService{
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(UserService::class.java)
    }
}