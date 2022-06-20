package com.project.hospitalreservation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "room")
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private int doctor;
	
	private int doctorroom;
	
	private String name;
	
	private String username;
	
	private String doctorname;
	
	private String consultation_hours;
	
	private RoomState roomState;
	
	public Room() {
	}
	public Room(Long id, String name, String username,String doctorname, int doctorroom, String consultation_hours, RoomState roomState) {
		
		this.id = id;
		this.name = name;
		this.username = username;
		this.doctorname = doctorname;
		this.doctorroom = doctorroom;
		this.consultation_hours = consultation_hours;
		this.roomState = roomState;
	}

	public Room(int doctor, String name, String username,String doctorname,int doctorroom, String consultation_hours, RoomState roomState) {
		
		this.doctor = doctor;
		this.name = name;
		this.username = username;
		this.doctorname = doctorname;
		this.doctorroom = doctorroom;
		this.consultation_hours = consultation_hours;
		this.roomState = roomState;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getDoctor() {
		return doctor;
	}

	public void setDoctor(int doctor) {
		this.doctor = doctor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDoctorName() {
		return doctorname;
	}
	public void setDoctorName(String doctorname) {
		this.doctorname = doctorname;
	}
	public int getDoctorroom() {
		return doctorroom;
	}
	public void setDoctorroom(int doctorroom) {
		this.doctorroom = doctorroom;
	}
	public String getConsultation_hours() {
		return consultation_hours;
	}
	public void setConsultation_hours(String consultation_hours) {
		this.consultation_hours = consultation_hours;
	}
	public RoomState getRoomState() {
		return roomState;
	}

	public void setRoomState(RoomState roomState) {
		this.roomState = roomState;
	}

	

}
