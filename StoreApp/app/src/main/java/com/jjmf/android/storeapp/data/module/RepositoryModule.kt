package com.jjmf.android.storeapp.data.module

import com.jjmf.android.storeapp.data.repository.ItemRepository
import com.jjmf.android.storeapp.data.repository.ItemRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideItem(impl: ItemRepositoryImpl): ItemRepository

}