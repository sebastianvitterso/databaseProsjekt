package main;

import java.util.Scanner;

public class ConsoleManager {

    public static String getInput(String prompt) {
        System.out.println(prompt);
        String input = "";
        try {
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println(String.format("Doing: %s", input));
        return input;
    }


    public static void main(String[] args) {
        for (String prompt : args){
            ConsoleManager.getInput(prompt);
        }

    }
}
