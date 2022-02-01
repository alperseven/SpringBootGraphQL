package com.graphql.playerservice.mapper;

import com.graphql.playerservice.dto.PlayerDto;
import com.graphql.playerservice.entity.Player;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class PlayerMapper {
    public static final PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);
    public abstract Player mapToDto(PlayerDto playerDto);
}
