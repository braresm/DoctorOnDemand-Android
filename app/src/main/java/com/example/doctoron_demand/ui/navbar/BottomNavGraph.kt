package com.example.doctoron_demand.ui.navbar


import DoctorSelectionScreen
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.doctoron_demand.data.models.Appointment
import com.example.doctoron_demand.data.models.Doctor
import com.example.doctoron_demand.data.models.Symptom
import com.example.doctoron_demand.data.repository.MockDoctorsRepository
import com.example.doctoron_demand.ui.screen.*

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavbarRoutes.Symptoms.route
    ) {
        composable(route = NavbarRoutes.Symptoms.route) {
            SymptomsScreen(navController)
        }
        composable(route = NavbarRoutes.Appointment.route) {
            AppointmentScreen(emptyList(), navController)
        }
        composable(route = NavbarRoutes.Consultation.route) {
            ConsultationScreen(emptyList(), navController)
        }
        composable(route = NavbarRoutes.Profile.route) {
            ProfileScreen()
        }

        composable("doctorSelection/{symptoms}/{duration}") { navBackStackEntry ->
            /* Extracting the parameters from the route */
            val symptomsString = navBackStackEntry.arguments?.getString("symptoms")
            val symptoms = symptomsString?.split("#")
            val duration = navBackStackEntry.arguments?.getString("duration")


            Log.d("symptoms", symptoms.toString())
            Log.d("duration", duration.toString())

            if (symptoms != null && duration != null) {
                DoctorSelectionScreen(
                    navController = navController,
                    selectedSymptoms = symptoms,
                    selectedDuration = duration
                )
            }
        }

        composable(route = "appointment/{doctorId}") { navBackStackEntry ->
            val doctorId = navBackStackEntry.arguments?.getString("doctorId")
            val doctorRepository = MockDoctorsRepository()
            val availableDoctors = doctorRepository.getDoctors()
            val selectedDoctor = availableDoctors.find { doctor -> doctor.id == doctorId }

            if (selectedDoctor != null) {
                val appointment = Appointment(
                    selectedDoctor.name,
                    "Cardiology",
                    selectedDoctor.date,
                    selectedDoctor.symptoms
                )
                AppointmentScreen(listOf(appointment), navController)
            }
        }

        composable(route = "consultation/{doctorId}") { navBackStackEntry ->
            val doctorId = navBackStackEntry.arguments?.getString("doctorId")
            val doctorRepository = MockDoctorsRepository()
            val availableDoctors = doctorRepository.getDoctors()
            val selectedDoctor = availableDoctors.find { doctor -> doctor.id == doctorId }

            if (selectedDoctor != null) {
                val appointment = Appointment(
                    selectedDoctor.name,
                    "Cardiology",
                    selectedDoctor.date,
                    selectedDoctor.symptoms
                )
                ConsultationScreen(listOf(appointment), navController)
            }
        }

        composable("VideoCall") { navBackStackEntry ->
            VideoCallScreen(
                navController = navController
            )
        }
        composable("PaymentPage") { navBackStackEntry ->
            PaymentPageScreen(
                navController = navController
            )
        }
        composable("DiagnosisPage") { navBackStackEntry ->
            DiagnosisScreen(
                navController = navController
            )
        }
    }
}