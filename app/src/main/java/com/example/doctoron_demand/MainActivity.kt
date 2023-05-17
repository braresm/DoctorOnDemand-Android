package com.example.doctoron_demand

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.doctoron_demand.ui.theme.DoctorOnDemandTheme
import com.example.doctoron_demand.ui.screen.ScreenMain
import com.example.doctoron_demand.ui.navbar.NavBarScreen

//import com.example.doctoron_demand.ui.LogIn
//import com.example.doctoron_demand.ui.LogInPage
//import com.example.doctoron_demand.ui.screen.ScreenMain


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DoctorOnDemandTheme {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.LightGray),
                        color = MaterialTheme.colors.background
                    ) {

                        ScreenMain(navController = rememberNavController())
//                        NavBarScreen()
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DoctorOnDemandTheme {
        //ScreenMain()
        NavBarScreen()
    }
}
