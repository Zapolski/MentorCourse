package by.itacademy.laboratory.week.seventh.model;

import by.itacademy.laboratory.week.seventh.model.ship.*;
import lombok.Getter;

@Getter
public enum ShipType {
    TRANSPORT(Transport.class),
    FIGHTER(Fighter.class),
    CRUISER(Cruiser.class),
    ESPIONAGE_PROBE(EspionageProbe.class),
    DEATH_STAR(DeathStar.class);

    private Class<? extends Ship> shipClass;

    ShipType(Class<? extends Ship> shipClass) {
        this.shipClass = shipClass;
    }
}
