package com.philips.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.philips.dao.PatientDAO;
import com.philips.entity.Patient;

@Repository
public class PatientDAOImpl extends GenericHibernateDaoImpl<Patient, Long> implements PatientDAO {

	public PatientDAOImpl() {
		super(Patient.class);
	}

	@Override
	public void deletePatient(Patient patient) {
		delete(patient);
	}

	@Override
	public List<Patient> getPatients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient savePatient(Patient bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient updatePatient(Patient patient) {
		// TODO Auto-generated method stub
		return null;
	}

}
