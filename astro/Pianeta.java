import java.util.Objects;

/**
 * La classe implementa l'entità Pianeta, una sottoclasse di classe CorpoCeleste caratterizzato 
 * da posizione e velocità mutabili
 */


public class Pianeta extends CorpoCeleste {

    /**
     * Posizione del pianeta
     */
    private Punto posizione;

    /**
     * Velocità del pianeta
     */
    private Punto velocità;

    //Costruttori
    /**
     * Costruisce un nuovo pianeta assegnando nome e posizione iniziale, genera un'eccezione 
     * se uno dei due parametri è null
     * @param nome del nuovo pianeta
     * @param posizione iniziale del nuovo pianeta
     * @throws NullPointerException se la velocità o la posizione sono null
     */
    public Pianeta(String nome, Punto posizione) {
        super(nome);
        this.velocità = new Punto(0, 0, 0);
        this.posizione = Objects.requireNonNull(posizione, "La posizione non può essere null");
    }

   @Override
    public void modificaVelocità(CorpoCeleste c) throws NullPointerException{
       
        Objects.requireNonNull(c,"Il corpo celeste non può essere null");
        
        if (posizione.x > c.posizione().x) velocità.x--;
        else if (posizione.x < c.posizione().x) velocità.x++;

        if (posizione.y > c.posizione().y) velocità.y--;
        else if (posizione.y < c.posizione().y) velocità.y++;

        if (posizione.z > c.posizione().z) velocità.z--;
        else if (posizione.z < c.posizione().z) velocità.z++;
        
        assert RepOk();

    }

    @Override
    public void modificaPosizione(){
        posizione = posizione.somma(velocità);
        assert RepOk();
    }

    @Override
    public Punto posizione() {
        return posizione;
    }

    @Override
    public Punto velocità() {
        return velocità;
    }

    @Override
    public String toString() {
        return "Pianeta, nome: " + this.getNome() + ", pos: " + posizione.toString() + ", vel: " + velocità.toString();
    }

}
