package com.thepaulcode.dslist.repositories;

import com.thepaulcode.dslist.dto.GameDTO;
import com.thepaulcode.dslist.entities.Game;
import com.thepaulcode.dslist.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Long> {

    @Query(nativeQuery = true, value = """
                    select tb_game.id, tb_game.title, tb_game.game_year as gameYear,tb_game.img_url as imgUrl, tb_game.short_description as shortdesc, tb_belonging.position
                    from tb_game
                    inner join tb_belonging on tb_game.id = tb_belonging.game_id
                    where tb_belonging.list_id = :listId
                    order by tb_belonging.position
            """)
    List<GameMinProjection> searchByList(Long listId);

}
