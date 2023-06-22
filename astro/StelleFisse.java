
/**
 * OVERVIEW: La classe implementa l'entità stella fissa, una sottoclasse di CorpoCeleste immutabile 
 * dove la velocità è sempre uguale a 0
 */

public class StelleFisse extends CorpoCeleste {
    /**
     * Posizione e velocità della stella fissa, immutabili
     */
    private final Punto posizione, velocità;

    /**
     * Il metodo costruisce una stella fissa con velocità uguale a 0, in una posizione presa come parametro
     * @param nome della stella fissa da costruire
     * @param posizione della stella fissa da costruire
     */
    public StelleFisse(String nome, Punto posizione) {
        super(nome);
        this.velocità = new Punto(0, 0, 0);
        this.posizione = posizione;
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
    public void modificaVelocità(CorpoCeleste c) {
        assert RepOk();
        return;
    }

    @Override
    public void modificaPosizione() {
        assert RepOk();
        return;
    }

    @Override
    public String toString() {
        return "Stella fissa, nome: " + this.getNome() + ", pos: " + posizione.toString();
    }

    /**
     * RI: Sempre velocità = 0
     */
    @Override
    public boolean RepOk(){
        super.RepOk();
        return velocità.equals(new Punto(0, 0, 0));
    }


}
