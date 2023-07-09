package com.example.appfazenda.ui.common.appBar

import androidx.compose.foundation.layout.height
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@ExperimentalMaterial3Api
@Composable
fun AppBar() {
  TopAppBar(
    modifier = Modifier
      .height(70.dp),
    title = {
      Text(text = "App Fazenda",
        style = TextStyle(fontSize = 20.sp),
        color = Color.White
      )
    },
    backgroundColor = Color(0xFF539608),
    contentColor = Color(0xFF539608),
  )
}