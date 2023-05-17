package com.example.doctoron_demand.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

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
fun SingleSelectionGroup(
    items: List<String>,
    selected: String,
    setSelected: (selected: String) -> Unit,
) {
    val rows = items.chunked(3)

    rows.forEach { rowItems ->
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            rowItems.forEach { item ->

                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = if (item == selected) LightBlue else DarkBlue),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier.padding(4.dp),
                    onClick = {
                        setSelected(item)
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
}