package com.adrar.cdafad.repository;

import com.adrar.cdafad.entity.Category;
import com.adrar.cdafad.entity.Manufacturer;
import com.adrar.cdafad.service.ManufacturerService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManufacturerRepository extends CrudRepository<Manufacturer, Integer> {
    public boolean existsByName(String name);
    Optional<Manufacturer> findByName(String name);
    Optional<Manufacturer> findById(Integer id);

}
