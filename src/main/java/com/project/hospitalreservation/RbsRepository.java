package com.project.hospitalreservation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.hospitalreservation.Room;
import com.project.hospitalreservation.RoomState;

@Repository
@Transactional
public interface RbsRepository extends CrudRepository<Room, Long> {
	Room findByid(Long id);
	

	List<Room> findByRoomState(RoomState available);
	

}
