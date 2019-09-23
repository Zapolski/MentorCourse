package by.itacademy.laboratory.week.seventh.model.paramter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class ParameterBase<T> implements Parameter {

    private T value;
}
