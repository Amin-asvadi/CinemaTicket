package com.example.data_android.inject

import com.example.data.api.TicketApi
import com.example.data.repositories.RegisterTicketRepo
import com.example.data_android.repository.RegisterTicketImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
sealed class RegisterTicketApiModule {

    @Binds
    abstract fun provideOrderingRepository(repository:RegisterTicketImpl):RegisterTicketRepo

    companion object {
        @Provides
        fun provideApiService(retrofit: Retrofit): TicketApi {
            return retrofit.create(TicketApi::class.java)
        }
    }
}