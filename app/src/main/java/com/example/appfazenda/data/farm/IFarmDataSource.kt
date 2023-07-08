package com.example.appfazenda.data.farm

import com.example.appfazenda.farm.model.Farm

interface IFarmDataSource {

  suspend fun createFarm(farm: Farm): Farm

  suspend fun updateFarm(farm: Farm): Farm

  suspend fun getFarms(): List<Farm>

  suspend fun getFarmsByName(name: String): List<Farm>

  suspend fun getFarmsById(id: Int): List<Farm>

  suspend fun deleteFarm(id: Int): Int

  suspend fun getLastFarmId(): Int

  suspend fun updateLastFarmId(id: Int): Int
}