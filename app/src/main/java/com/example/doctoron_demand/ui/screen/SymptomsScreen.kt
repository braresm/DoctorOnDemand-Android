package com.example.doctoron_demand.ui.screen


import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import com.example.doctoron_demand.R
import com.example.doctoron_demand.data.HeartRateMonitor
import com.example.doctoron_demand.ui.component.MultipleSelectionGroup
import com.example.doctoron_demand.ui.component.SingleSelectionGroup

@Composable
fun SymptomsScreen(navController: NavHostController) {

    var enterButtonEnabled by remember { mutableStateOf(false) }

    val symptoms =
        listOf("Stomach ache", "Heartburn", "Chest pain", "Diarrhea", "Runny nose", "Cough")

    val durations = listOf("<1 week", "1 week", "2 weeks", ">2 weeks")

    val selectedSymptoms = remember { mutableListOf<String>() }
    val (selectedDuration, setSelectedDuration) = remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxWidth()//.verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(id = R.drawable.disclaimer_bg),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.width(640.dp).height(740.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(930.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            /*Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.disclaimer_bg),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.width(640.dp)
                )

                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Hi Jane Doe,",
                        fontSize = 26.sp,
                        color = Color.White,
                        modifier = Modifier.padding(16.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.doctor),
                        contentDescription = null,
                        modifier = Modifier.width(200.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))*/


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 20.dp)
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Add your symptoms",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                /*Text(
                    text = "By adding your symptoms, you can generate the Doctor options that are specialised on the selected symptoms",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White
                )*/

                Spacer(modifier = Modifier.height(20.dp))


                MultipleSelectionGroup(items = symptoms, selected = selectedSymptoms)


                Spacer(modifier = Modifier.height(20.dp))

                Column(
                    modifier = Modifier
                        /*.background(Color(235, 235, 235))
                        .border(
                            border = ButtonDefaults.outlinedBorder,
                            shape = RoundedCornerShape(20.dp)
                        )*/
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "How long you had these symptoms for?",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    SingleSelectionGroup(
                        items = durations,
                        selected = selectedDuration,
                        setSelected = setSelectedDuration
                    )

                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Sync your health app data",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        HeartRateMonitor()
                    }
                    Column(modifier = Modifier.padding(10.dp)) {
                        StepCounterMonitor()
                    }

                }

                Spacer(modifier = Modifier.height(25.dp))

                Button(
                    enabled = (selectedSymptoms.size > 0 && selectedDuration.isNotEmpty()),
                    onClick = {
                        navController.navigate(
                            "doctorSelection/{symptoms}/{duration}"
                                .replace(
                                    oldValue = "{symptoms}",
                                    newValue = selectedSymptoms.joinToString(separator = "#")
                                )
                                .replace(
                                    oldValue = "{duration}",
                                    newValue = selectedDuration
                                )
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Text(text = "Enter symptoms & health data")

                }
            }
        }
    }
}
fun startStepCounterMonitoring(
    context: Context,
    onStepCountUpdate: (Int) -> Unit
) {
    val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    val stepCounterSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

    val sensorEventListener = object : SensorEventListener {
        override fun onSensorChanged(event: SensorEvent) {
            if (event.sensor.type == Sensor.TYPE_STEP_COUNTER) {
                val stepCount = event.values[0].toInt()
                onStepCountUpdate(stepCount)
            }
        }

        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
            // Not used
        }
    }

    sensorManager.registerListener(
        sensorEventListener,
        stepCounterSensor,
        SensorManager.SENSOR_DELAY_NORMAL
    )
}

@Composable
fun StepCounterMonitor() {
    var isMonitoring by remember { mutableStateOf(false) }
    var stepCount by remember { mutableStateOf(0) }
    val context = LocalContext.current

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Image(
            painter = painterResource(id = R.drawable.daily_steps),
            contentDescription = null
        )
        Text(
            text = "Step Count: $stepCount",
            color = Color.White
        )
        Button(
            onClick = {
                if (isMonitoring) {
                    // Stop monitoring the step counter
                    isMonitoring = false
                } else {
                    // Start monitoring the step counter
                    if (ContextCompat.checkSelfPermission(
                            context,
                            Manifest.permission.ACTIVITY_RECOGNITION
                        ) == PackageManager.PERMISSION_GRANTED
                    ) {
                        startStepCounterMonitoring(context) { newStepCount ->
                            stepCount = newStepCount
                        }
                        isMonitoring = true
                    } else {
                        ActivityCompat.requestPermissions(
                            context as Activity,
                            arrayOf(Manifest.permission.ACTIVITY_RECOGNITION),
                            0
                        )
                    }
                }
            }
        ) {
                Text(text = "Sync steps")
        }
    }
}

