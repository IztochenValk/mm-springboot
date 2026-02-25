package com.adrar.cdafad.controller;

import com.adrar.cdafad.exception.game.DeleteGameImpossibleException;
import com.adrar.cdafad.exception.game.GameIsNotExistsException;
import com.adrar.cdafad.exception.game.GameIsPresentException;
import com.adrar.cdafad.exception.game.GameListIsEmptyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GameControllerAdvice {

    @ExceptionHandler(GameIsPresentException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> GameIsExists(GameIsPresentException e)
    {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error", e.getMessage());
        return errorMap;
    }

    @ExceptionHandler(GameIsNotExistsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> GameIsNotExists(GameIsNotExistsException e)
    {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error", e.getMessage());
        return errorMap;
    }

    @ExceptionHandler(GameListIsEmptyException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Map<String, String> GameListIsEmpty(GameListIsEmptyException e)
    {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error", e.getMessage());
        return errorMap;
    }

    @ExceptionHandler(DeleteGameImpossibleException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> DeleteGameImpossible(DeleteGameImpossibleException e)
    {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error", e.getMessage());
        return errorMap;
    }
}
