package com.example.m2tmdbroques

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.m2tmdbroques.databinding.ActivityMainBinding
import com.example.m2tmdbroques.model.PersonPopularResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val LOGTAG = MainActivity::class.simpleName

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Init recycler view
        binding.popularPersonRv.setHasFixedSize(true)
        binding.popularPersonRv.layoutManager = LinearLayoutManager(this)

        val tmdbapi = ApiClient.instance.create(ITmdbApi::class.java)

        val call = tmdbapi.getPopularPerson(TMDB_API_KEY, 1)

        call.enqueue(object : Callback<PersonPopularResponse> {
            override fun onResponse(
                call: Call<PersonPopularResponse>,
                response: Response<PersonPopularResponse>
            ) {
                Log.d(LOGTAG, response.body().toString())
            }

            override fun onFailure(call: Call<PersonPopularResponse>, t: Throwable) {
                Log.e(LOGTAG, "Call to getPopularPerson failed")
            }
        }   )
    }
}