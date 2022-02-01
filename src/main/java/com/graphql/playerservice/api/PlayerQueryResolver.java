package com.graphql.playerservice.api;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.playerservice.entity.Player;
import com.graphql.playerservice.repo.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PlayerQueryResolver implements GraphQLQueryResolver {

    private final PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
}
