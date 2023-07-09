package com.example.appfazenda.ui.updateFarmActivity.updateFarmScreen

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.appfazenda.farm.model.Farm
import com.example.appfazenda.ui.mainActivity.MainActivity
import kotlin.reflect.KFunction1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateFarmScreen(farm: Farm, updateFarm: KFunction1<Farm, Unit>) {

  val textFieldId = remember { mutableStateOf(farm.id.toString()) }
  val textFieldName = remember { mutableStateOf(farm.name) }
  val textFieldValue = remember { mutableStateOf(farm.value.toString()) }
  val textFieldEmployeesNumber = remember { mutableStateOf(farm.employeesNumber.toString()) }

  val context = LocalContext.current

  val enabled = remember { mutableStateOf(false) }

  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(horizontal = 15.dp, vertical = 16.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp),
  ) {

    OutlinedTextField(
      value = textFieldId.value,
      onValueChange = { textFieldId.value = it },
      label = { Text("Nome") },
      modifier = Modifier.fillMaxWidth(),
      enabled = enabled.value,
      colors = TextFieldDefaults.outlinedTextFieldColors(
        cursorColor = Color(0xFF539608),
        focusedLabelColor = Color(0xFF539608),
        focusedBorderColor = Color(0xFF539608),
        unfocusedBorderColor = Color(0xFF539608)
      )
    )

    OutlinedTextField(
      value = textFieldName.value,
      onValueChange = { textFieldName.value = it },
      label = { Text("Nome") },
      modifier = Modifier.fillMaxWidth(),
      colors = TextFieldDefaults.outlinedTextFieldColors(
        cursorColor = Color(0xFF539608),
        focusedLabelColor = Color(0xFF539608),
        focusedBorderColor = Color(0xFF539608),
        unfocusedBorderColor = Color(0xFF539608)
      )
    )

    OutlinedTextField(
      value = textFieldValue.value,
      onValueChange = { textFieldValue.value = it },
      label = { Text("Valor") },
      modifier = Modifier.fillMaxWidth() ,
      keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
      colors = TextFieldDefaults.outlinedTextFieldColors(
        cursorColor = Color(0xFF539608),
        focusedLabelColor = Color(0xFF539608),
        focusedBorderColor = Color(0xFF539608),
        unfocusedBorderColor = Color(0xFF539608)
      )
    )

    OutlinedTextField(
      value = textFieldEmployeesNumber.value,
      onValueChange = { textFieldEmployeesNumber.value = it },
      label = { Text("Nº de funcionários") },
      modifier = Modifier.fillMaxWidth(),
      keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
      colors = TextFieldDefaults.outlinedTextFieldColors(
        cursorColor = Color(0xFF539608),
        focusedLabelColor = Color(0xFF539608),
        focusedBorderColor = Color(0xFF539608),
        unfocusedBorderColor = Color(0xFF539608)
      )
    )

    Button(
      onClick = {
        if (
          textFieldName.value.isNotBlank() &&
          textFieldValue.value.isNotBlank() &&
          textFieldEmployeesNumber.value.isNotBlank()
        ) {

          try {
            val farm = Farm(farm.id, textFieldName.value, textFieldValue.value.toDouble(), textFieldEmployeesNumber.value.toInt())
            updateFarm(farm)
          } finally {
            textFieldName.value = ""
            textFieldValue.value = ""
            textFieldEmployeesNumber.value = ""

            //var bundle = Bundle()
            //bundle.putParcelable("farm", farm)
            context.startActivity(Intent(context, MainActivity::class.java))
          }
        } else {
          Toast.makeText(context, "Todos os campos devem estar preenchidos!", Toast.LENGTH_SHORT).show()
        }
      },
      colors = ButtonDefaults.buttonColors(
        contentColor = Color.White, containerColor = Color(0xFF539608)),
      modifier = Modifier
        .fillMaxWidth()
        .align(Alignment.Start)
        .padding(2.dp)
    ) {
      Text(text = "Salvar")
    }
  }
}