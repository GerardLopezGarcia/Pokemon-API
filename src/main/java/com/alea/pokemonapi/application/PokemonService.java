package com.alea.pokemonapi.application;


import com.alea.pokemonapi.domain.Pokemon;
import com.alea.pokemonapi.domain.repository.PokemonRepository;
import com.alea.pokemonapi.exception.PokemonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonService {
    @Autowired
    private PokemonRepository pokemonRepository;

    public List<Pokemon> getHeaviestPokemons() {
        List<Pokemon> pokemons = pokemonRepository.getAllPokemons();
        if (pokemons.isEmpty()) {
            throw new PokemonNotFoundException("No Pokemons found in the database");
        }
        return pokemons.stream()
                .sorted((p1, p2) -> Integer.compare(p2.getWeight(), p1.getWeight()))
                .limit(5)
                .collect(Collectors.toList());
    }

    public List<Pokemon> getTallestPokemons() {
        List<Pokemon> pokemons = pokemonRepository.getAllPokemons();
        if (pokemons.isEmpty()) {
            throw new PokemonNotFoundException("No Pokemons found in the database");
        }
        return pokemons.stream()
                .sorted((p1, p2) -> Integer.compare(p2.getHeight(), p1.getHeight()))
                .limit(5)
                .collect(Collectors.toList());
    }

    public List<Pokemon> getMostExperiencedPokemons() {
        List<Pokemon> pokemons = pokemonRepository.getAllPokemons();
        if (pokemons.isEmpty()) {
            throw new PokemonNotFoundException("No Pokemons found in the database");
        }
        return pokemons.stream()
                .sorted((p1, p2) -> Integer.compare(p2.getBaseExperience(), p1.getBaseExperience()))
                .limit(5)
                .collect(Collectors.toList());
    }
    @ExceptionHandler(PokemonNotFoundException.class)
    public ResponseEntity<String> handlePokemonNotFoundException(PokemonNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
