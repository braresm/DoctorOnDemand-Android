package com.example.doctoron_demand.ui.navbar

//import androidx.compose.ui.input.key.Key.Companion.R

import com.example.doctoron_demand.R

// will hold BottomScreen screen pages in the navbar
sealed class NavbarRoutes (
    val route: String,
    val title: String,
    val icon: Int,
    val iconSelected: Int
) {
    object Symptoms : NavbarRoutes(
        route = "symptoms",
        title = "Symptoms",
        icon = R.drawable.symptoms_normal,
        iconSelected = R.drawable.symptoms_selected
    )
    object Appointment : NavbarRoutes(
        route = "appointment",
        title = "Appointment",
        icon = R.drawable.appointment_normal,
        iconSelected = R.drawable.appointment_selected
    )

    object Consultation : NavbarRoutes(
        route = "consultation",
        title = "Consultation",
        icon = R.drawable.consultation_normal,
        iconSelected = R.drawable.consultation_selected
    )

    object Profile : NavbarRoutes(
        route = "profile",
        title = "Profile",
        icon = R.drawable.profile,
        iconSelected = R.drawable.profile_selected
    )
}

