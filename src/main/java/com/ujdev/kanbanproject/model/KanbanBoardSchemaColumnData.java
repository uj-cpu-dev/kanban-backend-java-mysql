package com.ujdev.kanbanproject.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class KanbanBoardSchemaColumnData {

    private String title;

    private String description;

    private String status;

    private List<KanbanBoardSchemaSubTask> subtasks;
}
