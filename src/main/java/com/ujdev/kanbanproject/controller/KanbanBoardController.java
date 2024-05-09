package com.ujdev.kanbanproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujdev.kanbanproject.model.KanbanBoard;
import com.ujdev.kanbanproject.services.KanbanBoardService;

@RestController
@RequestMapping("api/dashboard")
public class KanbanBoardController {

    @Autowired
    public KanbanBoardService kanbanBoardService;

    @GetMapping
    public ResponseEntity<?> getListOfBoards(){
        try {
            List<KanbanBoard> boards = kanbanBoardService.getAllBoard();
            return new ResponseEntity<List<KanbanBoard>>(boards, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBoard(@PathVariable Integer id){
        try {
            Optional<KanbanBoard> board = kanbanBoardService.getEachBoard(id);
            if(board.isPresent()){
                return new ResponseEntity<>(board, HttpStatus.OK);
            }
            return ResponseEntity.badRequest().body("board cannot be found");
            
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    
}
