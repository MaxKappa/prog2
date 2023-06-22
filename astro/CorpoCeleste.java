import java.util.Objects;


/**
 * OVERVIEW: La classe astratta modella l'entità corpo celeste, caratterizzato da un nome (immutabile)
 * e da una posizione (mutabile).
 */


public abstract class CorpoCeleste {

    private final String nome;

    //Costruttori
    /**
     * Costruisce un corpo celeste assegnando un nome preso come parametro
     * @param nome da assegnare al corpo celeste
     * @throws NullPointerException se il nome è null
     */
    public CorpoCeleste(String nome) {
        this.nome = Objects.requireNonNull(nome, "Il nome non può essere null");
    }

    //Metodi
    /**
     * Metodo pubblico astratto che ritorna la posizione del corpo celeste
     * 
     * @return la posizione del corpo celeste
     */
    public abstract Punto posizione();

    /**
     * Metodo pubblico astratto che ritorna la velocità del corpo celeste
     * 
     * @return la posizione del corpo celeste
     */
    public abstract Punto velocità();

     /**
     * Metodo pubblico che modifica la velocità del pianeta in funzione di un corpo celeste nelle vicinanze 
     * @param c corpo celeste nelle vicinanze
     * @throws NullPointerException se il corpo celeste è null
     */
    public abstract void modificaVelocità(CorpoCeleste c);
    
    /**
     * Metodo pubblico che modifica la posizione in funzione di un corpo celeste nelle vicinanze
     * @param c corpo celeste nelle vicinanze
     */
    public abstract void modificaPosizione();

    /**
     * Metodo pubblico che calcola e ritorna l'energia del corpo celeste, moltiplicando la
     * norma della posizione per la norma della velocità
     * 
     * @return l'energia del corpo celeste
     */
    public long energia() {
        return posizione().norma() * velocità().norma();
    }

    /**
     * Metodo pubblico che ritorna il nome del corpo celeste
     * 
     * @return nome del corpo celeste
     */
    public String getNome() {
        return nome;
    }

    public boolean RepOk(){
        return nome != null 
        && posizione() != null
        && velocità() != null;
    }

}
