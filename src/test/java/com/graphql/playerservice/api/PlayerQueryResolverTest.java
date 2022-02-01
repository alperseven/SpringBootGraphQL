package com.graphql.playerservice.api;

import com.graphql.playerservice.entity.Player;
import com.graphql.playerservice.enums.Position;
import com.graphql.playerservice.repo.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class PlayerQueryResolverTest {

    @Mock
    private PlayerRepository playerRepository;

    private PlayerQueryResolver queryResolver;

    private List<Player> playerList;

    @BeforeEach
    void setUp() {
        initMocks(this);
        playerList = new ArrayList<>();
        Player player = new Player();
        player.setPlayerId(1L);
        player.setFirstName("test");
        player.setLastName("test");
        player.setPosition(Position.PG);
        playerList.add(player);
        queryResolver = new PlayerQueryResolver(playerRepository);
    }

    @Test
    void testGetAllPlayers(){
        when(playerRepository.findAll()).thenReturn(playerList);
        assertEquals(queryResolver.getAllPlayers().size(), 1);
    }
}