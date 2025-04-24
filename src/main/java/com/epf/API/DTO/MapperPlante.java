package com.epf.API.DTO;

import com.epf.core.model.Plante;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MapperPlante {

    public DTOPlante toDTOPlante(Plante plante) {
        return new DTOPlante(
                plante.getId(),
                plante.getNom(),
                plante.getpoint_de_vie(),
                plante.getattaque_par_seconde(),
                plante.getdegat_attaque(),
                plante.getCout(),
                plante.getsoleil_par_seconde(),
                plante.getEffet(),
                plante.getCheminImage()
        );
    }

    public List<DTOPlante> toListDTOPlante(List<Plante> plantes) {
        return plantes.stream().map(this::toDTOPlante).toList();
    }

    public Plante toPlanteEntity(DTOPlante dtoPlante) {
        return new Plante(
                dtoPlante.getId_plante(),
                dtoPlante.getNom(),
                dtoPlante.getPoint_de_vie(),
                dtoPlante.getAttaque_par_seconde(),
                dtoPlante.getDegat_attaque(),
                dtoPlante.getCout(),
                dtoPlante.getSoleil_par_seconde(),
                dtoPlante.getEffet(),
                dtoPlante.getChemin_image()
        );
    }

    public List<Plante> toListPlanteEntity(List<DTOPlante> dtoPlantes) {
        return dtoPlantes.stream().map(this::toPlanteEntity).toList();
    }
}
