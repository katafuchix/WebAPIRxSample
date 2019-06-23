package com.example.webapirxsample.model.api

import com.example.webapirxsample.model.Item
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable

class DmmApi {
    val service: DmmApiInterface

    init {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val gson = GsonBuilder().setLenient().create()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.dmm.com/")
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient.build())
            .build()

        service = retrofit.create<DmmApiInterface>(DmmApiInterface::class.java)
    }

    fun loadItems(): Observable<Item>? {
        return service.listItems()
            .flatMap { dmmApiResult -> Observable.from(dmmApiResult.result.items) }
    }

    fun loadItems(keyword: String): Observable<Item>? {
        return service.keywordSearch(keyword)
            .flatMap { dmmApiResult -> Observable.from(dmmApiResult.result.items) }
    }
}