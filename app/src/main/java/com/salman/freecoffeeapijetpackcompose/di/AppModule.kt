package com.salman.freecoffeeapijetpackcompose.di

import com.salman.freecoffeeapijetpackcompose.data.remote.ApiInterface
import com.salman.freecoffeeapijetpackcompose.data.repository.CoffeeRepository
import com.salman.freecoffeeapijetpackcompose.domain.repository_imp.CoffeeRepositoryImp
import com.salman.freecoffeeapijetpackcompose.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): ApiInterface = Retrofit.Builder().baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build().create(ApiInterface::class.java)

    @Provides
    @Singleton
    fun provideCoffeeRepository(apiInterface: ApiInterface): CoffeeRepository {
        return CoffeeRepositoryImp(apiInterface)
    }

}