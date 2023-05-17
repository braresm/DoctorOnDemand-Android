package com.example.doctoron_demand.data.repository

import com.example.doctoron_demand.data.models.Doctor
import com.example.doctoron_demand.data.models.Symptom

class MockDoctorsRepository: DoctorsRepository {
    override fun getDoctors(): List<Doctor> {
        return listOf(
            Doctor("1", "Smith", "Available", "16-03-2023 12:00", listOf(Symptom("Stomach ache"), Symptom("Heartburn"))),
            Doctor("2", "Johnson", "Available", "16-03-2023 14:00", listOf(Symptom("Chest pain"), Symptom("Cough"))),
            Doctor("3", "Lee", "Available", "17-03-2023 12:00", listOf(Symptom("Runny nose"), Symptom("Diarrhea"))),
            Doctor("4", "Kim", "Available", "16-03-2023 14:00",  listOf(Symptom("Cough"), Symptom("Stomach ache"))),
            Doctor("5","Leo", "Available", "17-03-2023 10:00",  listOf(Symptom("Heartburn"), Symptom("Chest pain")))
        )
    }
}