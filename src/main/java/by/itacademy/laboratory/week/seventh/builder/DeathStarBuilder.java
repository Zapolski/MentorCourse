package by.itacademy.laboratory.week.seventh.builder;

import by.itacademy.laboratory.week.seventh.model.paramter.NumberOfFighters;
import by.itacademy.laboratory.week.seventh.model.ship.DeathStar;

public class DeathStarBuilder extends WarShipBuilder<DeathStar> {

    @Override
    protected void setOtherParameters(DeathStar ship) {
        super.setOtherParameters(ship);
        ship.setNumberOgFighters(extract(NumberOfFighters.class).getValue());
    }
}
