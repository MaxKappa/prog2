import java.util.Objects;

/**
 * OVERVIEW: La classe implementa una matrice nulla quadrata a coefficienti interi, 
 * dove ogni elemento della matrice è pari a 0. Immutabile
 * 
 * 
 * RI: dimensione non nulla e positiva.
 */

public class MatriceNulla implements Matrice {
    
    
    /**
     * Dimensione della matrice
     */
    private final int dimensione;
    

    /**
     * Costruisce una matrice nulla di dimensione length
     * @param length della matrice
     * @throws IllegalArgumentException se la dimensione è minore o uguale a 0
     */
    public MatriceNulla(final int length) {
        if (length <= 0) throw new IllegalArgumentException("La dimensione della matrice deve essere maggiore di 0");
        dimensione = length;
    }

    @Override
    public Matrice perScalare(int alpha) {
        return new MatriceNulla(dimensione);
    }

    @Override
    public Matrice più(Matrice m) {
        if(!isSameDim(Objects.requireNonNull(m, "La matrice non può essere null")))
            throw new IllegalArgumentException("Le matrici devono della stessa dimensione");
        return m;
    }

    @Override
    public Matrice per(Matrice m) {
        if(!isSameDim(Objects.requireNonNull(m, "La matrice non può essere null")))
            throw new IllegalArgumentException("Le matrici devono essere della stessa dimensione");
        return new MatriceNulla(dimensione);
    }

    @Override
    public int val(int i, int j) {
        if (i < 0 || i > dimensione || j < 0 || j < dimensione){
            throw new ArrayIndexOutOfBoundsException("i o j non sono indici della matrice");
        }
        return 0;
    }

    @Override
    public int dim() {
        return dimensione;
    }




}
