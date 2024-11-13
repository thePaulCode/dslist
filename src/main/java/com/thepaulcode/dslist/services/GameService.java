package com.thepaulcode.dslist.services;

import com.thepaulcode.dslist.dto.GameDTO;
import com.thepaulcode.dslist.dto.GameListDTO;
import com.thepaulcode.dslist.dto.GameMinDTO;
import com.thepaulcode.dslist.entities.Game;
import com.thepaulcode.dslist.entities.GameList;
import com.thepaulcode.dslist.projections.GameMinProjection;
import com.thepaulcode.dslist.repositories.GameListRepository;
import com.thepaulcode.dslist.repositories.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByLists(Long listId){
        List<GameMinProjection> gameMinProjectionsList = repository.searchByList(listId);
        List<GameMinDTO> gameMinDTOList = gameMinProjectionsList.stream().map(GameMinDTO::new).toList();
        return gameMinDTOList;
    }

}
