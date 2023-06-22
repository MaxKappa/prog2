import java.util.Objects;

/**
 * Classe che implementa un brano musicale (immutabile)
 */
public class Brano implements Cloneable {
    /**
     * Titolo del brano
     */
    private final String titolo;
    /**
     * Durata del brano
     */
    private final Durata durata;
    /**
     * Album a cui appartiene il brano
     */
    private final Album album;

    /**
     * Costruisce un brano a partire da un titolo, una durata e un album di
     * appartenza
     * 
     * @param titolo
     * @param durata
     * @param album
     * @throws NullPointerException     se titolo o album sono null
     * @throws IllegalArgumentException se la lunghezza del titolo
     *                                  non è maggiore di 0
     */
    public Brano(final String titolo, final String durata, Album album)
            throws NullPointerException, IllegalArgumentException {
        if (Objects.requireNonNull(titolo, "Il titolo non può essere null").length() <= 0)
            throw new IllegalArgumentException("Il titolo deve avere lunghezza maggiore di 0");
        this.titolo = titolo;
        this.durata = new Durata(durata);
        this.album = Objects.requireNonNull(album, "L'album non può essere null");
    }

    /**
     * Costruisce un brano a partire da un titolo, una durata e un album a cui
     * appartiene
     * 
     * @param titolo
     * @param durata
     * @param album
     * @throws NullPointerException     se titolo, album, durata sono null
     * @throws IllegalArgumentException se la lunghezza del titolo
     *                                  non è maggiore di 0
     */
    private Brano(final String titolo, final Durata durata, Album album)
            throws NullPointerException, IllegalArgumentException {
        if (Objects.requireNonNull(titolo, "Il titolo non può essere null").length() <= 0)
            throw new IllegalArgumentException("Il titolo deve avere lunghezza maggiore di 0");
        this.titolo = titolo;
        this.durata = Objects.requireNonNull(durata, "La durata non può essere null");
        this.album = Objects.requireNonNull(album, "L'album non può essere null");
    }

    /**
     * Metodo che restituisce il titolo del brano
     * 
     * @return il titolo
     */
    public String getTitolo() {
        return titolo;
    }

    /**
     * Metodo che restituisce una copia della durata del brano
     * 
     * @return la durata del brano
     */
    public Durata durata() {
        return durata.clone();
    }

    /**
     * Metodo che restituisce il nome dell'album a cui il brano appartiene
     * 
     * @return l'album
     */
    public String getAlbumName() {
        return album.getNome();
    }

    @Override
    public Brano clone() {
        return new Brano(titolo, durata, album);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (o.getClass() != this.getClass()) {
            return false;
        }
        final Brano b = (Brano) o;
        if (b.titolo.equals(titolo)
                && b.durata.equals(durata)
                && b.album.equals(album))
            return true;
        return false;
    }

}
