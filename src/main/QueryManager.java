package main;

public class QueryManager {

    public static void addØvelse(String navn, String beskrivelse, String apparat_id){
        String sql = String.format("INSERT INTO øvelse VALUES(%s,'%s','%s','%s')", "NULL", navn, beskrivelse, apparat_id);

    }
    public static void addTreningsøkt(String dato, String tidspunkt, String varighet, String form, String prestasjon, String notat_id){
        String sql = String.format("INSERT INTO treningsøkt VALUES(%s,'%s','%s','%s','%s','%s','%s')", "NULL", dato, tidspunkt, varighet, form, prestasjon, notat_id);

    }
    public static void addNotat(String tekst){
        String sql = String.format("INSERT INTO notat VALUES(%s,'%s')", "NULL", tekst);

    }
    public static void addApparat(String navn, String beskrivelse){
        String sql = String.format("INSERT INTO øvelse VALUES(%s,'%s')", "NULL", beskrivelse);

    }
    public static void addØvelseIØkt(String treningsøkt_id, String øvelse_id, String kilo, String repitisjoner, String sett, String resultat){
        String sql = String.format("INSERT INTO øvelse VALUES('%s','%s','%s','%s','%s','%s')", treningsøkt_id, øvelse_id, kilo, repitisjoner, sett, resultat);

    }



}
