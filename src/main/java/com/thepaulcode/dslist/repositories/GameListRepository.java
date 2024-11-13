package com.thepaulcode.dslist.repositories;

import com.thepaulcode.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
