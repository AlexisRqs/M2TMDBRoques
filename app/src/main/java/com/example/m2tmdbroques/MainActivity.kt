package com.example.m2tmdbroques

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.m2tmdbroques.model.PersonPopularResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tmdbapi = ApiClient.instance.create(ITmdbApi::class.java)

        val call = tmdbapi.getPopularPerson(TMDB_API_KEY, 1)

        call.enqueue(object : Callback<PersonPopularResponse> {
            override fun onResponse(
                call: Call<PersonPopularResponse>,
                response: Response<PersonPopularResponse>
            ) {
                println("Response unsuccessful")
            }

            override fun onFailure(call: Call<PersonPopularResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        }   )
    }
}