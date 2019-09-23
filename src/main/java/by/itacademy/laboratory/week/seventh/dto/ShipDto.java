package by.itacademy.laboratory.week.seventh.dto;

import by.itacademy.laboratory.week.seventh.model.ShipType;
import by.itacademy.laboratory.week.seventh.model.paramter.Parameter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShipDto {

    private ShipType type;
    private List<Parameter> parameters;
}
