package edu.wctc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaintCalculator {

    private ArrayList<Room> PaintableRoomList = new ArrayList<>();
    private Scanner keyboard;
    public String thisFile;
    // public File file = new File("file.cvs");

    public static void main(String[] args) {
        new PaintCalculator();
    }

    public PaintCalculator() {
        keyboard = new Scanner(System.in);

        int option = 0;

        while (option != 5) {
            printMenu();

            String s = keyboard.nextLine();
            try {
                int choice = Integer.parseInt(s);
                switch (choice) {
                    case 1:
                        createRoom();
                        break;
                    case 2:
                        writeFile();
                        break;
                    case 3:
                        readFile();
                        break;
                    case 4:
                        printRooms();
                        break;
                    case 5:
                        System.out.println("Goodbye");
                        System.exit(0);
                    case 6:
                        createArtPiece();
                }
            } catch (NumberFormatException | FileNotFoundException e) {
                System.out.println("Invalid choice");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (artClassException e) {
                e.printStackTrace();
            }
        }

    }

    private void printRooms() {
        if (PaintableRoomList.isEmpty()) {
            System.out.println("No rooms yet");
        }

        for (Room room : PaintableRoomList) {
            System.out.println(room.toString());
        }
    }

    private void printMenu() {
        System.out.println();
        System.out.println("1. Add room");
        System.out.println("2. Write rooms to file");
        System.out.println("3. Read rooms from file");
        System.out.println("4. View rooms");
        System.out.println("5. Exit");
        System.out.println("6. Add Art Piece");
        System.out.println();
    }

    private int promptForDimension(String name) {
        System.out.print("Enter the room's " + name + ": ");
        String response = keyboard.nextLine();
        try {
            return Integer.parseInt(response);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void createRoom() {
        int length = promptForDimension("length");
        int width = promptForDimension("width");
        int height = promptForDimension("height");

        try {
            Room room = new Room(length, width, height);
            PaintableRoomList.add(room);

            System.out.println("Room successfully created");
        } catch (BadWidthException | BadHeightException e) {
            System.out.println("Could not create room.");
        }

    }

    private void createArtPiece() throws artClassException {
        System.out.println("What material is it");
        String material = keyboard.nextLine();
        System.out.println("What the name of the Art Piece");
        String name = keyboard.nextLine();
        System.out.println("Whats the size in sq ft?");
        String size = keyboard.nextLine();
        try{
            double size1 = Double.parseDouble(size);
            ArtPiece pieceCreated = new ArtPiece(material,name,size1);
        } catch(artClassException e){
            System.out.println("Size is invalid");
        }




    }

    private void writeFile() throws IOException {
        RoomWriter serializedRoom = new RoomWriter(thisFile, PaintableRoomList);
        System.out.println(serializedRoom);


    }

    private void readFile() {
        RoomReader deserializedRoom = new RoomReader();
        System.out.println(deserializedRoom);


    }


}
