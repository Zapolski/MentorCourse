package by.itacademy.laboratory.week.seventh.builder;

import by.itacademy.laboratory.week.seventh.model.paramter.PaintColor;
import by.itacademy.laboratory.week.seventh.model.ship.NonBattleShip;

public abstract class NonBattleShipBuilder<SHIP extends NonBattleShip> extends ShipBuilder<SHIP> {

    @Override
    protected void setOtherParameters(SHIP ship) {
        ship.setPaintColor(extract(PaintColor.class).getValue());
    }
}
