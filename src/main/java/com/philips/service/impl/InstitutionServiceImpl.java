package com.philips.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.philips.dao.InstitutionDAO;
import com.philips.dao.PatientDAO;
import com.philips.entity.Institution;
import com.philips.entity.Patient;
import com.philips.resource.InstitutionRequest;
import com.philips.service.InstitutionService;

@Service
@Transactional
public class InstitutionServiceImpl implements InstitutionService {

	@Autowired
	private InstitutionDAO institutionDAO;
	
	@Autowired
	PatientDAO patientDAO;

	@Override
	public Institution createInstitution(InstitutionRequest institutionRequest) {
		Institution institution = null;
		try {
			//BeanUtils.copyProperties(institutionRequest, institution);
			
			institution = new Institution();
			institution.setDescription(institutionRequest.getDescription());
			institution.setName(institutionRequest.getName());
			
			Patient patient = new Patient();
			Set<Patient> patients = institutionRequest.getPatients();
			Patient next = patients.iterator().next();
			
			patient.setName(next.getName());
			patient.setInstitution(institution);
			patient.setDob(next.getDob());
			patient.setGender(next.getGender());
			
			institution.getPatients().add(patient);
			
			institutionDAO.save(institution);
			institutionDAO.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return institution;
	}
	
	@Override
	public Patient createPatient(Patient patient) {

		try {
			patientDAO.save(patient);
			patientDAO.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return patient;
	}

	@Override
	public void delete(Long institutionId) {
		try {
			institutionDAO.delete(institutionId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Institution findInstitution(Long institutionId) {
		Institution institution = null;
		try {
			institution = institutionDAO.get(institutionId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return institution;
	}

	@Override
	public List<Institution> getInstitutions() {
		List<Institution> institutionList = null;
		try {
			institutionList = institutionDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return institutionList;
	}

	@Override
	public Institution update(Institution transientObject) {
		try {
			institutionDAO.saveOrUpdate(transientObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return transientObject;
	}
}
