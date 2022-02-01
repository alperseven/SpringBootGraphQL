package com.graphql.playerservice.api;

import com.graphql.playerservice.dto.PlayerDto;
import com.graphql.playerservice.entity.Player;
import com.graphql.playerservice.enums.Position;
import com.graphql.playerservice.exceptions.PlayerException;
import com.graphql.playerservice.repo.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class PlayerMutationResolverTest {

    @Mock
    private PlayerRepository playerRepository;

    private PlayerMutationResolver mutationResolver;

    private Player player;

    private PlayerDto playerDto;

    private PlayerException ex;

    @BeforeEach
    void setUp() {
        initMocks(this);
        player = new Player();
        player.setPlayerId(1L);
        player.setFirstName("test");
        player.setLastName("test");
        player.setPosition(Position.PG);
        playerDto = new PlayerDto();
        playerDto.setFirstName("test");
        playerDto.setLastName("test");
        playerDto.setPosition(Position.PG);
        ex = new PlayerException("Error");
        mutationResolver = new PlayerMutationResolver(playerRepository);
    }

    @Test
    public void testAddNewPlayer() {
        when(playerRepository.save(any(Player.class))).thenReturn(player);
        assertEquals(mutationResolver.addNewPlayer(playerDto), player);
    }

    @Test
    public void testAddNewPlayerThrowExcp() {
        when(playerRepository.count()).thenReturn(13L);
        assertThrows(PlayerException.class, () -> {
            mutationResolver.addNewPlayer(playerDto);
        });
    }

    @Test
    public void testDeletePlayer() {
        when(playerRepository.getByPlayerId(1L)).thenReturn(player);
        assertEquals(mutationResolver.deletePlayer(1L), true);
    }

    @Test
    public void testDeletePlayerThrowExcp() {
        when(playerRepository.getByPlayerId(1L)).thenReturn(null);
        assertThrows(PlayerException.class, () -> {
            mutationResolver.deletePlayer(1L);
        });
    }
}