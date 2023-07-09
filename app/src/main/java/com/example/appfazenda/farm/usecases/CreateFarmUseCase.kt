package com.example.appfazenda.farm.usecases

import com.example.appfazenda.data.farm.FarmRepository
import com.example.appfazenda.farm.model.Farm
import com.example.appfazenda.farm.usecases.contracts.ICreateFarmUseCase
import javax.inject.Inject

class CreateFarmUseCase @Inject constructor(
  private val farmRepository: FarmRepository
): ICreateFarmUseCase {

  override suspend fun invoke(id: Int, name: String, value: Double, employeesNumber: Int): Farm {
    return try {
      val farm = Farm(id+1, name, value, employeesNumber)
      farmRepository.createFarm(farm)
    } catch (e: Exception) {
      throw e
    }
  }
}