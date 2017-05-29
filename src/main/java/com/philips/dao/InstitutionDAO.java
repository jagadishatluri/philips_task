package com.philips.dao;

import java.util.List;

import com.philips.entity.Institution;

public interface InstitutionDAO extends GenericDAO<Institution, Long> {

	void deleteInstitution(Institution institution);

	Institution get(Long id);

	Institution saveInstitution(Institution  bean);

	Institution updateInstitution(Institution  Institution);
	
	List<Institution> getInstitutions();
}
