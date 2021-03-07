package ru.appline.controller;

import org.springframework.web.bind.annotation.*;
import ru.appline.logic.Model;
import ru.appline.logic.Pet;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Controller {


    private static final Model model = Model.getInstance();
    private static final AtomicInteger newId = new AtomicInteger(1);

    /*
        {
            "name" : "Felix",
            "type" : "cat",
            "age" : 3
        }
     */

    @ResponseBody
    @PostMapping(value = "/createPet", consumes = "application/json", produces="application/text; charset=UTF-8")
    public String createPet(@RequestBody Pet pet) {
        String s = null;

        if (newId.get() == 1) {
            s = "Вы создали первого питомца";
        } else {
            s = "Вы создали питомца";
        }

        model.add(pet, newId.getAndIncrement());

        return s;
    }

    /*
        {
            "id" : 3
        }
    */

    @GetMapping(value = "/getPet", consumes = "application/json", produces = "application/json")
    public Pet getPet(@RequestBody Map<String, Integer> id) {
        return model.getFromList(id.get("id"));
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public Map<Integer, Pet> getAll() {
        return model.getFromList();
    }

    @DeleteMapping(value = "/deletePet", consumes = "application/json")
    public void deletePet(@RequestBody Map<String, Integer> id) {
        model.del(id.get("id"));
    }

    @PutMapping(value = "/putPet", consumes = "application/json")
    public void putPet(@RequestBody Map<Integer, Pet> map) {
        for (Map.Entry<Integer, Pet> entry : map.entrySet()) {
            int id = entry.getKey();
            Pet pet = entry.getValue();
            model.put(pet, id);
        }
    }
}
