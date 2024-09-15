package com.alea.pokemonapi.application;

import com.alea.pokemonapi.domain.Pokemon;
import com.alea.pokemonapi.domain.repository.PokemonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PokemonServiceTest {

    @Mock
    private PokemonRepository pokemonRepository;

    @InjectMocks
    private PokemonService pokemonService;


    @Test
    void getHeaviestPokemons_shouldReturnTop5Heaviest() {
        List<Pokemon> mockPokemons = Arrays.asList(
                new Pokemon("Snorlax", 4600, 21, 189),
                new Pokemon("Groudon", 950, 35, 302),
                new Pokemon("Onix", 2100, 88, 77),
                new Pokemon("Wailord", 3980, 145, 280),
                new Pokemon("Steelix", 4000, 92, 175),
                new Pokemon("Lapras", 2200, 85, 187)
        );
        when(pokemonRepository.getAllPokemons()).thenReturn(mockPokemons);

        
        List<Pokemon> result = pokemonService.getHeaviestPokemons();

        assertEquals(5, result.size());
        assertEquals("Snorlax", result.get(0).getName());
        assertEquals("Steelix", result.get(1).getName());
    }

    @Test
    void getTallestPokemons_shouldReturnTop5Tallest() {
        
        List<Pokemon> mockPokemons = Arrays.asList(
                new Pokemon("Groudon", 950, 35, 302),
                new Pokemon("Onix", 2100, 88, 77),
                new Pokemon("Wailord", 3980, 145, 280),
                new Pokemon("Steelix", 4000, 92, 175),
                new Pokemon("Lapras", 2200, 85, 187)
        );
        when(pokemonRepository.getAllPokemons()).thenReturn(mockPokemons);

        
        List<Pokemon> result = pokemonService.getTallestPokemons();

        assertEquals(5, result.size());
        assertEquals("Wailord", result.get(0).getName());
    }

    @Test
    void getMostExperiencedPokemons_shouldReturnTop5Experienced() {
        
        List<Pokemon> mockPokemons = Arrays.asList(
                new Pokemon("Snorlax", 4600, 21, 189),
                new Pokemon("Groudon", 950, 35, 302),
                new Pokemon("Onix", 2100, 88, 77),
                new Pokemon("Wailord", 3980, 145, 280),
                new Pokemon("Steelix", 4000, 92, 175),
                new Pokemon("Lapras", 2200, 85, 187)
        );
        when(pokemonRepository.getAllPokemons()).thenReturn(mockPokemons);

        
        List<Pokemon> result = pokemonService.getMostExperiencedPokemons();

        assertEquals(5, result.size());
        assertEquals("Groudon", result.get(0).getName());
    }
}