package ru.appline.controller;

import ru.appline.logic.Compass;
import ru.appline.logic.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Controller {

    private static final Model model = Model.getInstance();

/*
{
    "north": "338-23",

    "northEast" : "24-67",

    "east":  "68-112",

    "southEast" : "113-157",

    "south": "158-202",

    "southWest" : "203-247",

    "west": "248-292",

    "northWest": "293-337"
}
*/

    @PostMapping(value = "/create", consumes = "application/json")
    public void create(@RequestBody Compass compass) {
        model.add(compass);
    }

    @GetMapping(value = "/get", produces = "application/json")
    public Map<String,Compass> get() {
        return model.getFromList();
    }

/*
    {
        "degree": 56
    }
*/

    @GetMapping(value = "/getSide", consumes = "application/json", produces = "application/json")
    public Map<String,String> getSide(@RequestBody Map<String, Integer> degree) {
        return model.getSide(degree.get("degree"));
    }
}
