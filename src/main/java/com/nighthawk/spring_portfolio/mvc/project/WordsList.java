package com.nighthawk.spring_portfolio.mvc.project;

import java.util.HashMap;

public class WordsList {
    HashMap<String, String> nounsList = new HashMap<String, String>();
    public void createHashes() {
        nounsList.put("person", "lozo");
        nounsList.put("human", "lozo");
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
}
