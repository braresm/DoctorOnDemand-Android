package com.example.doctoron_demand.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.doctoron_demand.R
import com.example.doctoron_demand.data.Routes

@Composable
fun ScreenMain(navController: NavHostController){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Disclaimer.route) {
        composable(Routes.Disclaimer.route) {
            Disclaimer(navController = navController)
        }

        composable(Routes.Login.route) {
            Image(
                painter = painterResource(id = R.drawable.login_bg),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.height(740.dp)
            )
            Card(backgroundColor = Color.Cyan,
                shape = RoundedCornerShape(80.dp),
                modifier = Modifier
                    .padding(60.dp)
                    .alpha(0.6f),
                elevation = 40.dp
            ) {
                LoginPage(navController = navController)
            }
        }

        composable(Routes.SymptomsScreen.route) {

            DashboardScreen()
        }
    }
}

