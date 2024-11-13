package com.thepaulcode.dslist.repositories;

import com.thepaulcode.dslist.dto.GameDTO;
import com.thepaulcode.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Long> {


}
