package by.itacademy.laboratory.week.seventh.builder;

import by.itacademy.laboratory.week.seventh.model.paramter.NumberOfGuns;
import by.itacademy.laboratory.week.seventh.model.ship.Cruiser;

public class CruiserBuilder extends WarShipBuilder<Cruiser> {

    @Override
    protected void setOtherParameters(Cruiser ship) {
        super.setOtherParameters(ship);
        ship.setNumberOfGuns(extract(NumberOfGuns.class).getValue());
    }
}
