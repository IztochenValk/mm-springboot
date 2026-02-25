package com.adrar.cdafad.exception.manufacturer;

public class ManufacturerIsPresentException extends RuntimeException {
    public ManufacturerIsPresentException(String manufacturer) {
        super("La category avec le name : " + manufacturer + " existe déja");
    }
}
