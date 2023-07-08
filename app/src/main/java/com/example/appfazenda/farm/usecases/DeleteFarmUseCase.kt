package com.example.appfazenda.farm.usecases

import com.example.appfazenda.data.farm.FarmRepository
import com.example.appfazenda.farm.model.Farm
import com.example.appfazenda.farm.usecases.contracts.IDeleteFarmUseCase
import javax.inject.Inject

class DeleteFarmUseCase @Inject constructor(
  private val farmRepository: FarmRepository
): IDeleteFarmUseCase {

  override suspend fun invoke(id: Int): Int {
    return try {
      farmRepository.deleteFarm(id)
    } catch (e: Exception) {
      throw e
    }
  }
}