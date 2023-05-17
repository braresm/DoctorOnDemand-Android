package com.example.doctoron_demand.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.doctoron_demand.R

@Composable
fun ProfileScreen() {
    //Placeholder page
    Image(
        painter = painterResource(id = R.drawable.disclaimer_bg),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.width(640.dp).height(1000.dp).fillMaxWidth().fillMaxHeight()
    )
    Box(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(700.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = "PROFILE",
                    fontSize = 24.sp,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = null,
                modifier = Modifier.width(100.dp).height(100.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = "Name:",
                    fontSize = 22.sp,
                    color = Color.White
                )
                Text(
                    text = "Jane Doe",
                    fontSize = 22.sp,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = "Email:",
                    fontSize = 22.sp,
                    color = Color.White
                )
                Text(
                    text = "janedoe@email.com",
                    fontSize = 22.sp,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = "Phone number:",
                    fontSize = 22.sp,
                    color = Color.White
                )
                Text(
                    text = "0613459898",
                    fontSize = 22.sp,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
//@Preview(showBackground = true)
@Preview
fun ProfileScreenPreview() {
    ProfileScreen()
}