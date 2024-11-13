package com.thepaulcode.dslist.controllers;

import com.thepaulcode.dslist.dto.GameDTO;
import com.thepaulcode.dslist.dto.GameListDTO;
import com.thepaulcode.dslist.dto.GameMinDTO;
import com.thepaulcode.dslist.services.GameListService;
import com.thepaulcode.dslist.services.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value ="/lists")
public class GameListController {

    private final GameListService service;

    public GameListController(GameListService service){
        this.service = service;
    }

    @GetMapping()
    public List<GameListDTO> findAllLists(){
        return service.findAllList();
    }
}
