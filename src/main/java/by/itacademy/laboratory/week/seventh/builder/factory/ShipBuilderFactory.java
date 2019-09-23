package by.itacademy.laboratory.week.seventh.builder.factory;

import by.itacademy.laboratory.week.seventh.builder.*;
import by.itacademy.laboratory.week.seventh.model.ship.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ShipBuilderFactory {

    private static final Map<Class<? extends Ship>, Supplier<? extends ShipBuilder<?>>> BUILDERS = new HashMap<>();

    static {
        BUILDERS.put(Cruiser.class, CruiserBuilder::new);
        BUILDERS.put(DeathStar.class, DeathStarBuilder::new);
        BUILDERS.put(Fighter.class, FighterBuilder::new);
        BUILDERS.put(EspionageProbe.class, EspionageProbeBuilder::new);
        BUILDERS.put(Transport.class, TransportBuilder::new);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Ship, BUILDER extends ShipBuilder<T>> BUILDER getBuilder(Class<T> clazz) {
        return (BUILDER) BUILDERS.get(clazz).get();
    }
}
