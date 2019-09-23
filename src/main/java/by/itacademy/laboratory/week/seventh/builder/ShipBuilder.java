package by.itacademy.laboratory.week.seventh.builder;

import by.itacademy.laboratory.week.seventh.model.paramter.*;
import by.itacademy.laboratory.week.seventh.model.ship.Ship;
import org.springframework.cglib.core.ReflectUtils;
import org.springframework.core.GenericTypeResolver;

import java.util.List;

public abstract class ShipBuilder<SHIP extends Ship> {

    private List<Parameter> parameters;

    public SHIP build() {
        SHIP ship = createEmptyShip();
        ship.setName(extract(ShipName.class).getValue());
        ship.setArmor(extract(Armor.class).getValue());
        ship.setFuel(extract(Fuel.class).getValue());
        ship.setTypeOfFuel(extract(FuelType.class).getValue());
        setOtherParameters(ship);

        return ship;
    }

    public ShipBuilder<SHIP> setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
        return this;
    }

    protected abstract void setOtherParameters(SHIP ship);

    @SuppressWarnings("unchecked")
    public <T extends Parameter> T extract(Class<T> clazz) {
        return (T) parameters.stream()
                .filter(it -> it.getClass() == clazz)
                .findFirst()
                .orElse(null);
    }

    @SuppressWarnings("unchecked")
    public SHIP createEmptyShip() {
        Class<?> clazz = GenericTypeResolver.resolveTypeArgument(this.getClass(), ShipBuilder.class);
        return (SHIP) ReflectUtils.newInstance(clazz);
    }
}
