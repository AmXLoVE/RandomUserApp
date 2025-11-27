package ru.myapplication.randomuserapp.data.datasource.remote

import retrofit2.http.GET
import retrofit2.http.Query
import ru.myapplication.randomuserapp.data.datasource.remote.model.UserListDto

interface RandomUserApi {

    @GET("/api")
    suspend fun getUserList(
        @Query("page") page: Int? = null,
        @Query("results") results: Int? = null,
        @Query("gender") gender: String? = null,
        @Query("nat") nat: String? = null,
    ): UserListDto
}
