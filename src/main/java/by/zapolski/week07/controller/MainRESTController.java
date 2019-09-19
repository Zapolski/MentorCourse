package by.zapolski.week07.controller;

import by.zapolski.week07.model.Transport;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MainRESTController {
	
	@RequestMapping("/")
	@ResponseBody
	public String welcome() {
		return "Hello from Ship Factory Rest Service";
	}
	
	@RequestMapping(value="/ship")
	public ResponseEntity<String> ship(@RequestParam(value = "shipType", required = true) String shipType) throws IOException {

	    Transport transport = new Transport();
        transport.setName("Victory");
        transport.setCarryingCapacity(5000);
        transport.setArmor(100);
        transport.setFuel(1000);
        transport.setFuelType("diesel");

	    ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(transport);

		return ResponseEntity.ok()
							 .contentType(MediaType.parseMediaType("text/json"))
							 .body(result);
	}	
}

