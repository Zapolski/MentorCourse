package by.itacademy.laboratory.week.seventh.model.paramter;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.WRAPPER_OBJECT;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;


@JsonTypeInfo(use = NAME, include = WRAPPER_OBJECT, property = "type")
@JsonSubTypes({
        @Type(value = Armor.class, name = "armor"),
        @Type(value = Capacity.class, name = "capacity"),
        @Type(value = CarryingCapacity.class, name = "carryingCapacity"),
        @Type(value = FirePower.class, name = "firePower"),
        @Type(value = Fuel.class, name = "fuel"),
        @Type(value = FuelType.class, name = "fuelType"),
        @Type(value = NumberOfFighters.class, name = "numberOfFighters"),
        @Type(value = NumberOfGuns.class, name = "numberOfGuns"),
        @Type(value = PaintColor.class, name = "paintColor"),
        @Type(value = ScanSensor.class, name = "scanSensor"),
        @Type(value = ShipName.class, name = "shipName")
})
public interface Parameter {
}
