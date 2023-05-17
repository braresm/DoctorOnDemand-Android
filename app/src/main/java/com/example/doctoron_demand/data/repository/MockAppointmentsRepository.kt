package com.example.doctoron_demand.data.repository

import com.example.doctoron_demand.data.models.Appointment
import com.example.doctoron_demand.data.models.Doctor
import com.example.doctoron_demand.data.models.Symptom
import com.example.doctoron_demand.ui.screen.AppointmentScreen

class MockAppointmentsRepository: AppointmentRepository {
    override fun getAppointments(): List<Appointment> {
        return listOf(
            Appointment("Smith","Cardiology","16-03-2023 12:00",listOf(Symptom("Chest pain"), Symptom("Cough"))),
            Appointment("Johnson","Gastroenterologist","16-03-2023 12:00",listOf(Symptom("Stomach ache"), Symptom("Heartburn"))),
            Appointment("Smith","Cardiology","16-03-2023 12:00",listOf(Symptom("Runny nose"), Symptom("Diarrhea")))
        )
    }
}