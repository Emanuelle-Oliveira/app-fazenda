package com.example.appfazenda.ui.mainActivity.getFarmsScreen.item.dialogDelete

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.appfazenda.farm.model.Farm
import kotlin.reflect.KFunction0
import kotlin.reflect.KFunction1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogDelete(
  farm: Farm,
  deleteFarm: KFunction1<Int, Unit>,
  getFarms: KFunction0<Unit>,
  setShowDialog: (Boolean) -> Unit = {}
) {
  androidx.compose.material3.AlertDialog(
    onDismissRequest =  { setShowDialog(false) },//onClose,
    title = { Text("Excluir fazenda") },
    text = { Text("Tem certeza de que deseja excluir esta fazenda?") },
    confirmButton = {
      androidx.compose.material3.Button(
        onClick = {
          deleteFarm(farm.id)
          getFarms()
          setShowDialog(false)
        },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF539608)),
      ) {
        Text("Confirmar")
      }
    },
    dismissButton = {
      androidx.compose.material3.Button(
        onClick = {
          setShowDialog(false)
        },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF539608)),
      ) {
        Text("Cancelar")
      }
    }
  )
}