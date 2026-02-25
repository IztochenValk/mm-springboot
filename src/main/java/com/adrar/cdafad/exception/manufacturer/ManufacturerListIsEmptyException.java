package com.adrar.cdafad.exception.manufacturer;

public class ManufacturerListIsEmptyException extends RuntimeException {
    public ManufacturerListIsEmptyException() {
        super("La liste des manufacturers est vide");
    }
}
