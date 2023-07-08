package com.example.appfazenda.farm.usecases.contracts

import com.example.appfazenda.farm.model.Farm

interface IGetFarmsByNameUseCase {
  suspend operator fun invoke(name: String): List<Farm>
}