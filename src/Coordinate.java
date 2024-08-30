import java.util.ArrayList;

public class Coordinate {
    private double latitudine; // in gradi decimali
    private double longitudine; // in gradi decimali

    public Coordinate(double latitudine, double longitudine) {
        this.latitudine = latitudine;
        this.longitudine = longitudine;
    }

    public double getLatitudine() {
        return latitudine;
    }

    public double getLongitudine() {
        return longitudine;
    }

    // Converte gradi, minuti e secondi in gradi decimali
    public static double toDecimalDegrees(int gradi, int minuti, int secondi) {
        return gradi + (minuti / 60.0) + (secondi / 3600.0);
    }

    // Converte le coordinate geografiche in coordinate cartesiane (Nord/Est)
    public ArrayList<Double> toCoordinateCartesiane() {
        double x;
        double y;

        double raggioTerra = 6371000; // Raggio della Terra in metri
        x = raggioTerra * Math.toRadians(longitudine) * Math.cos(Math.toRadians(latitudine));
        y = raggioTerra * Math.toRadians(latitudine);

        ArrayList<Double> coordinateCartesiane = new ArrayList<>();
        coordinateCartesiane.add(x);
        coordinateCartesiane.add(y);

        return coordinateCartesiane;
    }
}
