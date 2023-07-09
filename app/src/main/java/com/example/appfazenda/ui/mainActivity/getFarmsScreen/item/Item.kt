package com.example.appfazenda.ui.mainActivity.getFarmsScreen.item

import android.content.Intent
import android.os.Bundle
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.appfazenda.farm.model.Farm
import com.example.appfazenda.ui.mainActivity.getFarmsScreen.item.dialogDelete.DialogDelete
import com.example.appfazenda.ui.updateFarmActivity.UpdateFarmActivity
import kotlin.reflect.KFunction0
import kotlin.reflect.KFunction1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Item(
  farmsList: State<List<Farm>>,
  farm: Farm,
  deleteFarm: KFunction1<Int, Unit>,
  getFarms: KFunction0<Unit>) {

  val context = LocalContext.current

  val showDialog = remember { mutableStateOf(false) }
  if (showDialog.value){
    DialogDelete(farm , deleteFarm, getFarms , setShowDialog = { showDialog.value = it })
  }

  val valueString = String.format("%.2f", farm.value)

  Card(
    modifier = Modifier
      .padding(horizontal = 8.dp, vertical = 8.dp)
      .fillMaxWidth(),
    shape = RoundedCornerShape(corner = CornerSize(16.dp)),
    backgroundColor = Color(0xFFD3ECB7)
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically
    ) {
      Column(
        modifier = Modifier
          .weight(1f)
          .padding(16.dp)
          .fillMaxWidth()
          .align(Alignment.CenterVertically)
      ) {
        Text(
          text = farm.name.toString(),
          style = typography.titleLarge,
          color = Color(0xFF539608)
        )
        Text(
          text = "R$ $valueString",
          style = typography.bodySmall,
          color = Color.Gray
        )
        Text(
          text = "${farm.employeesNumber.toString()} funcionários",
          style = typography.bodySmall,
          color = Color.Gray
        )
      }

      Box(
        modifier = Modifier.wrapContentSize(Alignment.CenterEnd)
      ) {
        IconButton(
          onClick = {
            var mochila = Bundle()
            mochila.putParcelable("farm", farm)
            context.startActivity((Intent(context, UpdateFarmActivity::class.java)).putExtras(mochila))
          }
        ) {
          Icon(
            imageVector = Icons.Default.Edit,
            contentDescription = "Lápis",
            tint = Color.Gray,
          )
        }
      }

      Box(
        modifier = Modifier.wrapContentSize(Alignment.CenterEnd)
      ) {
        IconButton(
          onClick = {
            showDialog.value = true
          }
        ) {
          Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = "Lixeira",
            tint = Color.Gray,
          )
        }
      }
    }
  }
}