import java.util.Objects;

/**
 * Classe che implementa una durata temporale
 */
public class Durata implements Comparable<Durata>, Cloneable {

    /**
     * Tempo della durata in secondi
     */
    private final int inSecondi;

    /**
     * Costruisce una nuova durata a partire da una stringa formattata così:
     * HH:MM:GG
     * 
     * @param s durata espressa come stringa
     * @throws IllegalArgumentException se la stringa non è formattata bene o non ha
     *                                  dimensione pari a 9
     * @throws NullPointerException     se la stringa è null
     */
    public Durata(final String s) throws NullPointerException, IllegalArgumentException {
        if (Objects.requireNonNull(s, "La stringa non può essere null").length() == 0)
            throw new IllegalArgumentException("La stringa deve avere dimensione uguale a 9");
        if (s.charAt(2) != ':' || s.charAt(5) != ':' || s.charAt(8) != ':')
            throw new IllegalArgumentException("La stringa non è formattata bene");
        this.inSecondi = toInt(s);
    }

    /**
     * Costruisce una durata a partire dalla durata in secondi
     * 
     * @param inSecondi durata in secondi
     * @throws IllegalArgumentException se la durata in secondi è negativa
     */
    public Durata(final int inSecondi) throws IllegalArgumentException {
        if (inSecondi < 0)
            throw new IllegalArgumentException("La durata in secondi non può essere negativa");
        this.inSecondi = inSecondi;
    }

    /**
     * Metodo che converte una stringa durata nella durata in secondi
     * 
     * @param s stringa durata
     * @return la durata in secondi
     */
    private int toInt(final String s) {
        String[] sep = s.split(":");
        return Integer.parseInt(sep[0]) * 3600 + Integer.parseInt(sep[1]) * 60 + Integer.parseInt(sep[2]);
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", (inSecondi / 3600), (inSecondi % 3600) / 60, inSecondi % 60);
    }

    /**
     * Metodo che restituisce la somma tra this e la durata presa come parametro
     * 
     * @param d durata da sommare
     * @return una nuova durata sommando d con this
     */

    public Durata somma(Durata d) {
        return new Durata(inSecondi + d.inSecondi);
    }

    /**
     * Metodo che restituisce una sottrazione tra this e la durata presa come
     * parametro se positiva, altrimenti solleva un'eccezione
     * 
     * @param d durata da sottrarre
     * @return una nuova durata sottraendo a this d
     * @throws IllegalStateException se la sottrazione è negativa
     */
    public Durata sottrazione(Durata d) throws IllegalStateException {
        if (inSecondi - d.inSecondi < 0)
            throw new IllegalStateException("La durata non può essere negativa");
        return new Durata(inSecondi - d.inSecondi);
    }

    @Override
    public Durata clone() {
        return new Durata(inSecondi);
    }

    @Override
    public int compareTo(Durata o) {
        if (inSecondi < o.inSecondi)
            return -1;
        if (inSecondi > o.inSecondi)
            return 1;
        return 0;
    }

    public static void main(String[] args) {
        Durata d = new Durata("00:00:00");
        System.out.println(d.inSecondi);
        System.out.println(d.toString());
    }

}
