package com.philips.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Examination", uniqueConstraints = {@UniqueConstraint(columnNames = "ID")})
public class Examination {
	@Id  
	@Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name = "EXAM_DATE", unique = false, nullable = false)
	@Temporal(TemporalType.DATE)
	private java.util.Calendar examDate;

	@Column(name = "EXAM_NAME", unique = false, nullable = false, length = 100)
	private String name;

	@Column(name = "EXAM_DESCRIPTION", unique = false, nullable = false, length = 200)
	private String description;
	
	@Column(name = "WEIGHT_IN_KGS", unique = false, nullable = false, length = 10)
	private int weightInKgs;

	@Column(name = "HEIGHT_IN_MTS", unique = false, nullable = false, length = 10)
	private double heightInMts;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public java.util.Calendar getExamDate() {
		return examDate;
	}

	public void setExamDate(java.util.Calendar examDate) {
		this.examDate = examDate;
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

	public int getWeightInKgs() {
		return weightInKgs;
	}

	public void setWeightInKgs(int weightInKgs) {
		this.weightInKgs = weightInKgs;
	}

	public double getHeightInMts() {
		return heightInMts;
	}

	public void setHeightInMts(double heightInMts) {
		this.heightInMts = heightInMts;
	}

}
