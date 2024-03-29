package com.nighthawk.spring_portfolio.mvc.project;



import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

// import com.nighthawk.project.WordsList;

@RestController
@RequestMapping("/words")
@CrossOrigin({"http://127.0.0.1:4100", "https://vineraj.github.io"})
public class WordsController {
    private WordsList wordsList = new WordsList();
    @GetMapping("/nouns")
    public ResponseEntity<?> getOneNoun(String word) {
        wordsList.createHashes();
        HashMap<String, String> nouns = wordsList.getNouns();
        String term = wordsList.getAWord(nouns, word);
        var response = new Object() {
            public final String translation = term;
        };
        return ResponseEntity.ok(response);
    }

    @GetMapping("/plural")
    public ResponseEntity<?> pluralNoun(String word) {
        wordsList.createHashes();
        HashMap<String, String> nouns = wordsList.getNouns();
        String temp = wordsList.getAWord(nouns, word);
        String term = wordsList.getConjugation(nouns, temp);
        var response = new Object() {
            public final String translation = term;
        };
        return ResponseEntity.ok(response);
    }
}
