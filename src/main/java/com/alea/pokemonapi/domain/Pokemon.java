package com.alea.pokemonapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class Pokemon {
    private String name;
    private int weight;
    private int height;
    private int baseExperience;
}
