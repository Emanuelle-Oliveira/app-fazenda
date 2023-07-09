package com.example.appfazenda.ui.mainActivity.getFarmsScreen

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.appfazenda.farm.model.Farm
import com.example.appfazenda.ui.createFarmActivity.CreateFarmActivity
import com.example.appfazenda.ui.mainActivity.getFarmsScreen.item.Item
import kotlin.reflect.KFunction0
import kotlin.reflect.KFunction1

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun GetFarmsScreen(
  farmsList: State<List<Farm>>,
  deleteFarm: KFunction1<Int, Unit>,
  getFarms: KFunction0<Unit>,
  getFarmsByName: KFunction1<String, Unit>,
  getFarmsById: KFunction1<Int, Unit>
) {
  val listState = rememberLazyListState()
  val textFieldName = remember { mutableStateOf("") }
  val textFieldId = remember { mutableStateOf("") }

  val context = LocalContext.current

  val average = farmsList.value.map { it.value }.average()
  val averageString = String.format("%.2f", average)

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
          }
      ) {
        Column(
          modifier = Modifier
            .fillMaxSize(),
          verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
          ) {
            OutlinedTextField(
              value = textFieldName.value,
              onValueChange = { textFieldName.value = it },
              label = { Text("Buscar por nome") },
              modifier = Modifier.weight(3f),
              colors = TextFieldDefaults.outlinedTextFieldColors(
                cursorColor = Color(0xFF539608),
                focusedLabelColor = Color(0xFF539608),
                focusedBorderColor = Color(0xFF539608),
                unfocusedBorderColor = Color(0xFF539608)
              )
            )
            Button(
              onClick = {
                getFarmsByName(textFieldName.value)
              },
              shape = RoundedCornerShape(16.dp),
              modifier = Modifier
                .padding(start = 8.dp)
                .weight(1f),
              colors = ButtonDefaults.buttonColors(
                contentColor = Color.White, containerColor = Color(0xFF539608)),
            ) {
              Icon(
                imageVector = Icons.Rounded.Search,
                contentDescription = "Pesquisar",
                tint = Color.White
              )
            }
          }
          Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
          ) {
            OutlinedTextField(
              value = textFieldId.value,
              onValueChange = { textFieldId.value = it },
              label = { Text("Buscar por ID") },
              modifier = Modifier.weight(3f),
              colors = TextFieldDefaults.outlinedTextFieldColors(
                cursorColor = Color(0xFF539608),
                focusedLabelColor = Color(0xFF539608),
                focusedBorderColor = Color(0xFF539608),
                unfocusedBorderColor = Color(0xFF539608)
              ),
              keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
            Button(
              onClick = {
                if (textFieldId.value != "") {
                  getFarmsById(textFieldId.value.toInt())
                } else {
                  getFarmsById(-1)
                }
              },
              shape = RoundedCornerShape(16.dp),
              modifier = Modifier
                .padding(start = 8.dp)
                .weight(1f),
              colors = ButtonDefaults.buttonColors(
                contentColor = Color.White, containerColor = Color(0xFF539608)),
            ) {
              Icon(
                imageVector = Icons.Rounded.Search,
                contentDescription = "Pesquisar",
                tint = Color.White
              )
            }
          }
          Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
          ) {
            androidx.compose.material.Text(
              text = "A média de valor das propriedades é R$ $averageString",
              style = MaterialTheme.typography.titleSmall,
              color = Color.Gray
            )
          }
          LazyColumn(
            state = listState,
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
          ) {
            items(
              items = farmsList.value,
              itemContent = {
                Item(farm = it, deleteFarm, getFarms)
              })
          }
        }
      }
    }
    }
}