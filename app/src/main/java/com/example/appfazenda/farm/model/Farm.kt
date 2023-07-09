package com.example.appfazenda.farm.model
import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Farm (
  val id: Int,
  val name: String,
  val value: Double,
  val employeesNumber: Int
  ) : Parcelable