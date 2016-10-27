package com.ranjitha.se;

import java.util.List;
import java.util.HashMap;

public class SearchEngine {

    /* Return the list of documents the user query is present in. */
    public List<String> search(String userQuery, HashMap<String, List<String>> index){
        String[] userQueryWords = userQuery.split(" ");
        List<String> solutionList = index.get(userQueryWords[0]);
        for(int i = 1; i<userQueryWords.length; i++){
            String currentWord = userQueryWords[i];
            List<String> listOfFiles = index.get(currentWord);
            if(listOfFiles==null){
                return null;
            }
            solutionList.retainAll(listOfFiles);
        }
        return solutionList;
    }
}
