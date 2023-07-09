package com.example.appfazenda.ui.mainActivity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.lifecycleScope
import com.example.appfazenda.farm.model.Farm
import com.example.appfazenda.farm.usecases.contracts.ICreateFarmUseCase
import com.example.appfazenda.farm.usecases.contracts.IDeleteFarmUseCase
import com.example.appfazenda.farm.usecases.contracts.IGetFarmsByIdUseCase
import com.example.appfazenda.farm.usecases.contracts.IGetFarmsByNameUseCase
import com.example.appfazenda.farm.usecases.contracts.IGetFarmsUseCase
import com.example.appfazenda.ui.common.appBar.AppBar
import com.example.appfazenda.ui.mainActivity.getFarmsScreen.GetFarmsScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

  @Inject
  lateinit var getFarmsUseCase: IGetFarmsUseCase

  @Inject
  lateinit var getFarmsByNameUseCase: IGetFarmsByNameUseCase

  @Inject
  lateinit var getFarmsByIdUseCase: IGetFarmsByIdUseCase

  @Inject
  lateinit var deleteFarmUseCase: IDeleteFarmUseCase

  @Inject
  lateinit var createFarmUseCase: ICreateFarmUseCase

  private val farmsList = mutableStateOf(emptyList<Farm>())

  private fun deleteFarm(id: Int) {
    lifecycleScope.launch {
      deleteFarmUseCase(id)
    }
  }

  private fun getFarms() {
    lifecycleScope.launch {
      farmsList.value = getFarmsUseCase()
    }
  }

  private fun getFarmsByName(name: String) {
    lifecycleScope.launch {
      farmsList.value = getFarmsByNameUseCase(name)
    }
  }

  private fun getFarmsById(id: Int) {
    lifecycleScope.launch {
      farmsList.value = getFarmsByIdUseCase(id)
    }
  }

  @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter")
  @OptIn(ExperimentalMaterial3Api::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    getFarms()

    setContent {
      val scaffoldState = rememberScaffoldState()
      rememberCoroutineScope()
      androidx.compose.material.Scaffold(
        scaffoldState = scaffoldState,
        topBar = { AppBar() },
      ) {
        GetFarmsScreen(farmsList, ::deleteFarm, ::getFarms, ::getFarmsByName, ::getFarmsById)
      }
    }
  }
}



