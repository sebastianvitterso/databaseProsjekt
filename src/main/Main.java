package main;

public class Main {

    public static void main(String[] args) {
        //TODO: Start hva som skal vises i console
        boolean finished = false;
        while (!finished) {
            String input = ConsoleManager.getInput("Hei, hva ønsker du å gjøre?").toLowerCase();
            switch (input){
                case "slutt da": case "slutt":
                    finished = true;
                    break;
                case "ny treningsøkt":
                    ConsoleManager.makeTreningsøkt();
                    break;
                case "ny øvelse":
                    ConsoleManager.makeØvelse();
                    break;
                case "se valgmuligheter":
                    System.out.println("'slutt da'/'slutt' : Avslutter programmet \n" +
                            "'ny treningsøkt' : Legg inn ny treningsøkt\n" +
                            "'ny øvelse' : Legg inn ny øvelse");
            }
            /*
            if(input.equals("slutt da") || input.equals("slutt")) {
                finished = true;
            } else if (input.equals("ny treningsøkt")){
                ConsoleManager.makeTreningsøkt();
            }
            */
        }
    }
}
