package by.itacademy.laboratory.week.seventh.model.ship;

import by.itacademy.laboratory.week.seventh.model.ScanSensorType;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class EspionageProbe extends NonBattleShip {

    private ScanSensorType sensorType;
}
