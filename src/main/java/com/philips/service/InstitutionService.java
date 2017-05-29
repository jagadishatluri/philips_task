package com.philips.service;

import java.util.List;

import com.philips.entity.Institution;
import com.philips.entity.Patient;
import com.philips.resource.InstitutionRequest;

public interface InstitutionService  {

	Institution update(Institution course);
	
	List<Institution> getInstitutions();

	Institution createInstitution(InstitutionRequest institution);

	void delete(Long institutionId);

	Institution findInstitution(Long instituttionId);

	Patient createPatient(Patient patient);

}
