package main;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConsoleManager {

    public static String latestTimestamp = "";

    public static String getInput(String prompt) {
        System.out.println(prompt);
        String input = "";
        try {
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine().toLowerCase();
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
        if (ok){
            latestTimestamp = tidspunkt;
        }
        if (notat != "" && ok){
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
    public static boolean makeApparat(){
        System.out.println("|-| Legg til apparat ved å fylle ut dette skjemaet |-|");
        String navn = getInput("Navn:");
        String beskrivelse = getInput("Beskrivelse:");
        return QueryManager.addApparat(navn, beskrivelse);
    }
    public static boolean makeØvelseIØkt(){
        System.out.println("|-| Legg til øvelse i økt ved å fylle ut dette skjemaet |-|");
        printMapList(QueryManager.getØvelse());
        String øvelse = getInput("Øvelse:");
        String kilo = getInput("Kilo:");
        String repetisjoner = getInput("Repetisjoner:");
        String sett = getInput("Sett:");
        String resultat = getInput("Resultat:");

        String id = "";
        List<Map<String,String>> treningsøkter = QueryManager.getTreningsøktID(latestTimestamp);
        for (Map<String, String> row : treningsøkter){
            id = row.get("treningsøkt_id");
        }
        return QueryManager.addØvelseIØkt(id, øvelse, kilo, repetisjoner, sett, resultat);
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
            str += "\n";
        }
        System.out.println(str);
    }


    public static void main(String[] args) {
        /*for (String prompt : args){
            ConsoleManager.getInput(prompt);
        }*/
        System.out.println(makeØvelseIØkt());


    }
}
