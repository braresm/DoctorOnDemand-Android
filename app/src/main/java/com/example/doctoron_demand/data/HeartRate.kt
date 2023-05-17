package com.example.doctoron_demand.data

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.content.ContextCompat.checkSelfPermission
import com.example.doctoron_demand.R

private var sensorManager: SensorManager? = null
private var heartRateSensor: Sensor? = null
private var sensorEventListener: SensorEventListener? = null

fun startHeartRateMonitor(context: Context, onHeartRateUpdate: (Int) -> Unit) {
    sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    heartRateSensor = sensorManager?.getDefaultSensor(Sensor.TYPE_HEART_RATE)

    if (heartRateSensor == null) {
        // Heart rate sensor is not available
        return
    }

    sensorEventListener = object : SensorEventListener {
        override fun onSensorChanged(event: SensorEvent) {
            if (event.sensor.type == Sensor.TYPE_HEART_RATE) {
                val heartRate = event.values[0].toInt()
                onHeartRateUpdate(heartRate)
            }
        }

        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
    }

    sensorManager?.registerListener(sensorEventListener, heartRateSensor, SensorManager.SENSOR_DELAY_NORMAL)
}

fun stopHeartRateMonitor() {
    sensorEventListener?.let { sensorManager?.unregisterListener(it) }
    sensorEventListener = null
    heartRateSensor = null
    sensorManager = null
}


@Composable
fun HeartRateMonitor() {
    var isMonitoring: Boolean by remember { mutableStateOf(false) }
    var heartRate: Int by remember { mutableStateOf(0) }
    val context = LocalContext.current

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.heart_rate),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Text(
            text = "Heart Rate: $heartRate",
            color = Color.White
        )
        Button(
            onClick = {
                if (isMonitoring) {
                    stopHeartRateMonitor()
                    isMonitoring = false
                } else {
                    if (checkSelfPermission(context, Manifest.permission.BODY_SENSORS) == PackageManager.PERMISSION_GRANTED) {
                        startHeartRateMonitor(context) { newHeartRate ->
                            heartRate = newHeartRate
                        }
                        isMonitoring = true
                    } else {
                        requestPermissions(
                            context as Activity,
                            arrayOf(Manifest.permission.BODY_SENSORS),
                            0
                        )
                    }
                }
            }
        ) {
            if (isMonitoring) {
                Text(text = "Stop Monitoring")
            } else {
                Text(text = "Start Monitoring")
            }
        }
    }
}