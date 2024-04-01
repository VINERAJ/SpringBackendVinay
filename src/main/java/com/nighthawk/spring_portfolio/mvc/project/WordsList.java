package com.nighthawk.spring_portfolio.mvc.project;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Arrays;

import java.io.IOException;

public class WordsList {
    HashMap<String, String> nounsList = new HashMap<String, String>();
    public WordsList() {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("list.json");
        nounsList.put("person", "lozo");
        nounsList.put("human", "lozo");
        try {
            JsonNode rootNode = mapper.readTree(file);
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    JsonNode defNode = node.get("def");
                    JsonNode wordNode = node.get("word");
                    if (defNode != null && wordNode != null) {
                        nounsList.put(defNode.asText(), wordNode.asText());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, String> getNouns() {
        return nounsList;
    }

    public String getAWord(HashMap<String, String> listOfWords, String word) {
        for (HashMap.Entry<String, String> entry : listOfWords.entrySet()) {
            String key = entry.getKey().toLowerCase();
            if (key.equals(word.toLowerCase())) {
                return entry.getValue();
            }
        }
        return null;
    }

    public String getPlural(HashMap<String, String> listOfWords, String word) {
        char[] ch = word.toCharArray();
        switch(word.charAt(word.length()-1)) {
            case 'o': 
                ch[word.length()-1] = 'i';
                word = String.valueOf(ch);
                break;
            case 'y':
                ch[word.length()-2] = 'u';
                ch[word.length()-1] = 'm';
                word = String.valueOf(ch) + 'i';
                break;
            case 'a': 
                word = String.valueOf(ch)+"shi";
                break;
            case 'e':
                if (ch[word.length()-2]=='r') {
                    ch[word.length()-2] = 'd';
                    ch[word.length()-1] = 'u';
                    word = String.valueOf(ch)+"e";
                    break;
                } else {
                    ch[word.length()-1] = 'u';
                    word = String.valueOf(ch)+"e";
                }
                break;
            default:
                word = String.valueOf(ch);
                break;
        } 
        return word;
    }
}
