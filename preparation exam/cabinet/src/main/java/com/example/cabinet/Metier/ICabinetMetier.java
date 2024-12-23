package com.example.cabinet.Metier;

import com.example.cabinet.Model.Consultation;
import com.example.cabinet.Model.Medecin;
import com.example.cabinet.Model.Patient;

import java.util.List;

public interface ICabinetMetier {
    // les patients
    public List<Patient> getPatients();
    public List<Patient> getPatientsKey(String keywoard);
    public void addPatient(Patient patient);
    public void deletePatient(int id_patient);
    public List<Consultation> getConsultsOfPatient(int id_patient);
    // les medecins
    public void addMedecin(Medecin medecin);
    public List<Medecin> getMedecins();
    public void deleteMedecin(int id_medecin);
    public List<Consultation> getConsultsOfMedecin(int id_medecin);
    // les consultations
    public void addConsultation(Consultation consult);
    public List<Consultation> getConsults();
    public void deleteConsultation(int id_consultation);


}
