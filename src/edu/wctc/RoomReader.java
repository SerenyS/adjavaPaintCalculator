package edu.wctc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RoomReader {

    private String fileName;


    public void readRoomFile (String fileName) throws IOException {

        this.fileName = fileName;

        BufferedReader extractFromFile = new BufferedReader(new FileReader(fileName));
        String read = extractFromFile.readLine();
       while ( read!= null){
           System.out.println(read);
       }


    }

}


