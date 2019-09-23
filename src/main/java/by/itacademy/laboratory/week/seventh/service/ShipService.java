package by.itacademy.laboratory.week.seventh.service;

import by.itacademy.laboratory.week.seventh.builder.factory.ShipBuilderFactory;
import by.itacademy.laboratory.week.seventh.dto.ShipDto;
import by.itacademy.laboratory.week.seventh.model.ship.Ship;
import org.springframework.stereotype.Service;

@Service
public class ShipService {

    public Ship buildShip(ShipDto shipDto) {
        return ShipBuilderFactory.getBuilder(shipDto.getType().getShipClass())
                .setParameters(shipDto.getParameters())
                .build();
    }
}
