
/**
 * OVERVIEW: La classe punto implementa un punto tridimensionale a coordinate
 * intere
 */

public class Punto {

    public int x, y, z;

    // Costruttori
    /**
     * Costruisce un nuovo punto con coordinate x, y, z prese come parametro
     * 
     * @param x coordinata x del punto
     * @param y coordinata y del punto
     * @param z coordinata z del punto
     */
    public Punto(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Metodi
    /**
     * Somma il punto preso come parametro a quello corrente
     * 
     * @param q da sommare al punto corrente
     * @return un nuovo punto ottenuto sommando il punto corrente con q
     */
    public Punto somma(Punto q) {
        return new Punto(q.x + x, q.y + y, q.z + z);
    }

    /**
     * Sottrae il punto preso come parametro a quello corrente
     * 
     * @param q da sottrarre al punto corrente
     * @return un nuovo punto ottenuto sottraendo q al punto corrente
     */
    public Punto sottrai(Punto q) {
        return new Punto(q.x - x, q.y - y, q.z - z);
    }

    /**
     * Calcola la somma in valore assoluto delle tre coordinate del punto
     * 
     * @return la somma in valore assoluto delle tre coordinate del punto
     */
    public int norma() {
        return Math.abs(x + y + z);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}