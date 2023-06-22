import java.util.List;
import java.util.NoSuchElementException;

/**
 * Interfaccia che descrive i metodi per compiere operazioni base nel filesystem
 */

public interface Filesystem{
    /**
     * Lista il contenuto di una directory dato il suo path assoluto
     * 
     * @param path della directory
     * @return un set di entry presenti nella cartella
     * @throws NullPointerException se il path è null
     * @throws IllegalArgumentException se il path non è di una directory
     */
    public List<Entry> ls(Path path);


    /**
     * Crea una directory nuova dato il suo path assoluto
     * 
     * @param path della nuova directory
     * @throws NullPointerException se il path è null
     * @throws IllegalArgumentException se il path non è di una directory
     */
    public void mkdir(Path path); 


    /**
     * Crea un file dato il suo path assoluto e la sua dimensione
     * 
     * @param path
     * @param dimensione
     * @throws NullPointerException se il path è null
     * @throws IllegalArgumentException se la dimensione è negativa
     */
    public void touch(Path path, int dimensione);


    /**
     * Restituisce la dimensione della entry dato il suo path assoluto
     * 
     * @param path della entry
     * @return la dimensione
     * @throws NullPointerException se il path è null
     * @throws NoSuchElementException se il path non appartiene a nessuna entry
     */
    public int size(Path path);


    
    


}