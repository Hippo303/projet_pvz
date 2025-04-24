package com.epf.API.Controllers;

import com.epf.API.DTO.DTOPlante;
import com.epf.API.DTO.MapperPlante;
import com.epf.core.model.Plante;
import com.epf.core.services.PlanteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plantes")
public class PlanteController {
    private final PlanteServices planteServices;
    private final MapperPlante mapperPlante;

    @Autowired
    public PlanteController(PlanteServices planteServices, MapperPlante mapperPlante) {
        this.planteServices = planteServices;
        this.mapperPlante = mapperPlante;
    }

    @GetMapping
    public ResponseEntity<List<DTOPlante>> getAllPlantes() {
        List<Plante> plantes = planteServices.getAllPlantes();
        List<DTOPlante> dtoPlantes = mapperPlante.toListDTOPlante(plantes);
        return new ResponseEntity<>(dtoPlantes, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DTOPlante> getPlante(@PathVariable("id") Integer id) {
        Plante plante = planteServices.getPlanteById(id);
        if (plante != null) {
            DTOPlante dtoPlante = mapperPlante.toDTOPlante(plante);
            return new ResponseEntity<>(dtoPlante, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<DTOPlante> createPlante(@RequestBody DTOPlante dtoPlante) {
        Plante plante = mapperPlante.toPlanteEntity(dtoPlante);
        Plante newPlante = planteServices.createPlante(plante);
        DTOPlante newDTOPlante = mapperPlante.toDTOPlante(newPlante);
        return new ResponseEntity<>(newDTOPlante, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<DTOPlante> updatePlante(@PathVariable("id") Integer id, @RequestBody DTOPlante dtoPlante) {
        Plante plante = mapperPlante.toPlanteEntity(dtoPlante);
        Plante updatedPlante = planteServices.updatePlante(plante, id);
        if (updatedPlante != null) {
            DTOPlante updatedDTOPlante = mapperPlante.toDTOPlante(updatedPlante);
            return new ResponseEntity<>(updatedDTOPlante, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deletePlante(@PathVariable("id") Integer id) {
        Plante plante = planteServices.getPlanteById(id);
        if (plante != null) {
            planteServices.deletePlante(id);
            return new ResponseEntity<>("Supprimé avec succès", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
