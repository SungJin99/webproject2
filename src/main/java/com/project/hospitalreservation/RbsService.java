package com.project.hospitalreservation;

import org.springframework.ui.Model;

public interface  RbsService {
	
	String addReserv(Room room);
	
	String showAllOccupied(Model model);

	String showAvailableRooms(Model model);

	String showUpdateForm(Long id, Model model);
	
	String makePlace(doctor place);

	String deleteReserv(Long id, Model model);

	String showAll(Model model);
	
	
}



