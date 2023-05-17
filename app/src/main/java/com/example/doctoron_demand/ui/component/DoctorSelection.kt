package com.example.doctoron_demand.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.doctoron_demand.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.doctoron_demand.data.models.Doctor
import com.example.doctoron_demand.ui.theme.DarkBlue

@Composable
fun DoctorSelection(
    items: List<Doctor>,
    selected: String,
    setSelected: (selected: String) -> Unit,
) {
    val rows = items.chunked(2)

    rows.forEach { rowItems ->
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            rowItems.forEach { item ->

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .clickable {
                            setSelected(item.id)
                        }
                        .background(
                            if (item.id == selected) {
                                DarkBlue
                            } else {
                                Color.Transparent
                            },
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clip(shape = RoundedCornerShape(20.dp))
                ) {

                    Column(
                        modifier = Modifier
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.doctor),
                            contentDescription = null,
                            modifier = Modifier.width(150.dp)
                        )

                        Text(
                            text = "Dr. ${item.name}",
                            fontSize = 20.sp,
                            color = Color.White
                        )
                        Text(
                            text = item.status,
                            fontSize = 16.sp,
                            color = Color.White
                        )
                        Text(
                            text = item.date,
                            fontSize = 16.sp,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}