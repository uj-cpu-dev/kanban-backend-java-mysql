package com.ujdev.kanbanproject.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ujdev.kanbanproject.errorHandler.CustomException;
import com.ujdev.kanbanproject.model.KanbanBoardSchema;
import com.ujdev.kanbanproject.model.KanbanBoardSchemaColumnData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujdev.kanbanproject.model.KanbanBoard;
import com.ujdev.kanbanproject.repository.KanbanBoardRepository;

@Service
public class KanbanBoardService {
    
    @Autowired
    public KanbanBoardRepository kanbanBoardRepository;

    public List<KanbanBoardSchema> getAllBoard() {
        List<KanbanBoard> kanbanBoardList = kanbanBoardRepository.findAll();

        return kanbanBoardList.stream().map(schema-> convertSchema(schema)).collect(Collectors.toList());
    }

    public KanbanBoardSchema convertSchema(KanbanBoard schema) {
        KanbanBoardSchema kanbanBoardSchema = new KanbanBoardSchema(schema.getId(), schema.getBoard_name(), null);
        ObjectMapper mapper = new ObjectMapper();

        try {
            List<KanbanBoardSchemaColumnData> columnData = mapper.readValue(schema.getColumns(), List.class);
            kanbanBoardSchema.setColumns(columnData);
        } catch(JsonProcessingException e){
            e.printStackTrace();
        }

        return kanbanBoardSchema;
    }

    public Optional<KanbanBoardSchema> getEachBoard(Integer id){
        Optional<KanbanBoard> kanbanBoard = kanbanBoardRepository.findById(id);
        if (kanbanBoard.isPresent()) {
            KanbanBoardSchema schema = convertSchema(kanbanBoard.get());
            return Optional.of(schema);
        } else {
            return Optional.empty();
        }
    }

    public Optional<KanbanBoard> createNewBoard(KanbanBoard kanbanBoard){
        Optional<KanbanBoard> getKanbanBoard = kanbanBoardRepository.findById(kanbanBoard.getId());
        if(getKanbanBoard.isPresent()){
            throw new CustomException("ID ALREADY EXISTS");
        }
        return Optional.of(kanbanBoardRepository.save(kanbanBoard));
    }
}
