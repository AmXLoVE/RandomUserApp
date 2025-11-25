package ru.myapplication.randomuserapp.data.datasource.remote

import retrofit2.http.GET
import retrofit2.http.Query
import ru.myapplication.randomuserapp.data.datasource.remote.model.UserListDto

interface RandomUserApi {

    @GET
    suspend fun getUserList(
        @Query("gender") gender: String? = null,
        @Query("name") name: String? = null,
        @Query("location") location: String? = null,
        @Query("email") email: String? = null,
        @Query("login") login: String? = null,
        @Query("registered") registered: String? = null,
        @Query("dob") dob: String? = null,
        @Query("phone") phone: String? = null,
        @Query("cell") cell: String? = null,
        @Query("id") id: String? = null,
        @Query("picture") picture: String? = null,
        @Query("nat") nat: String? = null,
    ): UserListDto
}
