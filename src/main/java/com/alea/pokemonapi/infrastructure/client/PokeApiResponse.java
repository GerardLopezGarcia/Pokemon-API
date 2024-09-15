package com.alea.pokemonapi.infrastructure.client;

import lombok.Data;

import java.util.List;

@Data
public class PokeApiResponse {

    private int count;
    private String next;
    private String previous;
    private List<PokemonResult> results;


    @Data
    public static class PokemonResult {
        private String name;
        private String url;


    }
}