package com.epf.API.Controllers;

import com.epf.API.DTO.DTOMap;
import com.epf.API.DTO.MapperMap;
import com.epf.core.model.Map;
import com.epf.core.services.MapServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maps")
public class MapController {
    private final MapServices mapServices;
    private final MapperMap mapperMap;

    @Autowired
    public MapController(MapServices mapServices, MapperMap mapperMap) {
        this.mapServices = mapServices;
        this.mapperMap = mapperMap;
    }

    @GetMapping
    public ResponseEntity<List<DTOMap>> getAllMaps() {
        List<Map> maps = mapServices.getAllMaps();
        List<DTOMap> dtoMaps = mapperMap.toListDTOMap(maps);
        return new ResponseEntity<>(dtoMaps, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DTOMap> getMap(@PathVariable("id") Integer id) {
        Map map = mapServices.getMapById(id);
        if (map != null) {
            DTOMap dtoMap = mapperMap.toDTOMap(map);
            return new ResponseEntity<>(dtoMap, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<DTOMap> createMap(@RequestBody DTOMap dtoMap) {
        try{
            Map map = mapperMap.toMapEntity(dtoMap);
            Map newMap = mapServices.createMap(map);
            DTOMap newDTOMap = mapperMap.toDTOMap(newMap);
            return new ResponseEntity<>(newDTOMap, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println("Erreur lors de la création de la map : " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<DTOMap> updateMap(@PathVariable("id") Integer id, @RequestBody DTOMap dtoMap) {
        Map existingMap = mapServices.getMapById(id);
        if (existingMap == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (dtoMap.getLigne() != null) existingMap.setLigne(dtoMap.getLigne());
        if (dtoMap.getColonne() != null) existingMap.setColonne(dtoMap.getColonne());
        if (dtoMap.getChemin_image() != null) existingMap.setCheminImage(dtoMap.getChemin_image());

        Map updated = mapServices.updateMap(existingMap, id);
        DTOMap updatedDTO = mapperMap.toDTOMap(updated);
        return new ResponseEntity<>(updatedDTO, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteMap(@PathVariable("id") Integer id) {
        Map map = mapServices.getMapById(id);
        if (map != null) {
            mapServices.deleteMap(id);
            return new ResponseEntity<>("Supprimé avec succès", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
