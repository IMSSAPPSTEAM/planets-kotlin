package dev.damodaran.planets.api

import retrofit2.Call
import retrofit2.http.GET

interface PlanetsApiService {
    @GET("/ananddamodaran/demo/master/db.json")
    fun getPlanets(): Call<Response>
}