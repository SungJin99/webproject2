package com.project.hospitalreservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class RbsServicePower implements RbsService  {
	@Autowired
	private RbsRepository RbsRepository;
	
	
	
	
	@Override
	public String addReserv(Room room) {
		Room currentRoomStatus = RbsRepository.findByid(room.getId());
		if(currentRoomStatus.getRoomState().equals(RoomState.AVAILABLE)){
			room.setRoomState(RoomState.UNAVAILABLE);
			RbsRepository.save(room);
			return "Reservation";
			} else {
				return "unavailable";
			}		
	}
	@Override
	public String showAllOccupied(Model model) {
		List<Room> allReservation = RbsRepository.findByRoomState(RoomState.UNAVAILABLE);
		model.addAttribute("reservation", allReservation);
		return "MyReservation";
	}
	@Override
	public String showAvailableRooms(Model model) {
		List<Room> allRoomsAvailable = RbsRepository.findByRoomState(RoomState.AVAILABLE);
		model.addAttribute("reservation", allRoomsAvailable);
		return "Show-all-room";
	}
	@Override
	public String showUpdateForm(Long id, Model model) {
		Room room = RbsRepository.findByid(id);
		model.addAttribute("room", room);
		return "update-form";
	}
	@Override
	public String deleteReserv(Long id, Model model) {
		Room room = RbsRepository.findByid(id);
		if(room.getRoomState().equals(RoomState.UNAVAILABLE)){
			room.setRoomState(RoomState.AVAILABLE);
			room.setName(null);
			room.setUsername(null);
			room.setDoctorName(null);
			room.setConsultation_hours(null);
			RbsRepository.save(room);
			return "delete";
		}else{
			return "not-occupied-exception";
		}
	}
	@Override
	public String makePlace(doctor place) {
		try {
			for (int i = 1; i <= place.getDoctorroom(); i++) {

					Room room = new Room(i, null, null, null,2, null, RoomState.AVAILABLE);
					RbsRepository.save(room);
			}
		} catch (Exception e) {
			return e.toString();
		}
		return "Reservation";
	}
	@Override
	public String showAll(Model model) {
		Iterable<Room> allRooms = RbsRepository.findAll();
		model.addAttribute("reservation", allRooms);
		return "Show-all-room";
	}
	
	
	

}
