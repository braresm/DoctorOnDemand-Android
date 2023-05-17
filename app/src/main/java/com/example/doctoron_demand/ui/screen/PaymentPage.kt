package com.example.doctoron_demand.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.doctoron_demand.R
import com.example.doctoron_demand.data.models.Appointment

@Composable
fun PaymentPageScreen(
    navController: NavHostController
) {
    Image(
        painter = painterResource(id = R.drawable.disclaimer_bg),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .width(640.dp)
            .height(1000.dp)
            .fillMaxWidth()
            .fillMaxHeight()
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(14.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "PAYMENT",
            fontSize = 28.sp,
            color = Color.White
        )

        Box {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Price:",
                        fontSize = 22.sp,
                        color = Color.White
                    )
                    Text(
                        text = "Payment will be done directly through the selected doctor's clinic payment site after the appoinment",
                        fontSize = 18.sp,
                        color = Color.White
                    )
                    Text(
                        text = "*People with insurance will be reimbursed based on your insurance coverage",
                        fontSize = 18.sp,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "20€ for 15 minutes of consultation",
                        fontSize = 20.sp,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = {
                            navController.navigate("consultation/1")
                        }
                    ) {
                        Text(
                            text = "Proceed to clinic payment"
                        )
                    }
                }
                Card(
                    backgroundColor = Color(221, 221, 221),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .offset(y = 60.dp)
                        .height(200.dp)
                        .clickable {

                        }
                        .clip(shape = RoundedCornerShape(20.dp))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Bottom
                            ) {
                                Spacer(modifier = Modifier.height(50.dp))
                                Image(
                                    painter = painterResource(id = R.drawable.doctor),
                                    contentDescription = null,
                                    contentScale = ContentScale.FillBounds,
                                    modifier = Modifier.width(65.dp).height(65.dp)
                                )
                            }
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = "Dr. Smith",
                                    fontSize = 21.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = "Cardiology",
                                    fontSize = 18.sp,
                                    color = Color.White
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                                Text(
                                    text = "Date & time of appointment:",
                                    fontSize = 18.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = "16-03-2023 12:00",
                                    fontSize = 18.sp,
                                    color = Color.White
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                                Text(
                                    text = "Symptoms:",
                                    fontSize = 18.sp,
                                    color = Color.White
                                )

                                Text(
                                    text = "Stomachache,Heartburn",
                                    fontSize = 18.sp,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }

            }

        }

    }
}