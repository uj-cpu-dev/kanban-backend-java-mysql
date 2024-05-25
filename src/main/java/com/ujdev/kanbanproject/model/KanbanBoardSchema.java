package com.ujdev.kanbanproject.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class KanbanBoardSchema {

    private Integer id;

    private String board_name;

    private Boolean active;

    private List<KanbanBoardSchemaColumnData> columns;

    public KanbanBoardSchema(Integer id, String boardName, List<KanbanBoardSchemaColumnData> columns, Boolean active) {
        this.id = id;
        this.board_name = boardName;
        this.columns = columns;
        this.active = active;
    }
}
