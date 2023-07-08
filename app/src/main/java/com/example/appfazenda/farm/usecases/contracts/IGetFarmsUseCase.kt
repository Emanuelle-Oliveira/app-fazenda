package com.example.appfazenda.farm.usecases.contracts

import com.example.appfazenda.farm.model.Farm

interface IGetFarmsUseCase {
  suspend operator fun invoke(): List<Farm>
}