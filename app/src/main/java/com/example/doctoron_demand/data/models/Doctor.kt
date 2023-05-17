package com.example.doctoron_demand.data.models

data class Doctor(
    val id: String,
    val name: String,
    val status: String,
    val date: String,
    val symptoms: List<Symptom>
)
