package com.philips.dao;

import java.util.List;

import com.philips.entity.Patient;

public interface PatientDAO extends GenericDAO<Patient, Long> {

	void deletePatient(Patient patient);

	Patient get(Long id);

	Patient savePatient(Patient  bean);

	Patient updatePatient(Patient  patient);
	
	List<Patient> getPatients();
}
