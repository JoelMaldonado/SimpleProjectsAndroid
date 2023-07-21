package com.jjmf.android.cocktailandroidapp.data.module

import com.jjmf.android.cocktailandroidapp.data.repository.CocktailRepositoryImpl
import com.jjmf.android.cocktailandroidapp.data.repository.DrinkRepositoryImpl
import com.jjmf.android.cocktailandroidapp.data.repository.FiltroRepositoryImpl
import com.jjmf.android.cocktailandroidapp.domain.repository.CocktailRepository
import com.jjmf.android.cocktailandroidapp.domain.repository.DrinkRepository
import com.jjmf.android.cocktailandroidapp.domain.repository.FiltroRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideCocktail(impl: CocktailRepositoryImpl): CocktailRepository

    @Binds
    abstract fun provideFiltros(impl: FiltroRepositoryImpl): FiltroRepository

    @Binds
    abstract fun provideDrink(impl: DrinkRepositoryImpl): DrinkRepository
}