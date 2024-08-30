import java.util.ArrayList;

public class Navigazione {
    private Coordinate puntoDiPartenza;
    private Coordinate puntoFinale;
    private double distanzaTotale;

    public Navigazione() {
        this.distanzaTotale = 0;
    }

    // Imposta il punto di partenza
    public void setPuntoDiPartenza(Coordinate puntoDiPartenza) {
        this.puntoDiPartenza = puntoDiPartenza;
        this.puntoFinale = puntoDiPartenza;
    }

    public void aggiungiPunto(Coordinate nuovoPunto) {
        if (puntoFinale != null) {
            distanzaTotale += calcolaDistanza(puntoFinale, nuovoPunto);
        }
        puntoFinale = nuovoPunto;
    }

    private double calcolaDistanza(Coordinate punto1, Coordinate punto2) {
        ArrayList<Double> cartesiano1 = punto1.toCoordinateCartesiane();
        ArrayList<Double> cartesiano2 = punto2.toCoordinateCartesiane();

        double deltaX = cartesiano2.get(0) - cartesiano1.get(0);
        double deltaY = cartesiano2.get(1) - cartesiano1.get(1);

        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    // Calcola la distanza rettilinea e l'angolo rispetto al Nord
    public ArrayList<Double> distanzaRettilinea(Coordinate destinazione) {
        if (puntoFinale == null) {
            ArrayList<Double> result = new ArrayList<>();
            result.add(0.0); // Distanza
            result.add(0.0); // Angolo
            return result;
        }

        ArrayList<Double> cartesianoCorrente = puntoFinale.toCoordinateCartesiane();
        ArrayList<Double> cartesianoDestinazione = destinazione.toCoordinateCartesiane();

        double deltaX = cartesianoDestinazione.get(0) - cartesianoCorrente.get(0);
        double deltaY = cartesianoDestinazione.get(1) - cartesianoCorrente.get(1);

        double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        double angle = Math.toDegrees(Math.atan2(deltaY, deltaX));

        ArrayList<Double> result = new ArrayList<>();
        result.add(distance);
        result.add(angle);

        return result;
    }

    public double getDistanzaTotale() {
        return distanzaTotale;
    }
}
