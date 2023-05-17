package com.example.doctoron_demand.data.models

data class Consultation (
    val doctorName: String,
    val speciality: String,
    val date: String,
    val symptoms: List<Symptom>,
    val diagnostic: String
)