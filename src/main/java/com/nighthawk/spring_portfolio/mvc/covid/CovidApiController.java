package com.nighthawk.spring_portfolio.mvc.covid;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController // annotation to simplify the creation of RESTful web services
@RequestMapping("/api/covid")
public class CovidApiController {
    /*
    GET Covid 19 Stats
     */
    @GetMapping("/daily")
    public ResponseEntity<JSONObject> getCovid() throws IOException, InterruptedException, ParseException{

        //rapid api code
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://corona-virus-world-and-india-data.p.rapidapi.com/api"))
            .header("x-rapidapi-key", "dec069b877msh0d9d0827664078cp1a18fajsn2afac35ae063")
            .header("x-rapidapi-host", "corona-virus-world-and-india-data.p.rapidapi.com")
            .method("GET", HttpRequest.BodyPublishers.noBody())
            .build();

        //rapid api call
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        //using JSONParser, extract body and cast object to JSONObject
        JSONObject jo = (JSONObject) new JSONParser().parse(response.body());
        
        //return JSONObject in REST style
        return new ResponseEntity<>(jo, HttpStatus.OK);
    }
}