package com.epf.persistance;

import java.util.List;

public interface daomapIn {
    void create(Maps map);
    Maps getById(int id);
    List<Maps> getAll();
    void update(Maps map);
    void delete(int id);
}
