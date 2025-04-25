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
        try{
            Plante plante = mapperPlante.toPlanteEntity(dtoPlante);
            Plante newPlante = planteServices.createPlante(plante);
            DTOPlante newDTOPlante = mapperPlante.toDTOPlante(newPlante);
            return new ResponseEntity<>(newDTOPlante, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println("Erreur lors de la création de la plante : " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<DTOPlante> updatePlante(@PathVariable("id") Integer id, @RequestBody DTOPlante dtoPlante) {
        Plante existing = planteServices.getPlanteById(id);
        if (existing == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (dtoPlante.getNom() != null) existing.setNom(dtoPlante.getNom());
        if (dtoPlante.getPoint_de_vie() != null) existing.setpoint_de_vie(dtoPlante.getPoint_de_vie());
        if (dtoPlante.getAttaque_par_seconde() != null) existing.setattaque_par_seconde(dtoPlante.getAttaque_par_seconde());
        if (dtoPlante.getDegat_attaque() != null) existing.setdegat_attaque(dtoPlante.getDegat_attaque());
        if (dtoPlante.getCout() != null) existing.setCout(dtoPlante.getCout());
        if (dtoPlante.getSoleil_par_seconde() != null) existing.setsoleil_par_seconde(dtoPlante.getSoleil_par_seconde());
        if (dtoPlante.getEffet() != null) existing.setEffet(dtoPlante.getEffet());
        if (dtoPlante.getChemin_image() != null) existing.setCheminImage(dtoPlante.getChemin_image());

        Plante updated = planteServices.updatePlante(existing, id);
        return new ResponseEntity<>(mapperPlante.toDTOPlante(updated), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deletePlante(@PathVariable("id") Integer id) {
        try{
            Plante plante = planteServices.getPlanteById(id);
            if (plante != null) {
                planteServices.deletePlante(id);
                return new ResponseEntity<>("Supprimé avec succès", HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Erreur lors de la suppression de la plante.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
