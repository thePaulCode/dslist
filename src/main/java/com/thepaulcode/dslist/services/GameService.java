package com.thepaulcode.dslist.services;

import com.thepaulcode.dslist.dto.GameDTO;
import com.thepaulcode.dslist.dto.GameMinDTO;
import com.thepaulcode.dslist.entities.Game;
import com.thepaulcode.dslist.repositories.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameService {
    
    private final GameRepository repository;
    
    public GameService(GameRepository repository){
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> gameList = repository.findAll();
        List<GameMinDTO> dto = gameList.stream().map(GameMinDTO::new).toList();
        return dto;
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game game = repository.findById(id).get();

        return new GameDTO(game);
    }

}
