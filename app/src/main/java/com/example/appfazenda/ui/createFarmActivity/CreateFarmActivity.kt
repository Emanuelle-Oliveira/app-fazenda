package com.example.appfazenda.ui.createFarmActivity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.appfazenda.farm.model.Farm
import com.example.appfazenda.farm.usecases.contracts.ICreateFarmUseCase
import com.example.appfazenda.ui.common.appBar.AppBar
import com.example.appfazenda.ui.createFarmActivity.createFarmScreen.CreateFarmScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class CreateFarmActivity : ComponentActivity() {

  @Inject
  lateinit var createFarmUseCase: ICreateFarmUseCase

  /*val farm = Farm(
    id = "",
    name = "",
    value = "",
    employeesNumber = ""
  )*/

  fun createFarm(farm: Farm) {
    lifecycleScope.launch {
      createFarmUseCase(farm.name, farm.value, farm.employeesNumber)
    }
  }

  @OptIn(ExperimentalMaterial3Api::class)
  @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      androidx.compose.material.Scaffold(
        topBar = { AppBar() },
      ) {
        CreateFarmScreen(::createFarm)
      }
    }
  }
}

