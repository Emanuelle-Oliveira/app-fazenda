package com.example.appfazenda.data.di

import com.example.appfazenda.data.farm.FirebaseFarmDataSource
import com.example.appfazenda.data.farm.IFarmDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

  @Singleton
  @Binds
  fun bindFarmDataSource(dataSource: FirebaseFarmDataSource): IFarmDataSource
}