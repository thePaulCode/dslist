package com.thepaulcode.dslist.services;

import com.thepaulcode.dslist.dto.GameMinDTO;
import com.thepaulcode.dslist.entities.Game;
import com.thepaulcode.dslist.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {
    
    private final GameRepository repository;
    
    public GameService(GameRepository repository){
        this.repository = repository;
    }

    public List<GameMinDTO> findAll(){
        List<Game> gameList = repository.findAll();
        List<GameMinDTO> dto = gameList.stream().map(GameMinDTO::new).toList();
        return dto;
    }

}
