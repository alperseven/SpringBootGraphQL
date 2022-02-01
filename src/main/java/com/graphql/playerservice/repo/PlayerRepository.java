package com.graphql.playerservice.repo;

import com.graphql.playerservice.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player getByPlayerId(Long id);
}
