package com.example.challenge1.service

import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import rx.Observable


interface SampleService {
    @GET("v2/upcomingGuides/")
    fun getUpcomingGuides(): Observable<RequestResults>
}

object SampleServiceBuilder {
    fun buildService(): SampleService {
        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://guidebook.com/service/")
            .build()
        return retrofit.create(SampleService::class.java)
    }
}

data class RequestResults(
    val data: List<Guide>
)

data class Guide(
    val name: String,
    val url: String,
    val icon: String,
    val startDate: String,
    val endDate: String,
    val venue: Venue
)

data class Venue(
    val city: String,
    val state: String
)

