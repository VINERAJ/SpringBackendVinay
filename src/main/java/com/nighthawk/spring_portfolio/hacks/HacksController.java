package com.nighthawk.spring_portfolio.hacks;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HacksController {
    @GetMapping("/mylogin")
    public String login() {
        return "mylogin";
    }

    @GetMapping("/hacks")
    public String hacks() {
        return "mylogin";
    }

    @GetMapping("/hacksgo")
    public String hacksgo() {
        return "hacks";
    }

    @GetMapping("/studentq")
    public ResponseEntity<?> getHack() {
        String hackString = Hacks.HackApi();
        var response = new Object() {
            public final String hackRes = hackString;
        };
        return ResponseEntity.ok(response);

    }
}
