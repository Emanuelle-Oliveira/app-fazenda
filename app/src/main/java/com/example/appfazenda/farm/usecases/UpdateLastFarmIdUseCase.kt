package com.example.appfazenda.farm.usecases

import com.example.appfazenda.data.farm.FarmRepository
import com.example.appfazenda.farm.usecases.contracts.IUpdateLastFarmIdUseCase
import javax.inject.Inject

class UpdateLastFarmIdUseCase @Inject constructor(
  private val farmRepository: FarmRepository,
): IUpdateLastFarmIdUseCase {
  override suspend fun invoke(id: Int): Int {
    return try {
      val newId = farmRepository.updateLastFarmId(id)
      newId
    } catch (e: Exception) {
      throw e
    }
  }
}