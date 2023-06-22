import java.util.Iterator;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Classe che implementa una playlist di brani musicali, mutabile
 */
public class Playlist implements Iterable<Brano> {

    /**
     * Lista dei brani presenti nella playlist
     */
    private SortedSet<Brano> brani;

    /**
     * Nome della playlist
     */
    private final String nome;

    /**
     * Costruisce una playlist vuota assegnando un nome
     * 
     * @param nome della playlist
     * @throws IllegalArgumentException se nome ha lunghezza minore o uguale a 0
     * @throws NullPointerException     se nome è null
     */
    public Playlist(final String nome) throws IllegalArgumentException, NullPointerException {
        if (Objects.requireNonNull(nome, "Il nome non può essere null").length() <= 0)
            throw new IllegalArgumentException("La lunghezza del nome deve essere maggiore di 0");
        this.nome = nome;
        brani = new TreeSet<Brano>();
    }

    /**
     * Metodo che aggiunge un brano preso come parametro alla playlist se non è già
     * presente, altrimenti solleva un'eccezione
     * 
     * @param b brano da aggiungere alla playlist
     * @throws IllegalStateException se il brano è gia presente nella playlist
     * @throws NullPointerException  se il brano è null
     */
    public void aggiungiBrano(Brano b) throws IllegalStateException, NullPointerException {
        if (isPresent(Objects.requireNonNull(b, "Il brano non può essere null")))
            throw new IllegalStateException("Il brano è gia presente nella playlist");
        brani.add(b);
    }

    /**
     * Metodo che rimuove un brano preso come parametro dalla playlist se non è già
     * presente, altrimenti solleva un'eccezione
     * 
     * @param b brano da rimuovere dalla playlist
     * @throws NullPointerException     se il brano è null
     * @throws IllegalArgumentException se il brano non è presente nella playlist
     */

    public void rimuoviBrano(Brano b) throws NullPointerException, IllegalArgumentException {
        if (!isPresent(Objects.requireNonNull(b, "Il brano non può essere null")))
            throw new IllegalStateException("Il brano non è presente nella playlist");
        brani.remove(b);
    }

    /**
     * Metodo che restituisce true se il brano è presente nella playlist, false
     * altrimenti
     * 
     * @param b brano da cercare
     * @return true se il brano è presente nella playlist, false altrimenti
     * @throws NullPointerException se il brano è null
     */
    public boolean isPresent(Brano b) throws NullPointerException {
        return brani.contains(Objects.requireNonNull(b, "Il brano non può essere null"));
    }

    /**
     * Metodo che restituisce la durata complessiva della playlist
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
     * Metodo che restituisce un iteratore che scorre su dei brani che sono presenti
     * nella playlist e appartengono all'album preso come parametro
     * 
     * @param album di appartenenza
     * @return un iteratore che scorre i brani che appartengono all'album
     */
    public Iterator<Brano> getSongsFromAlbum(Album album) throws NullPointerException {
        SortedSet<Brano> braniAlbum = new TreeSet<Brano>();
        for (Brano b : brani) {
            if (b.getAlbumName().equals(Objects.requireNonNull(album, "L'album non può essere null").getNome()))
                braniAlbum.add(b);
        }
        return braniAlbum.iterator();
    }

    /*
     * public Iterator<Brano> getAlbums(Album album) {
     * List<Album> albums = new ArrayList<Album>();
     * for (Brano brano : brani) {
     * String titoloAlbum = brano.getAlbumName();
     * if (!albums.contains(titoloAlbum))
     * albums.add(titoloAlbum);
     * }
     * }
     */
    @Override
    public Iterator<Brano> iterator() {
        return brani.iterator();
    }

}
