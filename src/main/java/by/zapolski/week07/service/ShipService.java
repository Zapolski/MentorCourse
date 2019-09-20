package by.zapolski.week07.service;

import by.zapolski.week07.factory.ShipFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ShipService {

    public String getShipObjectDescription (String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(json);
        JsonNode typeNode = rootNode.get(0).get("type");
        JsonNode parametersNode = rootNode.get(0).get("parameters");
        String type = typeNode.asText();
        return ShipFactory.getShip(type, parametersNode).toString();
    }
}
