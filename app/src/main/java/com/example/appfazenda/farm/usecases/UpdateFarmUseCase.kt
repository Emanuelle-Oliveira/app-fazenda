package com.example.appfazenda.farm.usecases

import com.example.appfazenda.data.farm.FarmRepository
import com.example.appfazenda.farm.model.Farm
import com.example.appfazenda.farm.usecases.contracts.IUpdateFarmUseCase
import javax.inject.Inject

class UpdateFarmUseCase @Inject constructor(
  private val farmRepository: FarmRepository
): IUpdateFarmUseCase {

  override suspend fun invoke(id: Int, name: String, value: Double, employeesNumber: Int): Farm {
    return try {
      val farm = Farm(id, name, value, employeesNumber)
      farmRepository.updateFarm(farm)
    } catch (e: Exception) {
      throw e
    }
  }
}