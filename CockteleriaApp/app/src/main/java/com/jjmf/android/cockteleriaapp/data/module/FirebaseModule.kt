package com.jjmf.android.cockteleriaapp.data.module

import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FirebaseModule {

    @Singleton
    @Provides
    fun provideFirebase() = FirebaseFirestore.getInstance()

    @CocktailsCollection
    @Provides
    @Singleton
    fun provideCocktails() = provideFirebase().collection("Cocktails")

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class CocktailsCollection

}