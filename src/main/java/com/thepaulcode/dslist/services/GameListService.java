package com.thepaulcode.dslist.services;

import com.thepaulcode.dslist.dto.GameDTO;
import com.thepaulcode.dslist.dto.GameListDTO;
import com.thepaulcode.dslist.dto.GameMinDTO;
import com.thepaulcode.dslist.entities.Game;
import com.thepaulcode.dslist.entities.GameList;
import com.thepaulcode.dslist.repositories.GameListRepository;
import com.thepaulcode.dslist.repositories.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    private final GameListRepository gameListRepository;

    public GameListService(GameListRepository gameListRepository){

        this.gameListRepository = gameListRepository;
    }

    @Transactional(readOnly = true)
    public List<GameListDTO> findAllList() {
        List<GameList> gameList = gameListRepository.findAll();
        List<GameListDTO> gameListDTOS = gameList.stream().map(GameListDTO::new).toList();

        return  gameListDTOS;
    }

}
