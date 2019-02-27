package main;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryManager {

    public static boolean addØvelse(String navn, String beskrivelse, String apparat_id){
        String sql = String.format("INSERT INTO øvelse VALUES(NULL,'%s','%s','%s')", navn, apparat_id, beskrivelse);
        return((DatabaseManager.sendUpdate(sql)) > 0);
    }
    public static boolean addØvelseUtenApparat(String navn, String beskrivelse){
        String sql = String.format("INSERT INTO øvelse VALUES(NULL,'%s',NULL,'%s')", navn, beskrivelse);
        return((DatabaseManager.sendUpdate(sql)) > 0);
    }

    public static boolean addTreningsøkt(String tidspunkt, String varighet, String form, String prestasjon){
        String sql = String.format("INSERT INTO treningsøkt VALUES(NULL,'%s','%s','%s','%s')", tidspunkt, varighet, form, prestasjon);
        return((DatabaseManager.sendUpdate(sql)) > 0);
    }
    public static boolean addNotat(String tekst, String treningsøkt_id){
        String sql = String.format("INSERT INTO notat VALUES(NULL,'%s', '%s')", treningsøkt_id, tekst);
        return((DatabaseManager.sendUpdate(sql)) > 0);
    }
    public static boolean addApparat(String navn, String beskrivelse){
        String sql = String.format("INSERT INTO apparat VALUES(NULL,'%s', '%s')", navn, beskrivelse);
        return((DatabaseManager.sendUpdate(sql)) > 0);
    }
    public static boolean addØvelseIØkt(String treningsøkt_id, String øvelse_id, String kilo, String repitisjoner, String sett, String resultat){
        String sql = String.format("INSERT INTO øvelse_i_økt VALUES('%s','%s','%s','%s','%s','%s')", øvelse_id, treningsøkt_id, kilo, repitisjoner, sett, resultat);
        return((DatabaseManager.sendUpdate(sql)) > 0);
    }

    public static boolean addØvelsesGruppe(String beskrivelse){
        String sql = String.format("INSERT INTO øvelsesgruppe VALUES(NULL,'%s')", beskrivelse);
        return((DatabaseManager.sendUpdate(sql)) > 0);
    }

    public static boolean addØvelseIØvelsesGruppe(String øvelse_id, String øvelsesgruppe_id){
        String sql = String.format("INSERT INTO øvelse_i_øvelsegruppe VALUES('%s','%s')", øvelse_id, øvelsesgruppe_id);
        return((DatabaseManager.sendUpdate(sql)) > 0);
    }

    public static List<Map<String, String>> getTreningsøktID(String tidspunkt){
        String sql = String.format("SELECT treningsøkt_id FROM treningsøkt WHERE tidspunkt = '%s'", tidspunkt);
        return(DatabaseManager.sendQuery(sql));
    }

    public static List<Map<String, String>> getApparat(){
        String sql = String.format("SELECT * FROM apparat");
        return(DatabaseManager.sendQuery(sql));
    }

    public static List<Map<String, String>> getØvelser(){
        String sql = String.format("SELECT * FROM øvelse");
        return(DatabaseManager.sendQuery(sql));
    }
    public static List<Map<String, String>> getØvelsesGrupper(){
        String sql = String.format("SELECT * FROM øvelsesgruppe");
        return(DatabaseManager.sendQuery(sql));
    }

    public static List<Map<String, String>> getTreningsøkterMedNotat(){
        String sql = String.format("SELECT tidspunkt, varighet, form, prestasjon, tekst FROM treningsøkt NATURAL JOIN notat ORDER BY tidspunkt DESC");
        return(DatabaseManager.sendQuery(sql));
    }

    public static List<Map<String, String>> getResultat (String tidspunkt_nedre, String tidspunkt_ovre){
        String sql = String.format("SELECT resultat, antall_kg, antall_repetisjoner, antall_set, tidspunkt FROM øvelse_i_økt NATURAL JOIN treningsøkt WHERE '%s' < tidspunkt AND '%s' > tidspunkt ORDER BY tidspunkt", tidspunkt_nedre, tidspunkt_ovre);
        return(DatabaseManager.sendQuery(sql));
    }

    public static List<Map<String, String>> getLikeØvelser (String øvelse_id_input){


        String sql = String.format("SELECT øvelsesgruppe_id FROM øvelse_i_øvelsegruppe NATURAL JOIN øvelse WHERE øvelse_id = '%s' ", øvelse_id_input);
        List<Map<String, String>> liste = DatabaseManager.sendQuery(sql);

        List<Map<String, String>> ferdig = new ArrayList<>();

        for (Map<String, String> map : liste){
            String id = map.get("øvelsesgruppe_id");
            String sql2 = String.format("SELECT * FROM øvelse_i_øvelsegruppe NATURAL JOIN øvelse WHERE øvelsesgruppe_id = '%s'", id);
            //DatabaseManager.sendQuery(sql2);
            List<Map<String, String>> tmp = DatabaseManager.sendQuery(sql2);

            for (Map<String, String> element : tmp){
                if (!(ferdig.contains(element))) {
                    ferdig.add(element);
                }
            }

        }

        return(ferdig);
    }

    public static void main(String[] args){
    }

}

