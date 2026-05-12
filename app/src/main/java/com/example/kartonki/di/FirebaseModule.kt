package com.example.kartonki.di

import android.content.Context
import com.example.kartonki.BuildConfig
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

    // mobilesdk_app_id из google-services.json. Release и debug — разные
    // Android-app'ы в Firebase Console, чтобы debug-события (user_id=dev_einnerin)
    // не смешивались с production-стримом и debug-сборка могла использовать
    // свой OAuth client + SHA-1 debug-keystore для Google Sign-In.
    private const val RELEASE_APP_ID = "1:75116979020:android:e18e4f82b679f85ea3a5e9"
    private const val DEBUG_APP_ID = "1:75116979020:android:03c5b03c9389e64da3a5e9"

    @Provides
    @Singleton
    fun provideFirebaseApp(@ApplicationContext context: Context): FirebaseApp {
        val existing = FirebaseApp.getApps(context)
        if (existing.isNotEmpty()) return FirebaseApp.getInstance()

        val applicationId = if (BuildConfig.DEBUG) DEBUG_APP_ID else RELEASE_APP_ID
        val options = FirebaseOptions.Builder()
            .setApplicationId(applicationId)
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
