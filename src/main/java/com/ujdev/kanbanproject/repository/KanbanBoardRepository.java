package com.ujdev.kanbanproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ujdev.kanbanproject.model.KanbanBoard;

@Repository
public interface KanbanBoardRepository extends JpaRepository<KanbanBoard, Integer> {

    /*Optional<KanbanBoard> findById(Integer id);*/
}
