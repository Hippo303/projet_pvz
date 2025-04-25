package com.epf.API.Controllers;

import com.epf.API.DTO.DTOZombie;
import com.epf.API.DTO.MapperZombie;
import com.epf.core.model.Zombie;
import com.epf.core.services.ZombieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zombies")
public class ZombieController {
    private final ZombieServices zombieServices;
    private final MapperZombie mapperZombie;

    @Autowired
    public ZombieController(ZombieServices zombieServices, MapperZombie mapperZombie) {
        this.zombieServices = zombieServices;
        this.mapperZombie = mapperZombie;
    }

    @GetMapping
    public ResponseEntity<List<DTOZombie>> getAllZombies() {
        List<Zombie> zombies = zombieServices.getAllZombies();
        List<DTOZombie> dtozombies = mapperZombie.toListDTOZombie(zombies);
        return new ResponseEntity<>(dtozombies, HttpStatus.OK);

    }
    @GetMapping(path ="/{id}")
    public ResponseEntity<DTOZombie> getZombie(@PathVariable ("id") Integer id) {
        Zombie zombie = zombieServices.getZombieById(id);
        if (zombie!=null) {
            DTOZombie dtoZombie = mapperZombie.toDTOZombie(zombie);
            return new ResponseEntity<>(dtoZombie, HttpStatus.OK);
        }else {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}

    }
    @PostMapping
    public ResponseEntity<DTOZombie> createZombie(@RequestBody DTOZombie dtoZombie) {
        try {
            Zombie zombie = mapperZombie.toZombieEntity(dtoZombie);
            Zombie newzombie = zombieServices.createZombie(zombie);
            DTOZombie newDTOZombie = mapperZombie.toDTOZombie(newzombie);
            return new ResponseEntity<>(newDTOZombie, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println("Erreur lors de la création du zombie : " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
    @PutMapping(path ="/{id}")
    public ResponseEntity<DTOZombie> updateZombie(@PathVariable ("id") Integer id, @RequestBody DTOZombie dtoZombie) {
        Zombie existingZombie = zombieServices.getZombieById(id);
        if (existingZombie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (dtoZombie.getNom() != null) existingZombie.setNom(dtoZombie.getNom());
        if (dtoZombie.getPoint_de_vie() != null) existingZombie.setpoint_de_vie(dtoZombie.getPoint_de_vie());
        if (dtoZombie.getAttaque_par_seconde() != null) existingZombie.setattaque_par_seconde(dtoZombie.getAttaque_par_seconde());
        if (dtoZombie.getDegat_attaque() != null) existingZombie.setdegat_attaque(dtoZombie.getDegat_attaque());
        if (dtoZombie.getVitesse_de_deplacement() != null) existingZombie.setvitesse_de_deplacement(dtoZombie.getVitesse_de_deplacement());
        if (dtoZombie.getChemin_image() != null) existingZombie.setchemin_image(dtoZombie.getChemin_image());
        if (dtoZombie.getId_map() != null) existingZombie.setid_map(dtoZombie.getId_map());

        Zombie updated = zombieServices.updateZombie(existingZombie, id);
        DTOZombie updatedDTO = mapperZombie.toDTOZombie(updated);
        return new ResponseEntity<>(updatedDTO, HttpStatus.OK);

    }

    @DeleteMapping(path ="/{id}")
    public ResponseEntity<String> deleteZombie(@PathVariable ("id") Integer id) {
        Zombie zombie = zombieServices.getZombieById(id);
        if (zombie!=null) {
            zombieServices.deleteZombie(id);
            return new ResponseEntity<>("supprimé avec succès",HttpStatus.NO_CONTENT);
        }else {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
    }
}
