package com.example.doctoron_demand.data

sealed class Routes(val route: String) {
    object Login : Routes("Login")
    object Disclaimer : Routes("Disclaimer")
    object SymptomsScreen : Routes("Symptoms")
}