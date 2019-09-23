package by.itacademy.laboratory.week.seventh.builder;

import by.itacademy.laboratory.week.seventh.model.paramter.FirePower;
import by.itacademy.laboratory.week.seventh.model.ship.WarShip;

public abstract class WarShipBuilder<SHIP extends WarShip> extends ShipBuilder<SHIP> {

    @Override
    protected void setOtherParameters(SHIP ship) {
        ship.setFirePower(extract(FirePower.class).getValue());
    }
}
