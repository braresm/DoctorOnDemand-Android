package com.example.doctoron_demand.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.doctoron_demand.ui.theme.DarkBlue
import com.example.doctoron_demand.ui.theme.LightBlue

@Composable
fun MultipleSelectionGroup(
    items: List<String>,
    selected: MutableList<String>
) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(1.dp),
    ) {
        items(items) { item ->

            var colorId by remember { mutableStateOf(0) }

            val color = when (colorId) {
                0 -> {
                    DarkBlue
                }
                else -> {
                    LightBlue
                }
            }

            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = color),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.padding(4.dp).height(50.dp),
                onClick = {
                    if (selected.contains(item)) {
                        colorId = 0
                        selected.remove(item)
                    } else {
                        colorId = 1
                        selected.add(item)
                    }

                }
            ) {
                Text(
                    text = item,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
        }
    }

}