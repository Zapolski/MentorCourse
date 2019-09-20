package by.zapolski.week07.controller;

import by.zapolski.week07.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class MainRESTController {

    @Autowired
    ShipService shipService;
	
	@RequestMapping("/")
	@ResponseBody
	public String welcome() {
		return "Hello from Ship Factory Rest Service";
	}
	
	@RequestMapping(value="/ship",method = RequestMethod.POST)
	public ResponseEntity<String> ship(@RequestBody String shipJson) throws IOException {
	    String result = shipService.getShipObjectDescription(shipJson);
		return ResponseEntity.ok()
							 .contentType(MediaType.parseMediaType("text/json"))
							 .body(result);
	}	
}