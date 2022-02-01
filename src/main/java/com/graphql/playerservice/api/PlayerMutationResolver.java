package com.graphql.playerservice.api;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.playerservice.dto.PlayerDto;
import com.graphql.playerservice.entity.Player;
import com.graphql.playerservice.exceptions.PlayerException;
import com.graphql.playerservice.mapper.PlayerMapper;
import com.graphql.playerservice.repo.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
public class PlayerMutationResolver implements GraphQLMutationResolver {

    private static final PlayerMapper mapper = PlayerMapper.INSTANCE;

    private final PlayerRepository playerRepository;

    @Transactional
    public Player addNewPlayer(PlayerDto playerDto) {
        if(playerRepository.count() < 12) {
            Player player = mapper.mapToDto(playerDto);
            return playerRepository.save(player);
        } else {
            throw new PlayerException("Team at maximum capacity.");
        }
    }

    @Transactional
    public Boolean deletePlayer(Long id) {
        if(playerRepository.getByPlayerId(id) != null) {
            playerRepository.deleteById(id);
            return true;
        } else {
            throw new PlayerException("Player Not Found.");
        }
    }
}
