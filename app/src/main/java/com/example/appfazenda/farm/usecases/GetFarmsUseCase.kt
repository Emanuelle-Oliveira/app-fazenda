package com.example.appfazenda.farm.usecases

import com.example.appfazenda.data.farm.FarmRepository
import com.example.appfazenda.farm.model.Farm
import com.example.appfazenda.farm.usecases.contracts.IGetFarmsUseCase
import javax.inject.Inject

class GetFarmsUseCase @Inject constructor(
  private val farmRepository: FarmRepository
): IGetFarmsUseCase {

  override suspend fun invoke(): List<Farm> {
    return farmRepository.getFarms()
  }
}