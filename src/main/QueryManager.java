package main;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryManager {

    public static void addØvelse(String navn, String beskrivelse, String apparat_id){
        String sql = String.format("INSERT INTO øvelse VALUES(%s,'%s','%s','%s')", "NULL", navn, beskrivelse, apparat_id);
        DatabaseManager.sendUpdate(sql);
    }
    public static void addTreningsøkt(String dato, String tidspunkt, String varighet, String form, String prestasjon, String notat_id){
        String sql = String.format("INSERT INTO treningsøkt VALUES(%s,'%s','%s','%s','%s','%s','%s')", "NULL", dato, tidspunkt, varighet, form, prestasjon, notat_id);
        DatabaseManager.sendUpdate(sql);
    }
    public static void addNotat(String tekst){
        String sql = String.format("INSERT INTO notat VALUES(%s,'%s')", "NULL", tekst);
        DatabaseManager.sendUpdate(sql);
    }
    public static void addApparat(String navn, String beskrivelse){
        String sql = String.format("INSERT INTO apparat VALUES(NULL,'%s', '%s')", navn, beskrivelse);
        DatabaseManager.sendUpdate(sql);
    }
    public static void addØvelseIØkt(String treningsøkt_id, String øvelse_id, String kilo, String repitisjoner, String sett, String resultat){
        String sql = String.format("INSERT INTO øvelse_i_økt VALUES('%s','%s','%s','%s','%s','%s')", treningsøkt_id, øvelse_id, kilo, repitisjoner, sett, resultat);
        DatabaseManager.sendUpdate(sql);
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


    public static void main(String[] args){
        //QueryManager qm = new QueryManager();
        //qm.addApparat("benk","kan brukst til å løfte vekter");
        //System.out.println("test");
    }

}

