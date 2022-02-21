package com.ascien.woopayfirsttaskmvp.model.api

import com.ascien.woopayfirsttaskmvp.model.datamodel.Fact
import retrofit2.Call
import retrofit2.http.GET

interface JobServices {
    @GET("fact/")
    fun getFact(): Call<Fact>
}