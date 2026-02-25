package com.adrar.cdafad.controller;

import com.adrar.cdafad.entity.Manufacturer;
import com.adrar.cdafad.exception.manufacturer.ManufacturerIsPresentException;
import com.adrar.cdafad.repository.ManufacturerRepository;
import com.adrar.cdafad.service.ManufacturerService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ManufacturerController {

    private ManufacturerService manufacturerService;

    @PostMapping("/manufacturer")
    public ResponseEntity<Manufacturer> addManufacturer(@RequestBody Manufacturer manufacturer) {
        Manufacturer newManufacturer = this.manufacturerService.createManufacturer(manufacturer);
        return new ResponseEntity<>(newManufacturer, HttpStatus.CREATED);
    }

    @GetMapping("/manufacturer/{id}")
    public ResponseEntity<Manufacturer> getManufacturer(@PathVariable Integer id)
    {
        Manufacturer manufacturer = this.manufacturerService.getManufacturerById(id);
        return new ResponseEntity<>(manufacturer, HttpStatus.OK);
    }

    @GetMapping("/manufacturers")
    public ResponseEntity<Iterable<Manufacturer>> getAllCategories()
    {
        Iterable<Manufacturer> manufacturers = this.manufacturerService.getAllCategories();
        return new ResponseEntity<>(manufacturers, HttpStatus.OK);
    }

    @DeleteMapping("/manufacturer/{id}")
    public ResponseEntity<Map<String, String>> removeManufacturerById(@PathVariable Integer id) throws Exception
    {
        this.manufacturerService.deleteManufacturerById(id);
        Map<String, String> response = new HashMap<>();
        response.put("status", "OK");
        response.put("info", "La manufacturer à été supprimé");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
