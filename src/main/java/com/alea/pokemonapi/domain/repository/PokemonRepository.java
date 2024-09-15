package com.alea.pokemonapi.domain.repository;

import com.alea.pokemonapi.domain.Pokemon;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository {
    List<Pokemon> getAllPokemons();
}
