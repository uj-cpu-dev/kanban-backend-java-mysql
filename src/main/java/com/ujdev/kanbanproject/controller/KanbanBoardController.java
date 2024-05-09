package com.ujdev.kanbanproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
}
