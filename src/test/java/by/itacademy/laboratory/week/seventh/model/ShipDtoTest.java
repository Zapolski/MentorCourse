package by.itacademy.laboratory.week.seventh.model;

import by.itacademy.laboratory.week.seventh.builder.factory.ShipBuilderFactory;
import by.itacademy.laboratory.week.seventh.dto.ShipDto;
import by.itacademy.laboratory.week.seventh.model.paramter.*;
import by.itacademy.laboratory.week.seventh.model.ship.Cruiser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class ShipDtoTest {

    @Test
    public void testConvertTo() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ShipDto shipDto = new ShipDto();
        shipDto.setType(ShipType.CRUISER);
        shipDto.setParameters(getCruiserParameters());

        String value = objectMapper.writeValueAsString(shipDto);
        assertNotNull(value);
    }

    @Test
    public void testConvertFrom() throws IOException {
        String value = "{\"type\":\"CRUISER\",\"parameters\":[{\"shipName\":{\"value\":\"Victory\"}},{\"fuel\":{\"value\":1500}},{\"fuelType\":{\"value\":\"DIESEL\"}},{\"firePower\":{\"value\":10000}},{\"numberOfGuns\":{\"value\":30}},{\"armor\":{\"value\":800}}]}";
        ObjectMapper objectMapper = new ObjectMapper();
        ShipDto shipDto = objectMapper.readValue(value, ShipDto.class);
        assertNotNull(shipDto);
    }

    @Test
    public void testBuilder() {
        Cruiser cruiser = ShipBuilderFactory.getBuilder(Cruiser.class)
                .setParameters(getCruiserParameters())
                .build();
        assertNotNull(cruiser);
    }

    private List<Parameter> getCruiserParameters() {
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(new ShipName("Victory"));
        parameters.add(new Fuel(1500));
        parameters.add(new FuelType(TypeOfFuel.DIESEL));
        parameters.add(new FirePower(10_000));
        parameters.add(new NumberOfGuns(30));
        parameters.add(new Armor(800));

        return parameters;
    }
}
