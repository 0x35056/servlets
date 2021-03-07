package ru.appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Model implements Serializable {

    private static final Model instance = new Model();

    private final Map<Integer, Pet> modelPet;

    public Model() {
        modelPet = new HashMap<Integer, Pet>();
    }

    public static Model getInstance() {
        return instance;
    }

    public void add(Pet pet, int id) {
        modelPet.put(id, pet);
    }

    public Pet getFromList(int id) {
        return modelPet.get(id);
    }

    public Map<Integer, Pet> getFromList() {
        return modelPet;
    }

    public void del(int id) {
        for (Map.Entry<Integer, Pet> entry : modelPet.entrySet()) {
            if (entry.getKey() == id)
                modelPet.remove(id);
                break;
        }
    }

    public void put(Pet pet, int id) {
        for (Map.Entry<Integer, Pet> entry : modelPet.entrySet()) {
            if (entry.getKey() == id)
                modelPet.put(id, pet);
        }
    }
}
