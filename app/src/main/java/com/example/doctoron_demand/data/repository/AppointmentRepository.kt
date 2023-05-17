package com.example.doctoron_demand.data.repository

import com.example.doctoron_demand.data.models.Appointment

interface AppointmentRepository {
    fun getAppointments(): List<Appointment>
}