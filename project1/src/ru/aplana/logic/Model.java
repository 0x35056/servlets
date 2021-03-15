package ru.aplana.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Model implements Serializable {

    private static final Model instance = new Model();

    private final Map<Integer, User> model;

    public static Model getInstance() {
        return instance;
    }

    private Model() {

        model = new HashMap<>();

        model.put(1, new User("Ivan", "Ivanov", 100000));
        model.put(2, new User("Anna", "Petrova", 200000));
        model.put(3, new User("Max", "Pain", 300000));
        model.put(4, new User("Philipp", "Kirkorov", 400000));
    }

    public void add(User user, int id) {
        model.put(id, user);
    }

    public User get(int id) {
        User user = new User();
        for (Map.Entry<Integer, User> entry : model.entrySet()) {
            if (entry.getKey() == id) {
                user = model.get(id);
                break;
            }
        }

        return user;
    }

    public void del(int id) {
        Set<Map.Entry<Integer, User>> setOfEntries = model.entrySet();

        Iterator<Map.Entry<Integer, User>> iterator = setOfEntries.iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, User> entry = iterator.next();
            Integer key = entry.getKey();

            if (key == id) {
                iterator.remove();
            }
        }
    }

    public void put(int id, String name, String surname, double salary) {
        for (Map.Entry<Integer, User> entry : model.entrySet()) {
            if (entry.getKey() == id) {
                entry.getValue().setName(name);
                entry.getValue().setSurname(surname);
                entry.getValue().setSalary(salary);
                break;
            }
        }
    }

    public Map<Integer, User> getFromList() {
        return model;
    }
}