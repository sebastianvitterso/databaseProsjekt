package main;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryManager {

    public static boolean addØvelse(String navn, String beskrivelse, String apparat_id){
        String sql = String.format("INSERT INTO øvelse VALUES(%s,'%s','%s','%s')", "NULL", navn, beskrivelse, apparat_id);
        return((DatabaseManager.sendUpdate(sql)) > 0);
    }




    public static boolean addTreningsøkt(String tidspunkt, String varighet, String form, String prestasjon){
        String sql = String.format("INSERT INTO treningsøkt VALUES(%s,'%s','%s','%s','%s')", "NULL", tidspunkt, varighet, form, prestasjon);
        return((DatabaseManager.sendUpdate(sql)) > 0);
    }
    public static boolean addNotat(String tekst, String treningsøkt_id){
        String sql = String.format("INSERT INTO notat VALUES(%s,'%s', '%s')", "NULL", treningsøkt_id, tekst);
        return((DatabaseManager.sendUpdate(sql)) > 0);
    }
    public static boolean addApparat(String navn, String beskrivelse){
        String sql = String.format("INSERT INTO apparat VALUES(NULL,'%s', '%s')", navn, beskrivelse);
        return((DatabaseManager.sendUpdate(sql)) > 0);
    }
    public static boolean addØvelseIØkt(String treningsøkt_id, String øvelse_id, String kilo, String repitisjoner, String sett, String resultat){
        String sql = String.format("INSERT INTO øvelse_i_økt VALUES('%s','%s','%s','%s','%s','%s')", treningsøkt_id, øvelse_id, kilo, repitisjoner, sett, resultat);
        return((DatabaseManager.sendUpdate(sql)) > 0);
    }

    public static boolean addØvelsesGruppe(String øvelsegruppe_id, String beskrivelse){
        String sql = String.format("INSERT INTO øvelse_i_økt VALUES('%s','%s')", "NULL", beskrivelse);
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


    public static List<Map<String, String>> getTreningsøkterMedNotat(){
        String sql = String.format("SELECT * FROM treningsøkt NATURAL JOIN notat");
        return(DatabaseManager.sendQuery(sql));
    }
//For hver enkelt øvelse skal det være mulig å se en resultatlogg i et gitt tidsintervall
//spesifisert av brukeren.

    public static List<Map<String, String>> getResulat (String tidspunkt_input){
        String sql = String.format("SELECT resultat, kilo, repitisjoner, sett, tidspunkt FROM øvelse_i_økt NATURAL JOIN treningsøkt WHERE '/s' > tidspunkt ORDER BY tidspunkt", tidspunkt_input);
        return(DatabaseManager.sendQuery(sql));
    }

    // Lage øvelsegrupper og finne øvelser som er i samme gruppe


    public static List<Map<String, String>> getLikeØvelser (String øvelse_id_input){


        String sql = String.format("SELECT øvelsegrupper_id FROM øvelse_i_øvelsegruppe NATURAL JOIN øvelse WHERE øvelse_id = '%s' ", øvelse_id_input);
        List<Map<String, String>> liste = DatabaseManager.sendQuery(sql);

       Map<String, String> map = liste.get(0);

       String id = map.get("øvelsesgruppe_id");

        String sql2 = String.format("SELECT * FROM øvelse_i_øvelsegruppe NATURAL JOIN øvelse WHERE øvelsegruppe_id = '%s'", id);

        return(DatabaseManager.sendQuery(sql2));
    }





    public static void main(String[] args){
        //QueryManager qm = new QueryManager();
        //qm.addApparat("benk","kan brukst til å løfte vekter");
        //System.out.println("test");
    }

}

