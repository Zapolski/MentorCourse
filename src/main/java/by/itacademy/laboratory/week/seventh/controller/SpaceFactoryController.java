package by.itacademy.laboratory.week.seventh.controller;

import by.itacademy.laboratory.week.seventh.dto.ShipDto;
import by.itacademy.laboratory.week.seventh.model.ship.Ship;
import by.itacademy.laboratory.week.seventh.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/api/v1/ship/factory")
public class SpaceFactoryController {

    private final ShipService shipService;

    @Autowired
    public SpaceFactoryController(ShipService shipService) {
        this.shipService = shipService;
    }

    @PostMapping(value = "/build", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public Ship buildSheep(@RequestBody ShipDto shipDto) {
        return shipService.buildShip(shipDto);
    }
}
