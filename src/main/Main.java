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
                case "ny treningsokt":
                    ConsoleManager.makeTreningsøkt();
                    break;
                case "ny ovelse":
                    ConsoleManager.makeØvelse();
                    break;
                case "nytt apparat":
                    ConsoleManager.makeApparat();
                    break;
                case "ovelse i okt":
                    ConsoleManager.makeØvelseIØkt();
                    break;
                case "hent siste okter":
                    ConsoleManager.getNSisteTreningsøkter();
                    break;
                case "vis resultater":
                    ConsoleManager.getResultat();
                    break;
                case "vis liknende":
                	ConsoleManager.getLike();
                	break;
                case "ny ovelsesgruppe":
                	ConsoleManager.makeØvelsesGruppe();
                	break;
                case "legg ovelse i gruppe":
                	ConsoleManager.makeØvelseIØvelsesGruppe();
                	break;
                case "se valgmuligheter": case "hjelp":
                    System.out.println("Mulige kommandoer:\n" +
                            "'slutt da'/'slutt' : Avslutter programmet \n" +
                            "'ny treningsokt' : Legg inn ny treningsøkt\n" +
                            "'ny ovelse' : Legg inn ny øvelse\n" +
                            "'nytt apparat' : Legg til nytt apparat\n" +
                            "'ovelse i okt' : Legg til øvelse i treningsøkt\n" +
                            "'hent siste økter' : Vis siste n treningsøkter\n" +
                            "'vis resultater' : Vis resultater i gitt intervall\n" +
                            "'vis liknende ovelser' : Vis øvelser som likner på gitt øvelse\n" +
                            "'ny ovelsesgruppe' : Lag ny øvelsesgruppe\n" +
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
