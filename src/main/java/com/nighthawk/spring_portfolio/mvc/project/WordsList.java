package com.nighthawk.spring_portfolio.mvc.project;

import java.util.HashMap;

public class WordsList {
    HashMap<String, String> nounsList = new HashMap<String, String>();
    public void createHashes() {
        nounsList.put("Lozo", "Person/human");
    }

    public HashMap<String, String> getNouns() {
        return nounsList;
    }
}
