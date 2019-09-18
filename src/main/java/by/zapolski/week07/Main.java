package by.zapolski.week07;

import by.zapolski.week07.model.Fighter;
import by.zapolski.week07.model.Ship;
import by.zapolski.week07.model.Transport;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Transport transport = new Transport();
        transport.setName("Victory");
        transport.setCarryingCapacity(5000);
        transport.setArmor(100);
        transport.setFuel(1000);
        transport.setFuelType("diesel");



        Ship fighter = new Fighter();

        System.out.println(transport);
        System.out.println(fighter);


        ObjectMapper objectMapper = new ObjectMapper();
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            objectMapper.writeValue(byteArrayOutputStream, transport);
            System.out.println(byteArrayOutputStream.toString("utf-8"));
        }
    }
}
