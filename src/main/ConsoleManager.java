package main;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Calendar;

public class ConsoleManager {

    public static String latestTimestamp = "2019-02-27 19:11:30";

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
        //String tidspunkt = getInput("Tidspunkt(YYYY-MM-DD hh:mm:ss):");

        Calendar c = Calendar.getInstance();
        SimpleDateFormat defaultF = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String tidspunkt = defaultF.format(c.getTime());
        System.out.println(tidspunkt);
        String varighet = getInput("Varighet:");
        String form = getInput("Form:");
        String prestasjon = getInput("Prestasjon:");
        String notat = getInput("Notat(Optional):");
        boolean ok = QueryManager.addTreningsøkt(tidspunkt,varighet,form,prestasjon);
        if (ok){
            latestTimestamp = tidspunkt;
            prestasjon();
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
        if (apparat_id.equals("")){
            return QueryManager.addØvelseUtenApparat(navn, beskrivelse);
        }
        return QueryManager.addØvelse(navn, beskrivelse, apparat_id);
    }
    public static boolean makeApparat(){
        System.out.println("|-| Legg til apparat ved å fylle ut dette skjemaet |-|");
        String navn = getInput("Navn:");
        String beskrivelse = getInput("Beskrivelse:");
        return QueryManager.addApparat(navn, beskrivelse);
    }
    public static boolean makeØvelsesGruppe(){
        System.out.println("|-| Legg til øvelsesgruppe ved å fylle ut dette skjemaet |-|");
        String beskrivelse = getInput("Beskrivelse:");
        return QueryManager.addØvelsesGruppe(beskrivelse);
    }
    public static boolean makeØvelseIØvelsesGruppe(){
        System.out.println("|-| Legg til øvelse i øvelsesgruppe ved å fylle ut dette skjemaet |-|");
        printMapList(QueryManager.getØvelser());
        String øvelse = getInput("ØvelseID:");
        printMapList(QueryManager.getØvelsesGrupper());
        String øvelsegruppe = getInput("ØvelseGruppeID:");
        return QueryManager.addØvelseIØvelsesGruppe(øvelse, øvelsegruppe);
    }

    public static boolean makeØvelseIØkt(){
        System.out.println("|-| Legg til øvelse i økt ved å fylle ut dette skjemaet |-|");
        printMapList(QueryManager.getØvelser());
        String øvelse = getInput("Øvelse:");
        String kilo = getInput("Kilo:");
        String repetisjoner = getInput("Repetisjoner:");
        String sett = getInput("Sett:");
        String resultat = getInput("Resultat:");
        String id = null;
        List<Map<String,String>> treningsøkter = QueryManager.getTreningsøktID(latestTimestamp);
        for (Map<String, String> row : treningsøkter){
            id = row.get("treningsøkt_id");
        }
        return QueryManager.addØvelseIØkt(id, øvelse, kilo, repetisjoner, sett, resultat);
    }

    public static void getNSisteTreningsøkter() {
        int n = Integer.parseInt(getInput("Hvor mange treningsøkter vil du vise?"));
        List<Map<String,String>> treningsøkter = QueryManager.getTreningsøkterMedNotat();
        String str = "";
        for (String v : treningsøkter.get(0).keySet()){
            str += String.format("| %s |", v);
        }
        str += "\n";
        int i = 0;
        for (Map<String,String> map : treningsøkter) {
            for (String v : map.values()){
                str += String.format("| %s |", v);
            }
            str += "\n";
            i++;
            if (i == n){
                break;
            }
        }
        System.out.println(str);
    }

    public static boolean prestasjon(){
        List<Map<String,String>> treningsøkter = QueryManager.getTreningsøkterMedNotat();
        if (treningsøkter.size() % 2 == 0){
            System.out.println("Ta deg en sjokolade, du har vært flink til å trene.");
            return true;
        }
        return false;
    }


    public static void getResultat(){
        String nedre = getInput("Nedre tidsgrense:");
        String øvre = getInput("Øvre tidsgrense:");
        printMapList(QueryManager.getResultat(nedre,øvre));
    }

    public static void getLike() {
        printMapList(QueryManager.getØvelser());
        String øvelse = getInput("Øvelse:");
        printMapList(QueryManager.getLikeØvelser(øvelse));
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
        makeTreningsøkt();

    }
}
