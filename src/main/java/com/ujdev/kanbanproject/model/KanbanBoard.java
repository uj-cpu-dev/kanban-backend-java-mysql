package com.ujdev.kanbanproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "kanban_dashboard")
public class KanbanBoard {
    
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "board_name")
    private String board_name;

    @Column(name = "is_Active")
    private boolean isActive;

    @Column(name = "columns")
    private String columns;

    public KanbanBoard() {
        // Default constructor required by JPA
    }

    public KanbanBoard(Integer id, String board_name, boolean isActive, String columns) {
        this.id = id;
        this.board_name = board_name;
        this.columns = columns;
        this.isActive = isActive;
    }
}