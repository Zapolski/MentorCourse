package by.itacademy.laboratory.week.seventh.model.ship;

import by.itacademy.laboratory.week.seventh.model.Color;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public abstract class NonBattleShip extends Ship {

    private Color paintColor;
}
