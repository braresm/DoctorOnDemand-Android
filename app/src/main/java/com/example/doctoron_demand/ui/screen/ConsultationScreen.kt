package com.example.doctoron_demand.ui.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.doctoron_demand.R
import com.example.doctoron_demand.data.models.Appointment
import com.example.doctoron_demand.data.repository.AppointmentRepository
import com.example.doctoron_demand.data.repository.MockAppointmentsRepository

@Composable
fun ConsultationScreen(
    appointments: List<Appointment>,
    navController: NavHostController
) {
    val appointmentz = MockAppointmentsRepository()
    val availableappointments = appointmentz.getAppointments()
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
            text = "CONSULTATIONS",
            fontSize = 28.sp,
            color = Color.White
        )

            Box {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    appointments.forEach { appointment ->
                        Spacer(modifier = Modifier.height(10.dp))
                        Card(
                            backgroundColor = Color(221, 221, 221),
                            shape = RoundedCornerShape(20.dp),
                            modifier = Modifier
                                .offset(y = 60.dp)
                                .height(200.dp)
                                .clickable {
                                    navController.navigate("DiagnosisPage")
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
                                            text = "Dr. ${appointment.doctorName}",
                                            fontSize = 21.sp,
                                            color = Color.White
                                        )
                                        Text(
                                            text = appointment.speciality,
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
                                            text = appointment.date,
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
                                            text = appointment.symptoms.joinToString(",") { s -> s.name },
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
}
