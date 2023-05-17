package com.example.doctoron_demand.data.repository

import com.example.doctoron_demand.data.models.Appointment
import com.example.doctoron_demand.data.models.Consultation
import com.example.doctoron_demand.data.models.Symptom

class MockConsultationsRepository: ConsultationRepository {
    override fun getConsultations(): List<Consultation> {
        return listOf(
            Consultation("Smith","Cardiology","16-03-2023 12:00",listOf(Symptom("Chest pain"), Symptom("Cough")),"Drink grean tea twice a day"),
            Consultation("Johnson","Gastroenterologist","16-03-2023 12:00",listOf(Symptom("Stomach ache"), Symptom("Heartburn")),"Take 1 imodium everey 2 days"),
            Consultation("Smith","Cardiology","16-03-2023 12:00",listOf(Symptom("Runny nose"), Symptom("Diarrhea")),"Take paracetamol every 6 hours"),
        )
    }
}