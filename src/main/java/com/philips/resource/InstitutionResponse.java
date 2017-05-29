package com.philips.resource;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.philips.entity.Patient;

@JsonInclude(Include.NON_NULL)
public class InstitutionResponse {
	
		private Long id;
		private String name;
		private String description;
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
