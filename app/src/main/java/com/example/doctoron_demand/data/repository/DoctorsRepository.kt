package com.example.doctoron_demand.data.repository

import com.example.doctoron_demand.data.models.Doctor

interface DoctorsRepository {
    fun getDoctors(): List<Doctor>
}