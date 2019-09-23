package by.itacademy.laboratory.week.seventh.builder;

import by.itacademy.laboratory.week.seventh.model.paramter.FlightSpeed;
import by.itacademy.laboratory.week.seventh.model.ship.Fighter;

public class FighterBuilder extends WarShipBuilder<Fighter> {

    @Override
    protected void setOtherParameters(Fighter ship) {
        super.setOtherParameters(ship);
        ship.setFlightSpeed(extract(FlightSpeed.class).getValue());
    }
}
