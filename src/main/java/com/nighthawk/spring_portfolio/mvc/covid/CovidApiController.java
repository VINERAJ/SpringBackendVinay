package com.nighthawk.spring_portfolio.mvc.covid;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // annotation to simplify the creation of RESTful web services
@RequestMapping("/api/covid")
public class CovidApiController {
    private JSONObject body;
    private HttpStatus status;
    private boolean success = false;
    String last_run = null;

    // GET Covid 19 Stats
    @GetMapping("/daily")
    public ResponseEntity<JSONObject> getCovid() {
        // logic is setup to only call API once a day, else serve it by last run
        String today = new Date().toString().substring(0,10); 
        if (!success || !today.equals(last_run))
        {
            try {
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
                this.body = (JSONObject) new JSONParser().parse(response.body());
                this.status = HttpStatus.OK;
                this.success = true;
                this.last_run = today;
            }
            catch (Exception e) {
                HashMap<String, String> status = new HashMap<>();
                status.put("status", "RapidApi failure: " + e);
                this.body = (JSONObject) status;
                this.status = HttpStatus.INTERNAL_SERVER_ERROR;
                this.success = false;
                this.last_run = null;
            }
        }

        //return JSONObject in REST style
        return new ResponseEntity<>(body, status);
    }
}