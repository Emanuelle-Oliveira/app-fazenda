package com.example.appfazenda.farm.usecases.contracts

interface IGetLastFarmIdUseCase {
  suspend operator fun invoke(): Int
}