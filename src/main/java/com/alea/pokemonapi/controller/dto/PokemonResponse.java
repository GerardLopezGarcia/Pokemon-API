package com.alea.pokemonapi.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PokemonResponse {

    private String name;
    private int weight;
    private int height;
    private int baseExperience;
}
