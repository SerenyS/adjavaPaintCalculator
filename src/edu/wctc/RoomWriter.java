package edu.wctc;

import java.io.*;
import java.util.ArrayList;

public class RoomWriter {

    private String thisFile;

    public RoomWriter(String thisFile, ArrayList<Room> paintableRoomList) throws IOException {
        this.thisFile = thisFile;
        Writer saveToFile = new OutputStreamWriter((new FileOutputStream(thisFile)));
        for(int i =0 ; i<paintableRoomList.size(); i++){
            Room item = paintableRoomList.get(i);
            saveToFile.write(String.valueOf(item));
        }
    }
}


