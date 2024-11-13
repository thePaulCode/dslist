package com.thepaulcode.dslist.controllers;

import com.thepaulcode.dslist.dto.GameDTO;
import com.thepaulcode.dslist.dto.GameMinDTO;
import com.thepaulcode.dslist.entities.Game;
import com.thepaulcode.dslist.services.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value ="/games")
public class GameController {

    private final GameService service;

    public GameController(GameService service){
        this.service = service;
    }

    @GetMapping
    public List<GameMinDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public GameDTO findById(@PathVariable Long id){
        return service.findById(id);
    }
}
