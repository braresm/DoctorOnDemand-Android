package com.example.doctoron_demand.data.repository

import com.example.doctoron_demand.data.models.Consultation

interface ConsultationRepository {
    fun getConsultations(): List<Consultation>
}