package com.example.doctoron_demand.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.doctoron_demand.R


@Composable
fun Disclaimer(navController: NavHostController) {
    val acceptDisclaimer = remember { mutableStateOf(false) }

    Image(
        painter = painterResource(id = R.drawable.disclaimer_bg),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.rotate(180F)
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_03),
            contentDescription = null,
            modifier = Modifier.width(120.dp)

        )

        Spacer(modifier = Modifier.height(16.dp))

        Box {
            Card(
                backgroundColor = Color(221, 221, 221),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.offset(y = 60.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)) {

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "One virtual visit away!",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "DISCLAIMER",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "SymptoCare:",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Is a Doctor consultation app where  you can consult with a suitable Doctor based on your physical symptoms.",
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "* Not suitable for other medical services. Strictly for general physical consultations.",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Payments:",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Payments can be done directly through the selected Doctor’s clinic payment site after the consultation.",
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "* People with insurance will be reimbursed based on your insurance coverage.",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Checkbox(
                            checked = acceptDisclaimer.value,
                            onCheckedChange = { acceptDisclaimer.value = it},
                        )
                        Text(
                            text = "I have read and accept this disclaimer",
                            fontSize = 14.sp
                        )
                    }

                    if(acceptDisclaimer.value) {
                        Button(
                            onClick = {
                                navController.navigate("Login")
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {

                            Text(text = "Continue")

                        }
                    }
                }
            }

            Image(
                painter = painterResource(id = R.drawable.doctors),
                contentDescription = null,
                modifier = Modifier
                    .align(alignment = Alignment.TopCenter)
                    .width(300.dp)
            )
        }
    }
}

