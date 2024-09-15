package com.alea.pokemonapi.controller;

import com.alea.pokemonapi.application.PokemonService;
import com.alea.pokemonapi.controller.documentation.PokemonApiDocs;
import com.alea.pokemonapi.controller.dto.PokemonResponse;
import com.alea.pokemonapi.exception.PokemonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alea-api/pokemons")
public class PokemonController implements PokemonApiDocs {
    @Autowired
    private  PokemonService pokemonService;

    @GetMapping("/heaviest")
    public ResponseEntity<List<PokemonResponse>> getHeaviestPokemons() {
        List<PokemonResponse> heaviestPokemons = pokemonService.getHeaviestPokemons().stream()
                .map(pokemon -> new PokemonResponse(pokemon.getName(), pokemon.getWeight(), pokemon.getHeight(), pokemon.getBaseExperience()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(heaviestPokemons);
    }

    @GetMapping("/tallest")
    public ResponseEntity<List<PokemonResponse>> getTallestPokemons() {
        List<PokemonResponse> tallestPokemons = pokemonService.getTallestPokemons().stream()
                .map(pokemon -> new PokemonResponse(pokemon.getName(), pokemon.getWeight(), pokemon.getHeight(), pokemon.getBaseExperience()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(tallestPokemons);
    }

    @GetMapping("/most-experienced")
    public ResponseEntity<List<PokemonResponse>> getMostExperiencedPokemons() {
        List<PokemonResponse> mostExperiencedPokemons = pokemonService.getMostExperiencedPokemons().stream()
                .map(pokemon -> new PokemonResponse(pokemon.getName(), pokemon.getWeight(), pokemon.getHeight(), pokemon.getBaseExperience()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(mostExperiencedPokemons);
    }

    @ExceptionHandler(PokemonNotFoundException.class)
    public ResponseEntity<String> handlePokemonNotFoundException(PokemonNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
