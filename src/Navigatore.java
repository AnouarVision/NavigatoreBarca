import java.util.ArrayList;
import java.util.Scanner;

public class Navigatore {
    /*
    Si intende realizzare un programma Java che consenta di gestire la navigazione in barca.
    Il programma deve permettere all’operatore di inserire manualmente le successive posizioni
    rilevate mediante un dispositivo GPS, che restituisce latitudine e longitudine in gradi,
    primi e secondi, e di calcolare in ogni momento la distanza percorsa dall’ultimo punto
    rilevato e dal punto di partenza. Il programma deve permettere inoltre di inserire una
    destinazione espressa mediante i valori della latitudine e della longitudine e di calcolare
    la rotta (cioè l’angolo rispetto al Nord) e la lunghezza del percorso rettilineo che congiunge
    l’ultimo punto rilevato con il punto di destinazione. Viene richiesto l'interfaccia utente testuale.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Navigazione navigazione = new Navigazione();

        System.out.println("Inserire il punto di partenza:");
        navigazione.setPuntoDiPartenza(inserisciCoordinate(scanner));

        while (true) {
            System.out.println("\n1. Aggiungi nuovo punto GPS");
            System.out.println("2. Mostra distanza totale percorsa");
            System.out.println("3. Mostra distanza e rotta alla destinazione");
            System.out.println("4. Esci");

            int scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma la newline

            switch (scelta) {
                case 1:
                    System.out.println("Inserire nuova posizione GPS:");
                    navigazione.aggiungiPunto(inserisciCoordinate(scanner));
                    break;
                case 2:
                    System.out.printf("Distanza totale percorsa: %.2f metri\n", navigazione.getDistanzaTotale());
                    break;
                case 3:
                    System.out.println("Inserire la destinazione:");
                    Coordinate destinazione = inserisciCoordinate(scanner);
                    ArrayList<Double> rotta = navigazione.distanzaRettilinea(destinazione);
                    System.out.printf("Distanza alla destinazione: %.2f metri, Rotta: %.2f gradi rispetto al Nord\n", rotta.get(0), rotta.get(1));
                    break;
                case 4:
                    System.out.println("Uscita dal programma...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
    }

    private static Coordinate inserisciCoordinate(Scanner scanner) {
        System.out.print("Latitudine (gradi, minuti, secondi): ");
        int latGradi = scanner.nextInt();
        int latMinuti = scanner.nextInt();
        int latSecondi = scanner.nextInt();

        System.out.print("Longitudine (gradi, minuti, secondi): ");
        int lonGradi = scanner.nextInt();
        int lonMinuti = scanner.nextInt();
        int lonSecondi = scanner.nextInt();

        double latitudine = Coordinate.toDecimalDegrees(latGradi, latMinuti, latSecondi);
        double longitudine = Coordinate.toDecimalDegrees(lonGradi, lonMinuti, lonSecondi);

        return new Coordinate(latitudine, longitudine);
    }
}
