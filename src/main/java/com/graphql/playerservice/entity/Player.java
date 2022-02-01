package com.graphql.playerservice.entity;

import com.graphql.playerservice.enums.Position;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long playerId;

    private String firstName;

    private String lastName;

    private Position position;
}
