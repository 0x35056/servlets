package ru.appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
        Set<Map.Entry<Integer, Pet>> setOfEntries = modelPet.entrySet();

        Iterator<Map.Entry<Integer, Pet>> iterator = setOfEntries.iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Pet> entry = iterator.next();
            Integer key = entry.getKey();

            if (key == id) {
                iterator.remove();
            }
        }
    }

    public void put(int id, String name, String type, int age) {
        for (Map.Entry<Integer, Pet> entry : modelPet.entrySet()) {
            if (entry.getKey() == id) {
                entry.getValue().setName(name);
                entry.getValue().setType(type);
                entry.getValue().setAge(age);
                break;
            }
        }
    }
}