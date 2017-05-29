package com.philips.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "Institution", uniqueConstraints = {@UniqueConstraint(columnNames = "ID")})
public class Institution {
	
	@Id  
	@Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "INSTITUTION_NAME", unique = true, nullable = false, length = 100)
	private String name;
	
	@Column(name = "DESCRIPTION", unique = true, length = 200)
	private String description;
	
	@OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL, mappedBy="institution") 
	private Set<Patient> patients = new HashSet<Patient>(0);
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Patient> getPatients() {
		return patients;
	}
	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}

}
