package com.example.appfazenda.farm.usecases

import com.example.appfazenda.data.farm.FarmRepository
import com.example.appfazenda.farm.model.Farm
import com.example.appfazenda.farm.usecases.contracts.ICreateFarmUseCase
import javax.inject.Inject

class CreateFarmUseCase @Inject constructor(
  private val farmRepository: FarmRepository
): ICreateFarmUseCase {

  override suspend fun invoke(name: String, value: Double, employeesNumber: Int): Farm {
    return try {
      val id = farmRepository.getLastFarmId()
      val newId = farmRepository.updateLastFarmId(id)

      val farm = Farm(newId, name, value, employeesNumber)
      farmRepository.createFarm(farm)
    } catch (e: Exception) {
      throw e
    }
  }
}