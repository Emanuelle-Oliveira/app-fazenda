package com.example.appfazenda.ui.createFarmActivity.createFarmScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.appfazenda.farm.model.Farm
import kotlin.reflect.KFunction1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateFarmScreen(createFarm: KFunction1<Farm, Unit>) {

  val textFieldName = remember { mutableStateOf("") }
  val textFieldValue = remember { mutableStateOf("") }
  val textFieldEmployeesNumber = remember { mutableStateOf("") }

  val context = LocalContext.current

 /* Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(horizontal = 15.dp, vertical = 16.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp),
  ) {
    OutlinedTextField(
      value = textField1Value.value,
      onValueChange = { textField1Value.value = it },
      label = { Text("CPF") },
      modifier = Modifier.fillMaxWidth(),
      keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )

    OutlinedTextField(
      value = textField2Value.value,
      onValueChange = { textField2Value.value = it },
      label = { Text("Nome") },
      modifier = Modifier.fillMaxWidth()
    )

    OutlinedTextField(
      value = textField3Value.value,
      onValueChange = { textField3Value.value = it },
      label = { Text("Telefone") },
      modifier = Modifier.fillMaxWidth(),
      keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )

    OutlinedTextField(
      value = textField4Value.value,
      onValueChange = { textField4Value.value = it },
      label = { Text("Endereço") },
      modifier = Modifier.fillMaxWidth()
    )

    OutlinedTextField(
      value = textField5Value.value,
      onValueChange = { textField5Value.value = it },
      label = { Text("Instagram") },
      modifier = Modifier.fillMaxWidth()
    )

    // Botão "Salvar"
    Button(
      onClick = {
        if (
          textField1Value.value.isNotBlank() &&
          textField2Value.value.isNotBlank() &&
          textField3Value.value.isNotBlank() &&
          textField4Value.value.isNotBlank() &&
          textField5Value.value.isNotBlank()
        ) {
          // Ação do botão
          val client = Client(
            textField1Value.value,
            textField2Value.value,
            textField3Value.value,
            textField4Value.value,
            textField5Value.value
          )
          funcao(client)

          // Limpar os campos de texto
          textField1Value.value = ""
          textField2Value.value = ""
          textField3Value.value = ""
          textField4Value.value = ""
          textField5Value.value = ""

          context.startActivity(Intent(context, GetClientsActivity::class.java))
        } else {
          Toast.makeText(context, "Todos os campos devem estar preenchidos!", Toast.LENGTH_SHORT).show()
        }
      },
      colors = ButtonDefaults.buttonColors(contentColor = Color.White, containerColor = MaterialTheme.colorScheme.errorContainer),
      modifier = Modifier
        .fillMaxWidth()
        .align(Alignment.Start) // Ajuste o alinhamento vertical aqui
        .padding(2.dp)
    ) {
      Text(text = "Salvar")
    }

  }*/
}