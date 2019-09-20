package by.zapolski.week07;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

class URLEncodingExample {

    // Method to encode a string value using `UTF-8` encoding scheme
    private static String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }

    public static void main(String[] args) {
        String baseUrl = "http://localhost:8080/ship?shipJson=";

        String query = "[{\"type\":\"transport\",\"parametrs\":[{\"name\":\"Victory\"},{\"fuel\":1000},{\"fuelType\":\"diesel\"},{\"armor\":100},{\"color\":null},{\"carryingCapacity\":5000}]}]";
        String encodedQuery = encodeValue(query); // Encoding a query string

        String completeUrl = baseUrl + encodedQuery;
        System.out.println(completeUrl);
    }
}
