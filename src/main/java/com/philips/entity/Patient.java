package com.philips.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "PATIENT", uniqueConstraints = {@UniqueConstraint(columnNames = "ID")})
public class Patient {
	
	@Column(name = "ID", unique = true, nullable = false)
	@Id  
    @GeneratedValue(strategy=GenerationType.AUTO)  
	private Long id;
	
	@Column(name = "PATIENT_NAME", unique = true, nullable = false, length = 100)
	private String name;
	
	@Column(name = "DATE_OF_BIRTH", unique = false, length = 100)
	@Temporal(TemporalType.DATE)
	private java.util.Calendar dob;
	
	@Column(name = "GENDER", unique = false, nullable = false, length = 100)
	private Character gender;
	
	@ManyToOne()  
	@JoinColumn(name = "INSTITUTION_ID", nullable = false)
	private Institution institution;
	
	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

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
	
}
