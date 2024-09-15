package com.alea.pokemonapi.infrastructure.repository;

import com.alea.pokemonapi.domain.Pokemon;
import com.alea.pokemonapi.domain.repository.PokemonRepository;
import com.alea.pokemonapi.infrastructure.client.PokeApiClient;
import com.alea.pokemonapi.infrastructure.client.PokeApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PokemonRepositoryImpl implements PokemonRepository {
    @Autowired
    private PokeApiClient pokeApiClient;

    @Override
    public List<Pokemon> getAllPokemons() {
        PokeApiResponse response = pokeApiClient.getAllPokemons(1000, 0);
        return response.getResults().stream()
                .map(result -> new Pokemon(result.getName(), 0, 0, 0))
                .collect(Collectors.toList());
    }
}
