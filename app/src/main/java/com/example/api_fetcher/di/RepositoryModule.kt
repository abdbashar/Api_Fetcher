package com.example.api_fetcher.di

import com.example.api_fetcher.data.repository.StoreRepository
import com.example.api_fetcher.data.repository.StoreRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @ViewModelScoped
    @Binds
    abstract fun bindUserRepository(storeRepositoryImp: StoreRepositoryImp): StoreRepository
}