package by.zapolski.week07.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="type")
public abstract class AbstractShip implements Ship{
    String name;
    Integer fuel;
    String fuelType;
    Integer armor;
}
