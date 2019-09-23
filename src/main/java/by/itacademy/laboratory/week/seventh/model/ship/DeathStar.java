package by.itacademy.laboratory.week.seventh.model.ship;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class DeathStar extends WarShip {

    private Integer numberOgFighters;
}
