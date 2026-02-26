package com.adrar.cdafad.dto;

import com.adrar.cdafad.entity.Game;

public class GameDTOWrapper {
    public static GameDTO toDto(Game game) {
        Integer year = game.getPublishAt().toLocalDate().getYear();
        return new GameDTO(game.getTitle(), game.getDescription(), year, game.getManufacturer().getName(), game.getManufacturer().getConsole());
    }
}