package com.example.appfazenda.farm.usecases.contracts

interface IUpdateLastFarmIdUseCase {
  suspend operator fun invoke(id: Int): Int
}