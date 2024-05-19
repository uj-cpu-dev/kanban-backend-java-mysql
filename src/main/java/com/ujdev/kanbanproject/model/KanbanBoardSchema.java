package com.ujdev.kanbanproject.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class KanbanBoardSchema {

    private Integer id;

    private String board_name;

    private boolean isActive;

    private List<KanbanBoardSchemaColumnData> columns;

    public KanbanBoardSchema(Integer id, String boardName, List<KanbanBoardSchemaColumnData> columns) {
        this.id = id;
        this.board_name = boardName;
        this.columns = columns;
    }
}
