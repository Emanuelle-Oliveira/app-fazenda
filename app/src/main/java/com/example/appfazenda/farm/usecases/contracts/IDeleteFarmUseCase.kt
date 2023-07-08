package com.example.appfazenda.farm.usecases.contracts

interface IDeleteFarmUseCase {
  suspend operator fun invoke(id: Int): Int
}