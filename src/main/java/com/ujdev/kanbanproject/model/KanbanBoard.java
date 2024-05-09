package com.ujdev.kanbanproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "kanban_dashboard")
public class KanbanBoard {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "board_name")
    private String board_name;

    public KanbanBoard() {
        // Default constructor required by JPA
    }

    public KanbanBoard(Integer id, String board_name){
        this.id = id;
        this.board_name = board_name;
    }

    public Integer getId() {
		return id;
	}

	public String getBoardName() {
		return board_name;
	}
}