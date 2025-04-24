package com.epf.API.DTO;

import com.epf.core.model.Zombie;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MapperZombie {
    public DTOZombie toDTOZombie(Zombie zombie) {
        return new DTOZombie(
                zombie.getId(),
                zombie.getNom(),
                zombie.getpoint_de_vie(),
                zombie.getattaque_par_seconde(),
                zombie.getdegat_attaque(),
                zombie.getvitesse_de_deplacement(),
                zombie.getchemin_image(),
                zombie.getid_map());
    }
    public List<DTOZombie> toListDTOZombie(List<Zombie> zombie) {
        return zombie.stream().map(this::toDTOZombie).toList();
    }

    public Zombie toZombieEntity(DTOZombie dtozombie) {
        return new Zombie(
                dtozombie.getId_zombie(),
                dtozombie.getNom(),
                dtozombie.getPoint_de_vie(),
                dtozombie.getAttaque_par_seconde(),
                dtozombie.getDegat_attaque(),
                dtozombie.getVitesse_de_deplacement(),
                dtozombie.getChemin_image(),
                dtozombie.getId_map());
    }
    public List<Zombie> toListZombieEntity(List<DTOZombie> dtozombie) {
        return dtozombie.stream().map(this::toZombieEntity).toList();
    }


}
