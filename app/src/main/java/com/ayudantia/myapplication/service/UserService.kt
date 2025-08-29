package com.ayudantia.myapplication.service

import com.ayudantia.myapplication.model.PostItem
import com.ayudantia.myapplication.model.UserItem
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
//Metodos
interface UserService {
    @GET("/users")
    suspend fun getAllUsers():List<UserItem>
    @GET()
    suspend fun getAllPost():List<PostItem>
}
//"Iniciador" de llamadas a las API
object UserServiceFactory{
    fun makeUserService(): UserService{
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(UserService::class.java)
    }
}