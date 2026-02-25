package com.adrar.cdafad.controller;

import com.adrar.cdafad.exception.manufacturer.ManufacturerIsNotExistsException;
import com.adrar.cdafad.exception.manufacturer.ManufacturerIsPresentException;
import com.adrar.cdafad.exception.manufacturer.ManufacturerListIsEmptyException;
import com.adrar.cdafad.exception.manufacturer.DeleteManufacturerImpossibleException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ManufacturerControllerAdvice {

    @ExceptionHandler(ManufacturerIsPresentException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> ManufacturerIsExists(ManufacturerIsPresentException e)
    {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error", e.getMessage());
        return errorMap;
    }

    @ExceptionHandler(ManufacturerIsNotExistsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> ManufacturerIsNotExists(ManufacturerIsNotExistsException e)
    {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error", e.getMessage());
        return errorMap;
    }

    @ExceptionHandler(ManufacturerListIsEmptyException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Map<String, String> ManufacturerListIsEmpty(ManufacturerListIsEmptyException e)
    {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error", e.getMessage());
        return errorMap;
    }

    @ExceptionHandler(DeleteManufacturerImpossibleException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> DeleteManufacturerImpossible(DeleteManufacturerImpossibleException e)
    {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error", e.getMessage());
        return errorMap;
    }
}
