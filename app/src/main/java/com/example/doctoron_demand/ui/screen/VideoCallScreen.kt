package com.example.doctoron_demand.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.doctoron_demand.R
import com.example.doctoron_demand.data.models.Appointment

@Composable
fun VideoCallScreen(
    navController: NavController
) {
    Image(
        painter = painterResource(id = R.drawable.logo_03),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .width(640.dp)
            .height(1000.dp)
            .fillMaxWidth()
            .fillMaxHeight()
    )
    Box {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Button(
                onClick = {
                    navController.navigate("PaymentPage")
                },
                modifier = Modifier.background(Color.Red)
            ) {
                Text(
                    text = "End call"
                )
            }
        }
    }
}


/*import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.twilio.video.*
import java.util.concurrent.atomic.AtomicBoolean

class VideoCallActivity : AppCompatActivity() {

    private lateinit var localVideoView: VideoView
    private lateinit var remoteVideoView: VideoView

    private lateinit var twilioProgrammableVideo: TwilioProgrammableVideo

    private val CAMERA_MIC_PERMISSION_REQUEST_CODE = 1
    private val TAG = "VideoCallActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                VideoCallScreen()
            }
        }

        localVideoView = VideoView(this)
        remoteVideoView = VideoView(this)

        twilioProgrammableVideo = TwilioProgrammableVideo(this, localVideoView, remoteVideoView)

        if (!checkCameraAndMicPermissions()) {
            requestCameraAndMicPermissions()
        } else {
            twilioProgrammableVideo.startLocalVideoPreview()
        }
    }

    override fun onResume() {
        super.onResume()
        twilioProgrammableVideo.onResume()
    }

    override fun onPause() {
        super.onPause()
        twilioProgrammableVideo.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        twilioProgrammableVideo.onDestroy()
    }

    private fun checkCameraAndMicPermissions(): Boolean {
        val cameraPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
        val micPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)

        return cameraPermission == PackageManager.PERMISSION_GRANTED && micPermission == PackageManager.PERMISSION_GRANTED
    }

    private fun requestCameraAndMicPermissions() {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO), CAMERA_MIC_PERMISSION_REQUEST_CODE)
    }

    private fun onPermissionsGranted() {
        twilioProgrammableVideo.startLocalVideoPreview()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        if (requestCode == CAMERA_MIC_PERMISSION_REQUEST_CODE) {
            var permissionsGranted = true

            for (grantResult in grantResults) {
                if (grantResult != PackageManager.PERMISSION_GRANTED) {
                    permissionsGranted = false
                    break
                }
            }

            if (permissionsGranted) {
                onPermissionsGranted()
            } else {
                Snackbar.make(
                    findViewById(android.R.id.content),
                    "Camera and Microphone Permissions are required to use this app.",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }
    }

    @Composable
    fun VideoCallScreen() {
        val context = LocalContext.current

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = { twilioProgrammableVideo.connectToRoom("room-name") }) {
                Text("Join Room")
            }

            Box(modifier = Modifier
                .padding(16.dp)
                .size(400.dp)) {
                AndroidView(
                    factory = { localVideoView },

*/