package com.ranjitha.se;

import java.io.FileReader;
import java.io.BufferedReader;

public class DocumentReader {

    /* Iterate through the list of files which the user gives as an input. */
    public  Document[] readFiles(String[] files){
        Document[] docs = new Document[files.length];
        for(int i = 0; i<files.length; i++){
            int docId = i;
            Document doc = readFromFile(files[i], docId);
            docs[i] = doc;

        }
        return docs;
    }

    /* Parse the list of files to return their corresponding document objects. */
    public Document readFromFile(String fileName, int docId){
        try {
            Document doc = new Document();
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;
            int count = 0;
            doc.setFileName(fileName);
            doc.setDocId(docId);
            while(  (line = br.readLine())  != null){
                line = line.toLowerCase();
                count++;
                if(count == 1){
                    doc.setTitle(line);
                }else if(count == 2){
                    doc.setAuthor(line);
                }else if(count == 3) {
                    doc.setBody(line);
                }else if(count ==4){
                    doc.setLocation(line);
                }else{
                    doc.setYear(Integer.parseInt(line));
                }

            }
            return doc;
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
