package by.zapolski.week07;

import by.zapolski.week07.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Ship fighter = new Fighter();
        Ship cruiser = new Cruiser();
        Ship deathStar = new DeathStar();

        Transport transport = new Transport();
        transport.setName("Victory");
        transport.setCarryingCapacity(5000);
        transport.setArmor(100);
        transport.setFuel(1000);
        transport.setFuelType("diesel");

        Ship spyProbe = new SpyProbe();

        System.out.println(fighter);
        System.out.println(cruiser);
        System.out.println(deathStar);

        System.out.println(transport);
        System.out.println(spyProbe);

        System.out.println();

        ObjectMapper objectMapper = new ObjectMapper();
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            objectMapper.writeValue(byteArrayOutputStream, transport);
            System.out.println(byteArrayOutputStream.toString("utf-8"));
        }


    }
}
