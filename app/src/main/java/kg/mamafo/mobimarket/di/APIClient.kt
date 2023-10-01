package kg.mamafo.mobimarket.di

import kg.mamafo.mobimarket.data.remote.MobiMarketAPI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { provideAPI(get()) }
    single { provideRetrofit(get()) }
    factory { provideOkHttpClient() }
}

fun provideAPI(retrofit: Retrofit): MobiMarketAPI {
    return retrofit.create(MobiMarketAPI::class.java)
}

fun provideOkHttpClient(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    return OkHttpClient().newBuilder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(interceptor)
        .build()
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://207.154.198.7:8000/swagger/")
        .client(okHttpClient)
        .build()
}