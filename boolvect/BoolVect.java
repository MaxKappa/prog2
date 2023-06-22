/**
 * Interfaccia che descrive i metodi per 
 */
public interface BoolVect{

    /**
     * Metodo che restituisce la taglia di un BoolVect, la dimensione massima che può raggiungere il vettore
     * @return la taglia
     */
    public int taglia();

    /**
     * Metodo che restituisce la dimensione di un BoolVect, 1 più la posizione più grande in 
     * cui si trova un valore di verità uguale a vero
     * @return la dimensione
     */
    public int dimensione();
    
    /**
     * Metodo che restituisce il BoolVect corrente ma l'i-esimo valore è value
     * @param i-esimo valore da cambiare
     * @param value da inserire nella posizione i
     * @return il nuovo BoolVect
     */
    public BoolVect set(int i, boolean value);
    
    /**
     * Metodo che restituisce l'elemento di posizione index del BoolVect corrente
     * @param index-esimo elemento
     * @return l'elemento di posizione index
     */
    public boolean get(int index);

    /**
     * Metodo che restituisce un BoolVect risultante dall'operazione logica AND fra this e vect
     * @param vect vettore con cui fare l'AND
     * @return il vettore risultato
     */
    public BoolVect and(BoolVect vect);

     /**
     * Metodo che restituisce un BoolVect risultante dall'operazione logica OR fra this e vect
     * @param vect vettore con cui fare l'OR
     * @return il vettore risultato
     */
    public BoolVect or(BoolVect vect);
     /**
     * Metodo che restituisce un BoolVect risultante dall'operazione logica XOR fra this e vect
     * @param vect vettore con cui fare l'XOR
     * @return il vettore risultato
     */
    public BoolVect xor(BoolVect vect);




}