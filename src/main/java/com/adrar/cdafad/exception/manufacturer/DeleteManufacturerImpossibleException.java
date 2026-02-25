package com.adrar.cdafad.exception.manufacturer;

public class DeleteManufacturerImpossibleException extends RuntimeException {
    public DeleteManufacturerImpossibleException() {
        super("La suppression est impossible");
    }
}
