package com.alea.pokemonapi.infrastructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "pokeapi", url = "https://pokeapi.co/api/v2")
public interface PokeApiClient {
    @GetMapping("/pokemon")
    PokeApiResponse getAllPokemons(@RequestParam(name = "limit") int limit, @RequestParam(name = "offset") int offset);

}
