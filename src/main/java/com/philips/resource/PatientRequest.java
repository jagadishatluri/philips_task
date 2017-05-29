package com.philips.resource;

public class PatientRequest {
	
	private Long id;
	
	private String name;
	
	private java.util.Calendar dob;
	
	private Character gender;
	
	private Long institutionId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public java.util.Calendar getDob() {
		return dob;
	}

	public void setDob(java.util.Calendar dob) {
		this.dob = dob;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public Long getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(Long institutionId) {
		this.institutionId = institutionId;
	}
		
}
