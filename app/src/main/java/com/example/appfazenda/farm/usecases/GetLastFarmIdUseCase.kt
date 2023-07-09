package com.example.appfazenda.farm.usecases

import com.example.appfazenda.data.farm.FarmRepository
import com.example.appfazenda.farm.usecases.contracts.IGetLastFarmIdUseCase
import javax.inject.Inject

class GetLastFarmIdUseCase @Inject constructor(
  private val farmRepository: FarmRepository,
): IGetLastFarmIdUseCase {
  override suspend fun invoke(): Int {
    return try {
      val id = farmRepository.getLastFarmId()
      id
    } catch (e: Exception) {
      throw e
    }
  }
}