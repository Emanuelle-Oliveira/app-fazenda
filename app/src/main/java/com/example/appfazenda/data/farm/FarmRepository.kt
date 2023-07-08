package com.example.appfazenda.data.farm

import com.example.appfazenda.farm.model.Farm
import javax.inject.Inject

class FarmRepository @Inject constructor(
  private val dataSource: IFarmDataSource
  ) {

  suspend fun createFarm(farm: Farm): Farm
  = dataSource.createFarm(farm)

  suspend fun updateFarm(farm: Farm): Farm
      = dataSource.updateFarm(farm)

  suspend fun getFarms(): List<Farm> = dataSource.getFarms()

  suspend fun getFarmsByName(name: String): List<Farm> = dataSource.getFarmsByName(name)

  suspend fun getFarmsById(id: Int): List<Farm> = dataSource.getFarmsById(id)

  suspend fun deleteFarm(id: Int): Int
      = dataSource.deleteFarm(id)

  suspend fun getLastFarmId(): Int = dataSource.getLastFarmId()

  suspend fun updateLastFarmId(id: Int): Int = dataSource.updateLastFarmId(id)
}