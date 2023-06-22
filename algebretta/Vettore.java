import java.util.Objects;

/**
 * OVERVIEW: Interfaccia che descrive i metodi per la gestione di un vettore di
 * interi
 */

public interface Vettore {

    /**
     * Metodo di default che restituisce true se la dimensione del vettore è uguale 
     * a quella del vettore corrente, altrimenti restituisce false
     * @param v vettore di cui controlliamo se la dimensione è uguale a quella corrente
     * @return true se la dimensione dei due vettori è uguale, false altrimenti
     */
    default boolean isSameDim(final Vettore v){
        return v.dim() == dim();
    }

    /**
     * Metodo che restituisce la dimensione del vettore
     * 
     * @return la dimensione
     */
    public int dim();

    /**
     * Metodo che restituisce il valore dell'i-esimo elemento del vettore
     * 
     * @param i indice posizione
     * @return i-esimo elemento
     * @throws ArrayIndexOutOfBoundsException se i non è indice del vettore
     */
    public int val(final int i);

    /**
     * Metodo che restituisce un nuovo vettore moltiplicando il vettore corrente per
     * lo scalare alpha
     * 
     * @param alpha lo scalare da moltiplicare
     * @return il nuovo vettore
     */
    public Vettore per(final int alpha);

    /**
     * Metodo che restituisce un nuovo vettore sommando il vettore
     * corrente e il vettore v
     * 
     * @param v il vettore da sommare
     * @return il nuovo vettore
     * @throws NullPointerException     se v è null
     * @throws IllegalArgumentException se v non è della stessa dimensione del
     *                                  vettore corrente
     */
    public Vettore più(final Vettore v);

}