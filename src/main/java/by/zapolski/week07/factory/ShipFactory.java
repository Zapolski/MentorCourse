package by.zapolski.week07.factory;

import by.zapolski.week07.model.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class ShipFactory {

    private ShipFactory() {
    }

    public static Ship getShip(String type, JsonNode parametersNode) throws IOException {
        Class<Ship> shipClass = getShipClass(type);
        String jsonForDeserealization = getStringForJacsonDeserealization(shipClass,parametersNode);
        return new ObjectMapper().readValue(jsonForDeserealization, shipClass);
    }

    private static Class<Ship> getShipClass(String type){
        Class result;
        switch (type) {
            case "transport":
                result = Transport.class;
                break;
            case "cruiser":
                result = Cruiser.class;
                break;
            case "deathStar":
                result = DeathStar.class;
                break;
            case "fighter":
                result = Fighter.class;
                break;
            case "spyProbe":
                result = SpyProbe.class;
                break;
            default:
                throw new IllegalArgumentException();
        }
        return result;
    }

    private static String getStringForJacsonDeserealization(Class shipClass,JsonNode parametersNode){
        StringBuilder sb = new StringBuilder();
        sb.append("{\"type\":\"").append(shipClass.getSimpleName()).append('"');

        for (JsonNode objNode : parametersNode) {
            Iterator<Map.Entry<String, JsonNode>> fieldsIterator = objNode.fields();
            while (fieldsIterator.hasNext()) {
                Map.Entry<String, JsonNode> field = fieldsIterator.next();
                sb.append(',');
                sb.append('"').append(field.getKey()).append('"').append(':');

                if (field.getValue().isInt() || field.getValue().isNull()){
                    sb.append(field.getValue().asText());
                }else{
                    sb.append('"').append(field.getValue().asText()).append('"');
                }
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
