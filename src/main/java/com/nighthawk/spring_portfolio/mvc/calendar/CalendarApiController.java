package com.nighthawk.spring_portfolio.mvc.calendar;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Pseudo Code / Implementation Prototypes 

@RestController
@RequestMapping("/api/calendar")
public class CalendarApiController {
    /** GET isLeapYear endpoint
     */
    @GetMapping("/isLeapYear/{year}")
    public ResponseEntity<Year> getIsLeapYear(@PathVariable int year) {
      // serializing leapYear to JSON not verified
      Year year_obj = new Year();

      year_obj.setYear(year);

      return new ResponseEntity<>(year_obj, HttpStatus.OK);  // response not tested
    }

    // add other methods
}
