package com.adrar.cdafad.service;

import com.adrar.cdafad.entity.Manufacturer;
import com.adrar.cdafad.exception.manufacturer.ManufacturerIsNotExistsException;
import com.adrar.cdafad.exception.manufacturer.ManufacturerIsPresentException;
import com.adrar.cdafad.exception.manufacturer.ManufacturerListIsEmptyException;
import com.adrar.cdafad.exception.manufacturer.DeleteManufacturerImpossibleException;
import com.adrar.cdafad.repository.ManufacturerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ManufacturerService {

    private ManufacturerRepository manufacturerRepository;

    //Méthodes du service
    //Méthode qui ajoute une manufacturer
    public Manufacturer createManufacturer(Manufacturer manufacturer)  {

        if(manufacturerRepository.findByName(manufacturer.getName()).isPresent()) {
            throw new ManufacturerIsPresentException(manufacturer.getName());
        }

        return manufacturerRepository.save(manufacturer);
    }

    //Méthode qui retourne une manufacturer par son ID
    public Manufacturer getManufacturerById(Integer id){
        //Récupération de la manufacturer (findById du repository)
        Optional<Manufacturer> manufacturer = manufacturerRepository.findById(id);
        //Test si elle n'existe pas
        if (!manufacturer.isPresent()) {
            throw new ManufacturerIsNotExistsException(id);
        }
        return manufacturer.get();
    }

    //méthode qui retourne la liste de toutes les manufacturers
    public Iterable<Manufacturer> getAllCategories()  {
        //Test si la list est vide
        if (manufacturerRepository.count() == 0) {
            throw new ManufacturerListIsEmptyException();
        }
        return manufacturerRepository.findAll();
    }


    public void deleteManufacturerById(Integer id)
    {
        try {
            this.manufacturerRepository.deleteById(id);
        } catch (Exception e)
        {
            throw new DeleteManufacturerImpossibleException();
        }
    }
}
