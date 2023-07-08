package com.example.appfazenda.farm.usecases.contracts

import com.example.appfazenda.farm.model.Farm

interface IUpdateFarmUseCase {
  suspend operator fun invoke(id: Int, name: String, value: Double, employeesNumber: Int): Farm
}