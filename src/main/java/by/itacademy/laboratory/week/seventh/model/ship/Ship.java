package by.itacademy.laboratory.week.seventh.model.ship;

import by.itacademy.laboratory.week.seventh.model.TypeOfFuel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Ship {

    private String name;
    private Integer fuel;
    private TypeOfFuel typeOfFuel;
    private Integer armor;
}
