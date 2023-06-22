import java.util.Objects;

/**
 * OVERVIEW: Interfaccia che descrive metodi per le operazioni su matrici
 * quadrate a valori interi.
 */

public interface Matrice {
 
    /**
     * Metodo di default che restituisce true se la dimensione della matrice è uguale 
     * a quella della matrice corrente, altrimenti restituisce false
     * @param m matrice di cui controlliamo se la dimensione è uguale a quella corrente
     * @return true se la dimensione delle due matrici è uguale, false altrimenti
     */
    default boolean isSameDim(final Matrice m){
        return m.dim() == dim();
    }

    /**
     * Metodo che restituisce una nuova matrice moltiplicando la matrice corrente
     * per lo scalare
     * alpha
     * 
     * @param alpha lo scalare da moltiplicare
     * @return la nuova matrice
     */
    public Matrice perScalare(int alpha);

    /**
     * Metodo che restituisce una nuova matrice sommando la matrice corrente e la matrice m se sono della 
     * stessa dimensione, altrimenti solleva un'eccezione
     * 
     * @param m la matrice da sommare
     * @return la somma
     * @throws NullPointerException     se m è null
     * @throws IllegalArgumentException se la matrice m ha dimensione diversa a
     *                                  quella della matrice corrente
     */
    public Matrice più(Matrice m);

    /**
     * Metodo che restituisce una nuova matrice moltiplicando la matrice corrente
     * con la matrice m se sono della stessa dimensione, altrimenti solleva un eccezione
     * 
     * @param m la matrice da moltiplicare
     * @return la nuova matrice
     * @throws NullPointerException se m è null
     * @throws IllegalArgumentException se la matrice m ha dimensione diversa a
     *                                  quella della matrice corrente
     */

    public Matrice per(Matrice m);

    /**
     * Metodo che restituisce l'elemento di posizione (i,j) nella matrice corrente
     * se presente, altrimenti solleva un'eccezione
     * 
     * @param i esima riga
     * @param j esima colonna
     * @return l'elemento
     * @throws ArrayIndexOutOfBoundsException se i o j non sono indici della matrice
     */
    public int val(int i, int j);

    /**
     * Metodo che restituisce la dimensione dell
     * @return
     */
    public int dim();
}
