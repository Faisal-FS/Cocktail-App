package com.example.cocktails.di

import com.example.cocktails.model.repository.DrinksRepository
import com.example.cocktails.model.repository.DrinksRepositoryImp
import com.example.cocktails.model.repository.data.source.remote.DrinksService
import com.example.cocktails.model.repository.data.source.remote.RemoteDataSource
import com.example.cocktails.model.repository.data.source.remote.RemoteDataSourceImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object DataModule {

    @Provides
    @ViewModelScoped
    fun provideRemoteDataSource(drinksService: DrinksService): RemoteDataSource{
        return RemoteDataSourceImp(drinksService)
    }

    @Provides
    @ViewModelScoped
    fun provideRepository(remoteDataSource: RemoteDataSource): DrinksRepository{
        return DrinksRepositoryImp(remoteDataSource)
    }

}