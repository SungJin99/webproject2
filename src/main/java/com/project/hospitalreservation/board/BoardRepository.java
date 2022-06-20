package com.project.hospitalreservation.board;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
	 List<BoardEntity> findByTitleContaining(String keyword);
}