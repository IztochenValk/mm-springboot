package com.adrar.cdafad.controller;

import com.adrar.cdafad.entity.Game;
import com.adrar.cdafad.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class GameController {

    private GameService gameService;

    @PostMapping("/game")
    public ResponseEntity<Game> addGame(@RequestBody Game game) {
        Game newGame = this.gameService.createGame(game);
        return new ResponseEntity<>(newGame, HttpStatus.CREATED);
    }

    @GetMapping("/game/{id}")
    public ResponseEntity<Game> getGame(@PathVariable Integer id)
    {
        Game game = this.gameService.getGameById(id);
        return new ResponseEntity<>(game, HttpStatus.OK);
    }

    @GetMapping("/games")
    public ResponseEntity<Iterable<Game>> getAllGames()
    {
        Iterable<Game> games = this.gameService.getAllGames();
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @DeleteMapping("/game/{id}")
    public ResponseEntity<Map<String, String>> removeGameById(@PathVariable Integer id) throws Exception
    {
        this.gameService.deleteGameById(id);
        Map<String, String> response = new HashMap<>();
        response.put("status", "OK");
        response.put("info", "La game à été supprimé");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
