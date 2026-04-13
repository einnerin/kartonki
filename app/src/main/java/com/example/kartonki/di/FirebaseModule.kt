package com.example.kartonki.di

import android.content.Context
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

    @Provides
    @Singleton
    fun provideFirebaseApp(@ApplicationContext context: Context): FirebaseApp {
        // Инициализируем вручную, так как google-services плагин не применён
        val existing = FirebaseApp.getApps(context)
        if (existing.isNotEmpty()) return FirebaseApp.getInstance()

        val options = FirebaseOptions.Builder()
            .setApplicationId("1:75116979020:android:77edb30deed49a3fa3a5e9")
            .setApiKey("AIzaSyDynvSZY0b2zBRoqba3E_9QkYLVGD8kM0w")
            .setProjectId("kartonki-e18c5")
            .setGcmSenderId("75116979020")
            .setDatabaseUrl("https://kartonki-e18c5-default-rtdb.europe-west1.firebasedatabase.app")
            .setStorageBucket("kartonki-e18c5.firebasestorage.app")
            .build()
        return FirebaseApp.initializeApp(context, options)!!
    }

    @Provides
    @Singleton
    fun provideFirebaseAuth(app: FirebaseApp): FirebaseAuth = FirebaseAuth.getInstance(app)

    @Provides
    @Singleton
    fun provideFirebaseDatabase(app: FirebaseApp): FirebaseDatabase =
        FirebaseDatabase.getInstance(app, "https://kartonki-e18c5-default-rtdb.europe-west1.firebasedatabase.app").also {
            it.setPersistenceEnabled(true)
        }

    @Provides
    @Singleton
    fun provideFirestore(app: FirebaseApp): FirebaseFirestore = FirebaseFirestore.getInstance(app)
}
