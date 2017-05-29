package com.philips.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.philips.dao.InstitutionDAO;
import com.philips.entity.Institution;
import com.philips.entity.Patient;

@Repository
public class InstitutionDAOImpl extends GenericHibernateDaoImpl<Institution, Long> implements InstitutionDAO {
	
	public InstitutionDAOImpl() {
        super(Institution.class);
    }

	@Override
	public void deleteInstitution(Institution institution) {
		delete(institution);
	}

	@Override
	public Institution saveInstitution(Institution bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Institution updateInstitution(Institution Institution) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Institution> getInstitutions() {
		List<Institution> institutionList = new ArrayList<Institution>();
		Institution institution = new Institution();
		institution.setDescription("Description");
		institution.setId(9999l);
		institution.setName("Name");
		
		Set<Patient> patientSet = new HashSet<Patient>();
		
		Patient patient = new Patient();
		patient.setId(444l);
		patient.setName("Patient_Name");
		patient.setGender('M');
		patient.setDob(Calendar.getInstance());
		patientSet.add(patient);
		
		//institution.setPatients(patientSet);
		institutionList.add(institution);
		
		return institutionList;
	}
	
	/*protected List <Institution> findAll(Class clazz) {
        List<Institution> objects = null;
        try {
            Query query = getSession().createQuery("from " + clazz.getName());
            objects = query.list();
        } catch (HibernateException e) {
        } finally {
        }
        return objects;
    }*/

}
