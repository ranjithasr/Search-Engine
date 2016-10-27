package com.ranjitha.se;

import java.util.List;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] a) {
        Scanner scanner = new Scanner(System.in);
        String[] fileNames = {"file1", "file2"};

        DocumentReader dr = new DocumentReader();
        Document[] listOfDocuments = dr.readFiles(fileNames);

        Indexer indexer = new Indexer();
        HashMap<String, List<String>> index = indexer.indexDocs(listOfDocuments);

        SearchEngine searchEngine = new SearchEngine();
        while(true) {
            String query = scanner.nextLine().toLowerCase();
            List<String> results = searchEngine.search(query, index);
            if (results == null) {
                System.out.println("No results found");
            } else {
                System.out.println(results);
            }
        }

    }
}
