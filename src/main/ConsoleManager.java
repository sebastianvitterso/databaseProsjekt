package main;

import java.util.List;
import java.util.Map;
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
        return input;
    }

    public static boolean makeTreningsøkt(){
        System.out.println("|-| Legg til treningsøkt ved å fylle ut dette skjemaer |-|");
        String tidspunkt = getInput("Tidspunkt(YYYY-MM-DD hh:mm:ss):");
        String varighet = getInput("Varighet:");
        String form = getInput("Form:");
        String prestasjon = getInput("Prestasjon:");
        String notat = getInput("Notat(Optional):");
        boolean ok = QueryManager.addTreningsøkt(tidspunkt,varighet,form,prestasjon);
        if (notat != ""){
            String id = "";
            List<Map<String,String>> treningsøkter = QueryManager.getTreningsøktID(tidspunkt);
            for (Map<String, String> row : treningsøkter){
                id = row.get("treningsøkt_id");
            }
            ok = QueryManager.addNotat(notat, id);
        }
        return ok;
    }


    public static void main(String[] args) {
        /*for (String prompt : args){
            ConsoleManager.getInput(prompt);
        }*/
        System.out.println(makeTreningsøkt());


    }
}
