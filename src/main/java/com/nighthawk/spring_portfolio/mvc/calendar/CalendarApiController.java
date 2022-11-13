package com.nighthawk.spring_portfolio.mvc.calendar;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

// Pseudo Code / Implementation Prototypes 

@RestController
@RequestMapping("/api/calendar")
public class CalendarApiController {

    /** GET isLeapYear endpoint
     * ObjectMapper throws exceptions which should return 500 error
     * @throws JsonProcessingException
     * @throws JsonMappingException
     */
    @GetMapping("/isLeapYear/{year}")
    public ResponseEntity<JsonNode> getIsLeapYear(@PathVariable int year) throws JsonMappingException, JsonProcessingException {
      // Backend Year Object, evaluates Leap Year
      Year year_obj = new Year();
      year_obj.setYear(year);

      // Turn Year Object toString into JSON
      ObjectMapper mapper = new ObjectMapper(); // should move this under Try/Catch, but risk is low
      JsonNode json = mapper.readTree(year_obj.toString());

      return ResponseEntity.ok(json);  // JSON response
    }

    // add other methods
}
