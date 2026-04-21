package com.example.kartonki.di

import com.example.kartonki.analytics.AnalyticsManager
import com.example.kartonki.analytics.FirebaseAnalyticsManager
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AnalyticsProvidesModule {

    @Provides
    @Singleton
    fun provideFirebaseAnalytics(firebaseApp: FirebaseApp): FirebaseAnalytics {
        // firebaseApp тянется из FirebaseModule — провайдер инициализирует Firebase
        // до обращения к Analytics. Firebase.analytics ищет default FirebaseApp.
        return Firebase.analytics
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class AnalyticsBindsModule {
    @Binds
    @Singleton
    abstract fun bindAnalyticsManager(
        impl: FirebaseAnalyticsManager,
    ): AnalyticsManager
}
