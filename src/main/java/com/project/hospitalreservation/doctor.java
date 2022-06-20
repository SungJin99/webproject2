package com.project.hospitalreservation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Doctor")
public class doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private int doctorroom;
	
	private String doctorname;
	
	private String consultation_hours;

	public doctor() {}

	public doctor(int doctorroom, String doctorname, String consultation_hours) {
		super();
		this.doctorroom = doctorroom;
		this.doctorname = doctorname;
		this.consultation_hours = consultation_hours;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public int getDoctorroom() {
		return doctorroom;
	}
	public void setDoctorroom(int doctorroom) {
		this.doctorroom = doctorroom;
	}
	public String getDoctorName() {
		return doctorname;
	}
	public void setDoctorName(String doctorname) {
		this.doctorname = doctorname;
	}
	public String getConsultation_hours() {
		return consultation_hours;
	}
	public void setConsultation_hours(String consultation_hours) {
		this.consultation_hours = consultation_hours;
	}

}
