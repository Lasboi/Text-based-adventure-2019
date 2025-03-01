import Skabninger.Andras;
import Skabninger.Katten_Otto;
import Skabninger.SkabningsListe;
import Skabninger.SkabningsPrototype;
import Skabninger.Tommy;

import java.util.Scanner;

/**
 * Developed by András Ács (acsandras@gmail.com)
 * Zealand / www.zealand.dk
 * Licensed under the MIT License
 * 06/10/2019
 */

public class Spil {

    public static void main(String[] args) {

        // Fra http://patorjk.com/software/taag/#p=display&f=Doom&t=Det%20fede%20spil
        System.out.println("\n" +
                "______     _      __         _                  _ _ \n" +
                "|  _  \\   | |    / _|       | |                (_) |\n" +
                "| | | |___| |_  | |_ ___  __| | ___   ___ _ __  _| |\n" +
                "| | | / _ \\ __| |  _/ _ \\/ _` |/ _ \\ / __| '_ \\| | |\n" +
                "| |/ /  __/ |_  | ||  __/ (_| |  __/ \\__ \\ |_) | | |\n" +
                "|___/ \\___|\\__| |_| \\___|\\__,_|\\___| |___/ .__/|_|_|\n" +
                "                                         | |        \n" +
                "                                         |_|        \n");

        start();

}

    static void start() {

        // TODO Her skal alle nye skabninger tilføjes!
        Andras andras = new Andras();
        Tommy tommy = new Tommy();
        Katten_Otto katten_otto = new Katten_Otto();

        // Her kører spillets loop
        Scanner scanner = new Scanner(System.in);
        String kommando = "";
        while(true) {
            System.out.println("Hvem vil du snakke med? (alternativt --> slut) ");
            System.out.println(SkabningsListe.listSkabninger());
            kommando = scanner.next();

            // Hvis brugeren skriver slut, så stopper spillet
            if (kommando.equalsIgnoreCase("Slut")) {
                System.out.println("Farvel, din skønne eventyrer!"); break;
            }

            // Hvis brugeren skriver et tal, så kan han snakke med den skabning fra listen
            int tal = Integer.valueOf(kommando);
            SkabningsPrototype samtalePartner;
            if (tal>=0) {
                // Henter skabning fra skabningslisten
                samtalePartner = SkabningsListe.hentSkabning(tal);
                while (true) {
                    System.out.println("Du kan snakke om " + samtalePartner.kanSnakkeOmEmner() + " eller skrive intet for at komme videre. Hvad vil du spørge om?");
                    kommando = scanner.next();
                    if (kommando.equalsIgnoreCase("Intet") ||  kommando.equals("")) {
                        System.out.println("I snakker ikke mere denne gang.");
                        break;
                    } else {
                        String svar = samtalePartner.sigeNogetOm(kommando);
                        if (svar == null) {
                            System.out.println("Jeg kan ikke sige noget om " + kommando  + "!");
                        } else {
                            System.out.println(svar);
                        }
                    }
                }
            }
        }
    }
}
