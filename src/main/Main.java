package main;

public class Main {

    public static void main(String[] args) {
        //TODO: Start hva som skal vises i console
        boolean finished = false;
        while (!finished) {
            String input = ConsoleManager.getInput("Hei, hva ønsker du å gjøre?\n" +
                    "(skriv 'hjelp' for mulige kommandoer)").toLowerCase();
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
                case "nytt apparat":
                    ConsoleManager.makeApparat();
                    break;
                case "øvelse i økt":
                    ConsoleManager.makeØvelseIØkt();
                    break;
                case "hent siste økter":
                    ConsoleManager.getNSisteTreningsøkter();
                    break;
                case "vis resultater":
                    ConsoleManager.getResultat();
                    break;
                case "vis liknende":
                	ConsoleManager.getLike();
                	break;
                case "ny øvelsesgruppe":
                	ConsoleManager.makeØvelsesGruppe();
                	break;
                case "legg øvelse i gruppe":
                	ConsoleManager.makeØvelseIØvelsesGruppe();
                	break;
                case "se valgmuligheter": case "hjelp":
                    System.out.println("Mulige kommandoer:\n" +
                            "'slutt da'/'slutt' : Avslutter programmet \n" +
                            "'ny treningsøkt' : Legg inn ny treningsøkt\n" +
                            "'ny øvelse' : Legg inn ny øvelse\n" +
                            "'nytt apparat' : Legg til nytt apparat\n" +
                            "'øvelse i økt' : Legg til øvelse i treningsøkt\n" +
                            "'hent siste økter' : Vis siste n treningsøkter\n" +
                            "'vis resultater' : Vis resultater i gitt intervall\n" +
                            "'vis liknende øvelser' : Vis øvelser som likner på gitt øvelse\n" +
                            "'ny øvelsesgruppe' : Lag ny øvelsesgruppe\n" +
                            "'legg øvelse i gruppe' : Koble øvelse mot gruppe\n" +
                            "\n_____________________________________________\n");
                    break;
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
