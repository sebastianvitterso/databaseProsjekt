package main;

public class Main {

    public static void main(String[] args) {
        //TODO: Start hva som skal vises i console
        boolean finished = false;
        while (!finished) {
            String input = ConsoleManager.getInput("Hei, hva ønsker du å gjøre?").toLowerCase();
            if(input.equals("slutt da") || input.equals("slutt")) {
                finished = true;
            } else if (input.equals("ny treningsøkt")){
                ConsoleManager.makeTreningsøkt();
            }
        }
    }
}
