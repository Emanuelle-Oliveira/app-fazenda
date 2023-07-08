package com.example.appfazenda.farm.usecases.contracts

import com.example.appfazenda.farm.model.Farm

interface ICreateFarmUseCase {
  suspend operator fun invoke(name: String, value: Double, employeesNumber: Int): Farm
}