package com.shipa.route.data.di

import com.shipa.route.data.services.WeatherServices
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by hvngoc on 7/29/22
 */
val networkModule = module {
    single<GsonConverterFactory> { GsonConverterFactory.create() }
    single<OkHttpClient> { provideOkHttp() }
    single<Retrofit> { providesRetrofit(get(), get()) }
    single<WeatherServices> { provideWeatherService(get()) }
}

internal fun provideOkHttp(): OkHttpClient {
    val client = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
            requestBuilder.addHeader("Connection", "keep-alive")
            val request = requestBuilder.build()
            chain.proceed(request)
        }
    return client.build()
}

internal fun providesRetrofit(
    gsonConverterFactory: GsonConverterFactory,
    okHttpClient: OkHttpClient
): Retrofit {
    return Retrofit.Builder()
        .baseUrl("http://google.com")
        .addConverterFactory(gsonConverterFactory)
        .client(okHttpClient)
        .build()
}

internal fun provideWeatherService(retrofit: Retrofit): WeatherServices {
    return retrofit.create(WeatherServices::class.java)
}