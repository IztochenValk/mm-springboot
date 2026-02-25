package com.adrar.cdafad.exception.game;

public class GameIsNotExistsException extends RuntimeException {
    public GameIsNotExistsException(Integer id) {
        super("Le jeu avec id : " + id + " n'existe pas");
    }
}
