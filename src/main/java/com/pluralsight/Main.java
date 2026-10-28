package com.pluralsight;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner read = new Scanner(System.in);

        System.out.println("🌙 Welcome to Bedtime Stories!");
        System.out.println("----------------------------");
        System.out.println("1. Goldilocks and the Three Bears");
        System.out.println("2. Hansel and Gretel");
        System.out.println("3. Mary Had a Little Lamb");
        System.out.println("4. Exit");
        System.out.println("----------------------------");
        System.out.print("Choose a story (1-4): ");

        String menuChoice = read.nextLine();

        String storyName = "";

        switch (menuChoice) {
            case "1" -> storyName = "goldilocks.txt";
            case "2" -> storyName = "hansel_and_gretel.txt";
            case "3" -> storyName = "mary_had_a_little_lamb.txt";

            case "4" -> {
                System.out.println("Good night! Sweet dreams!");
                return;
            }
            default -> {
                System.out.println("Invalid selection: ");
            }
        }

        System.out.println("You selected: " + storyName);
        try (FileReader fileReader = new FileReader("src/main/resources/" + storyName)) {
            BufferedReader bufReader = new BufferedReader(fileReader);
            System.out.println("File opened successfully!");

            String line;
            int lineNumber = 1;
            while ((line = bufReader.readLine()) != null) {
                System.out.println(lineNumber + ". " + line);
                lineNumber++;

            }


        } catch(IOException e) {
            System.out.println("Error opening file: "+ e.getMessage());
        }
        System.out.println("Working Directory: " + System.getProperty("user.dir"));



    }
//     reader.close();
}
