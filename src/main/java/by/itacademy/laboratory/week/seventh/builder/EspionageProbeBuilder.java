package by.itacademy.laboratory.week.seventh.builder;

import by.itacademy.laboratory.week.seventh.model.paramter.ScanSensor;
import by.itacademy.laboratory.week.seventh.model.ship.EspionageProbe;

public class EspionageProbeBuilder extends NonBattleShipBuilder<EspionageProbe> {

    @Override
    protected void setOtherParameters(EspionageProbe ship) {
        super.setOtherParameters(ship);
        ship.setSensorType(extract(ScanSensor.class).getValue());
    }
}
