package com.example.appfazenda.farm.di
import com.example.appfazenda.farm.usecases.CreateFarmUseCase
import com.example.appfazenda.farm.usecases.DeleteFarmUseCase
import com.example.appfazenda.farm.usecases.GetFarmsByIdUseCase
import com.example.appfazenda.farm.usecases.GetFarmsByNameUseCase
import com.example.appfazenda.farm.usecases.GetFarmsUseCase
import com.example.appfazenda.farm.usecases.UpdateFarmUseCase
import com.example.appfazenda.farm.usecases.contracts.ICreateFarmUseCase
import com.example.appfazenda.farm.usecases.contracts.IDeleteFarmUseCase
import com.example.appfazenda.farm.usecases.contracts.IGetFarmsByIdUseCase
import com.example.appfazenda.farm.usecases.contracts.IGetFarmsByNameUseCase
import com.example.appfazenda.farm.usecases.contracts.IGetFarmsUseCase
import com.example.appfazenda.farm.usecases.contracts.IUpdateFarmUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
interface IFarmModule {

  @Binds
  fun bindCreateFarmUseCase(useCase: CreateFarmUseCase): ICreateFarmUseCase

  @Binds
  fun bindUpdateFarmUseCase(useCase: UpdateFarmUseCase): IUpdateFarmUseCase

  @Binds
  fun bindGetFarmsUseCase(useCase: GetFarmsUseCase): IGetFarmsUseCase

  @Binds
  fun bindGetFarmsByIdUseCase(useCase: GetFarmsByIdUseCase): IGetFarmsByIdUseCase

  @Binds
  fun bindGetFarmsByNameUseCase(useCase: GetFarmsByNameUseCase): IGetFarmsByNameUseCase

  @Binds
  fun bindDeleteFarmUseCase(useCase: DeleteFarmUseCase): IDeleteFarmUseCase
}