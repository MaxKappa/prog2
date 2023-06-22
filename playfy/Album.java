import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Classe che implementa un album di brani musicali, immutabile
 */

public class Album implements Iterable<Brano> {

    /**
     * Lista dei brani presenti nell'album
     */
    private final SortedSet<Brano> brani;

    /**
     * Nome dell'album
     */
    private final String nome;

    /**
     * Costruisce un nuovo album a partire da un elenco di brani e da un nome
     * 
     * @param brani dell'album
     * @param nome  dell'album
     * @throws NullPointerException     se la lista di brani o il nome sono null
     * @throws IllegalArgumentException se la lunghezza del nome non è maggiore di 0
     */
    public Album(final SortedSet<Brano> brani, final String nome)
            throws NullPointerException, IllegalArgumentException {
        if (nome.length() <= 0)
            throw new IllegalArgumentException("La lunghezza del nome deve essere maggiore di 0");
        this.brani = new TreeSet<Brano>();
        for (Brano brano : Objects.requireNonNull(brani, "La lista di brani non può essere null")) {
            this.brani.add(brano);
        }
        this.nome = Objects.requireNonNull(nome, "Il nome dell'album non può essere null");
    }

    /**
     * Metodo che restituisce un brano nell'album a partire da un titolo se
     * presente, altrimenti solleva un'eccezione
     * 
     * @param titolo del brano da cercare
     * @return il brano
     * @throws NoSuchElementException   se il brano cercato non è presente
     *                                  nell'album
     * @throws NullPointerException     se il titolo è null
     * @throws IllegalArgumentException se la lunghezza del titolo non è maggiore di
     *                                  0
     */
    public Brano getBranoFromTitle(String titolo)
            throws NoSuchElementException, NullPointerException, IllegalArgumentException {
        if (Objects.requireNonNull(titolo, "Il titolo non può essere null").length() <= 0)
            throw new IllegalArgumentException("La lunghezza del titolo deve essere maggiore di 0");
        for (Brano brano : brani) {
            if (titolo == brano.getTitolo())
                return brano.clone();
        }
        throw new NoSuchElementException(String.format("Il brano %s non è presente nell'album %s", titolo, nome));
    }

    /**
     * Metodo che restituisce un brano nell'album a partire da una posizione se
     * presente, altrimenti solleva un'eccezione
     * 
     * @param index del brano nell'album
     * @return il brano
     * @throws NoSuchElementException   se il brano non è presente nell'album
     * @throws IllegalArgumentException se l'indice non è positivo
     */
    public Brano getBranoFromPosition(int index) throws NoSuchElementException, IllegalArgumentException {
        if (index <= 0)
            throw new IllegalArgumentException("L'indice deve essere positivo");
        int count = 0;
        for (Brano brano : brani) {
            count++;
            if (count == index) {
                return brano.clone();
            }
        }
        throw new NoSuchElementException(
                String.format("Il brano di posizione %d non è presente nell'album %s", index, nome));
    }

    /**
     * Metodo che restituisce la posizione del brano nell'album se presente,
     * altrimenti solleva un'eccezione
     * 
     * @param brano di cui si vuole conoscere la posizione
     * @return la posizione
     * @throws NullPointerException   se brano è null
     * @throws NoSuchElementException se il brano non è presente nell'album
     */
    public int getPosition(Brano brano) throws NullPointerException, NoSuchElementException {
        int count = 0;
        for (Brano brano2 : brani) {
            count++;
            if (brano2.equals(Objects.requireNonNull(brano, "Il brano non può essere null")))
                return count;
        }
        throw new NoSuchElementException(
                String.format("Il brano %s non è presente nell'album %s", brano.getTitolo(), nome));
    }

    /**
     * Metodo che restituisce la durata complessiva dell'album
     * 
     * @return la durata complessiva
     */
    public Durata durata() {
        Durata d = new Durata(0);
        for (Brano brano : brani) {
            d.somma(brano.durata());
        }
        return d;
    }

    /**
     * Metodo che restituisce il nome dell'album
     * 
     * @return
     */
    public String getNome() {
        return nome;
    }

    @Override
    public Iterator<Brano> iterator() {
        return brani.iterator();
    }

}