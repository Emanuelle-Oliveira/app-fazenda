package com.example.appfazenda.ui.mainActivity.getFarmsScreen

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.appfazenda.farm.model.Farm
import com.example.appfazenda.ui.createFarmActivity.CreateFarmActivity
import com.example.appfazenda.ui.updateFarmActivity.UpdateFarmActivity
import com.example.appfazenda.ui.mainActivity.getFarmsScreen.item.Item
import kotlin.reflect.KFunction0
import kotlin.reflect.KFunction1

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun GetFarmsScreen(
  farmsList: State<List<Farm>>,
  deleteFarm: KFunction1<Int, Unit>,
  getFarms: KFunction0<Unit>
) {
  val listState = rememberLazyListState()

  val context = LocalContext.current

  Column(modifier = Modifier
    .fillMaxSize()
    .padding(horizontal = 15.dp, vertical = 8.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Column() {
      Scaffold(
        floatingActionButton = {
          FloatingActionButton(
            onClick = {
              context.startActivity(Intent(context, CreateFarmActivity::class.java))
                      },
              containerColor = Color(0xFF539608),
              shape = RoundedCornerShape(16.dp),
            ) {
              Icon(
                imageVector = Icons.Rounded.Add,
                contentDescription = "Add",
                tint = Color.White,
              )
            }
          },
          content = {
            LazyColumn(
              state = listState,
              contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
              items(
                items = farmsList.value,
                itemContent = {
                  Item(farmsList, farm = it, deleteFarm, getFarms)
                })
            }
          }
        )
      }
    }
}