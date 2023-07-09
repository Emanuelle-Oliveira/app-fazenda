package com.example.appfazenda.ui.createFarmActivity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.lifecycleScope
import com.example.appfazenda.farm.usecases.contracts.ICreateFarmUseCase
import com.example.appfazenda.farm.usecases.contracts.IGetLastFarmIdUseCase
import com.example.appfazenda.farm.usecases.contracts.IUpdateLastFarmIdUseCase
import com.example.appfazenda.ui.common.appBar.AppBar
import com.example.appfazenda.ui.createFarmActivity.createFarmScreen.CreateFarmScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class CreateFarmActivity : ComponentActivity() {

  @Inject
  lateinit var createFarmUseCase: ICreateFarmUseCase

  @Inject
  lateinit var getLastFarmIdUseCase: IGetLastFarmIdUseCase

  @Inject
  lateinit var updateLastFarmIdUseCase: IUpdateLastFarmIdUseCase

  private fun createFarm(id: Int, name: String, value: Double, employeesNumber: Int){
    lifecycleScope.launch {
      createFarmUseCase(id, name, value, employeesNumber)
    }
  }

  var lastFarmId = mutableStateOf(0)


  private fun getLastFarmId() {
    lifecycleScope.launch {
      lastFarmId.value = getLastFarmIdUseCase()
    }
  }

  private fun updateLastFarmId(id: Int) {
    lifecycleScope.launch {
      updateLastFarmIdUseCase(id)
    }
  }

  @OptIn(ExperimentalMaterial3Api::class)
  @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    getLastFarmId()
    setContent {
      val scaffoldState = rememberScaffoldState()
      val scope = rememberCoroutineScope()
      androidx.compose.material.Scaffold(
        scaffoldState = scaffoldState,
        topBar = { AppBar() },
      ) {
        CreateFarmScreen(lastFarmId.value, ::createFarm, ::updateLastFarmId)
      }
    }
  }
}


