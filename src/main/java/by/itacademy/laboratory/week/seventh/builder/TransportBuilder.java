package by.itacademy.laboratory.week.seventh.builder;

import by.itacademy.laboratory.week.seventh.model.paramter.CarryingCapacity;
import by.itacademy.laboratory.week.seventh.model.ship.Transport;

public class TransportBuilder extends NonBattleShipBuilder<Transport> {

    @Override
    protected void setOtherParameters(Transport ship) {
        super.setOtherParameters(ship);
        ship.setCarryingCapacity(extract(CarryingCapacity.class).getValue());
    }
}
