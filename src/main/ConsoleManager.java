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
    public static boolean makeØvelse(){
        System.out.println("|-| Legg til øvelse ved å fylle ut dette skjemaet |-|");
        String navn = getInput("Navn:");
        String beskrivelse = getInput("Beskrivelse:");
        printMapList(QueryManager.getApparat());
        String apparat_id = getInput("ApparatID:");
        return QueryManager.addØvelse(navn, beskrivelse, apparat_id);
    }

    public static void printMapList(List<Map<String,String>> mapList) {
        String str = "";
        for (String v : mapList.get(0).keySet()){
            str += String.format("| %s |", v);
        }
        str += "\n";
        for (Map<String,String> map : mapList) {
            for (String v : map.values()){
                str += String.format("| %s |", v);
            }
        }
        System.out.println(str);
    }


    public static void main(String[] args) {
        /*for (String prompt : args){
            ConsoleManager.getInput(prompt);
        }*/
        System.out.println(makeØvelse());


    }
}
