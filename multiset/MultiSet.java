import java.util.Iterator;
import java.util.Set;

interface MultiSet<E> extends Iterable<E> {
    
    /**
     * Metodo che aggiunge l'elemento generico e al multiset e restituisce la sua molteplicità {@code dopo} l'inserimento,
     * se e è null solleva un'eccezione
     * @param e da aggiungere al multiset
     * @return la sua moltiplicità dopo l'inserimento
     * @throws NullPointerException se e è null
     */
    int add(E e) throws NullPointerException;

    /**
     * Metodo che rimuove l'elemento generico e dal multiset e restituisce la molteplicità dell'elemento
     * {@code prima} della sua rimozione se presente, altrimenti restituisce 0 e non fa nulla
     * @param o da rimuovere dal multiset
     * @return la sua molteplicità prima della rimozione, 0 se l'elemento non è presente
     * @throws NullPointerException se o è null
     */
    int remove(Object o) throws NullPointerException;
    

    /**
     * Metodo che restiuisce true se l'elemento appartiene al multiset, false altrimenti
     * @param o l'elemento
     * @return true se o appartiene al multiset, false altrimenti
     */
    default boolean contains(Object o){
        Iterator<E> it = iterator();
        while(it.hasNext()){
            if (it.next().equals(o)) return true;
        }
        return false;
    }
    /**
     * Metodo che restituisce la molteplicità di un elemento preso come parametro se presente
     * altrimenti restituisce 0 
     * @param o elemento di cui si vuole conoscere la molteplicità
     * @return la molteplicità di o se presente, 0 altrimenti
     * @throws NullPointerException se o è null
     */
    int multiplicity(Object o) throws NullPointerException;

    /**
     * Metodo che restituisce la cardinalità del multiset
     * @return la cardinalità
     */
    int size();

    /**
     * Metodo che restituisce un nuovo multiset dato dall'unione di quello corrente e un multiset 
     * preso come parametro
     * @param o multiset con cui fare l'unione
     * @return il nuovo multiset
     */
    MultiSet<E> union(MultiSet<? extends E> o);

    /**
     * Metodo che restituisce un nuovo multiset dato dall'intersezione di quello corrente e un multiset 
     * preso come parametro
     * @param o multiset con cui fare l'intersezione
     * @return il nuovo multiset
     */
    MultiSet<E> intersection(MultiSet<? extends E> o);

    /**
     * Restituisce il supporto del multiset, cioè un insieme senza ripetizioni di tutti gli elementi
     * @return il supporto
     */
    Set<E> supporto();

  }