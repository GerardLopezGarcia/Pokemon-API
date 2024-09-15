package com.alea.pokemonapi.controller.documentation;

import com.alea.pokemonapi.controller.dto.PokemonResponse;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
/*
    * Interfaz que define la documentación de los endpoints de la API de Pokémon.
    la ruta para acceder a la documentación es http://localhost:8080/v3/api-docs
 */
@Tag(name = "Pokémon API", description = "Endpoints para obtener información sobre Pokémon")
public interface PokemonApiDocs {

    @Operation(
            summary = "Obtener los Pokémon más pesados",
            description = "Devuelve una lista de los 5 Pokémon más pesados.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de Pokémon más pesados"),
                    @ApiResponse(responseCode = "500", description = "Error interno del servidor")
            }
    )
    ResponseEntity<List<PokemonResponse>> getHeaviestPokemons();

    @Operation(
            summary = "Obtener los Pokémon más altos",
            description = "Devuelve una lista de los 5 Pokémon más altos.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de Pokémon más altos"),
                    @ApiResponse(responseCode = "500", description = "Error interno del servidor")
            }
    )
    ResponseEntity<List<PokemonResponse>> getTallestPokemons();

    @Operation(
            summary = "Obtener los Pokémon con más experiencia base",
            description = "Devuelve una lista de los 5 Pokémon con más experiencia base.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de Pokémon con más experiencia base"),
                    @ApiResponse(responseCode = "500", description = "Error interno del servidor")
            }
    )
    ResponseEntity<List<PokemonResponse>> getMostExperiencedPokemons();
}
