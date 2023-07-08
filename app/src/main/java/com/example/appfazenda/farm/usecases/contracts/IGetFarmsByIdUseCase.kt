package com.example.appfazenda.farm.usecases.contracts

import com.example.appfazenda.farm.model.Farm

interface IGetFarmsByIdUseCase {
  suspend operator fun invoke(id: Int): List<Farm>
}