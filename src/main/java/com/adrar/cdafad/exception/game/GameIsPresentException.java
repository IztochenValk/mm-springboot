package com.adrar.cdafad.exception.game;

public class GameIsPresentException extends RuntimeException {
    public GameIsPresentException(String category) {
        super("Le jeux avec le title : " + category + " existe déja");
    }
}
