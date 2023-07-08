package com.example.appfazenda.farm.usecases

import com.example.appfazenda.data.farm.FarmRepository
import com.example.appfazenda.farm.model.Farm
import com.example.appfazenda.farm.usecases.contracts.IGetFarmsByNameUseCase
import javax.inject.Inject

class GetFarmsByNameUseCase @Inject constructor(
  private val farmRepository: FarmRepository
): IGetFarmsByNameUseCase {

  override suspend fun invoke(name: String): List<Farm> {
    return try {
      farmRepository.getFarmsByName(name)
    } catch (e: Exception) {
      throw e
    }
  }
}