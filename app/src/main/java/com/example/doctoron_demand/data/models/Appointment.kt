package com.example.doctoron_demand.data.models

data class Appointment(
    val doctorName: String,
    val speciality: String,
    val date: String,
    val symptoms: List<Symptom>
)