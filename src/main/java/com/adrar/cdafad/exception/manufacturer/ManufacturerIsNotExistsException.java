package com.adrar.cdafad.exception.manufacturer;

public class ManufacturerIsNotExistsException extends RuntimeException {
    public ManufacturerIsNotExistsException(Integer id) {
        super("Le manufacturer avec id : " + id + " n'existe pas");
    }
}
