package com.example.appfazenda.farm.usecases

import com.example.appfazenda.data.farm.FarmRepository
import com.example.appfazenda.farm.model.Farm
import com.example.appfazenda.farm.usecases.contracts.IGetFarmsByIdUseCase
import javax.inject.Inject

class GetFarmsByIdUseCase @Inject constructor(
  private val farmRepository: FarmRepository
): IGetFarmsByIdUseCase {

  override suspend fun invoke(id: Int): List<Farm> {
    return try {
      if(id == -1) {
        farmRepository.getFarms()
      } else {
        farmRepository.getFarmsById(id)
      }
    } catch (e: Exception) {
      throw e
    }
  }
}