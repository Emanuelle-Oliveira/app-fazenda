package com.example.appfazenda.ui.updateFarmActivity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.lifecycleScope
import com.example.appfazenda.farm.model.Farm
import com.example.appfazenda.farm.usecases.contracts.IUpdateFarmUseCase
import com.example.appfazenda.ui.common.appBar.AppBar
import com.example.appfazenda.ui.updateFarmActivity.updateFarmScreen.UpdateFarmScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class UpdateFarmActivity : ComponentActivity() {

  @Inject
  lateinit var updateFarmUseCase: IUpdateFarmUseCase

  private fun updateFarm(farm: Farm) {
    lifecycleScope.launch {
      updateFarmUseCase(farm.id, farm.name, farm.value, farm.employeesNumber)
    }
  }

  @OptIn(ExperimentalMaterial3Api::class)
  @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val farm = intent.getParcelableExtra<Farm>("farm")

    setContent {
      val scaffoldState = rememberScaffoldState()
      rememberCoroutineScope()
      androidx.compose.material.Scaffold(
        scaffoldState = scaffoldState,
        topBar = { AppBar() },
      ) {
        if (farm != null) {
          UpdateFarmScreen(farm, ::updateFarm)
        }
      }
    }
  }
}


