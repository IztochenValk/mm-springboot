package com.adrar.cdafad.exception.game;

public class DeleteGameImpossibleException extends RuntimeException {
    public DeleteGameImpossibleException() {
        super("La suppression est impossible");
    }
}
