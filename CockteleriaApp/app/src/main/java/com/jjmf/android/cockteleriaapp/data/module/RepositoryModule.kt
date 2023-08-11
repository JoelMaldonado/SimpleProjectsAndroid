package com.jjmf.android.cockteleriaapp.data.module

import com.jjmf.android.cockteleriaapp.data.repository.CocktailRepository
import com.jjmf.android.cockteleriaapp.data.repository.CocktailRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun cocktailRepo(impl: CocktailRepositoryImpl) : CocktailRepository

}