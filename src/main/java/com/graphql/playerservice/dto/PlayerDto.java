package com.graphql.playerservice.dto;

import com.graphql.playerservice.enums.Position;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerDto {
    private String firstName;
    private String lastName;
    private Position position;
}
