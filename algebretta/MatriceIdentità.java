import java.util.Objects;

/**
 * OVERVIEW: La classe implementa una matrice identità quadrata a coefficienti interi, dove tutti 
 * gli elementi che non si trovano nella diagonale principale (da (0,0) a (len(m)-1, len(m)-1)) sono uguali 
 * a 0, mentre tutti gli elementi che si trovano nella diagonale principale sono uguali a 1. Immutabile
 * 
 * 
 * RI: dimensione non nulla e positiva.
 */

public class MatriceIdentità implements Matrice {
    
    /**
     * Dimensione della matrice
     */
    private final int dimensione;


    /**
     * Costruisce una nuova matrice identità di dimensione length
     * @param length della nuova matrice
     */
    public MatriceIdentità(final int length){
        if (length <= 0) throw new IllegalArgumentException("La dimensione della matrice deve essere maggiore di 0");
        dimensione = length;
    }


    @Override
    public Matrice perScalare(int alpha) {
        if (alpha == 0){
            return new MatriceNulla(dimensione);
        }
        int[] res = new int[dimensione];
        for (int i = 0; i < dimensione; i++){
            res[i] = alpha;
        }
        return new MatriceDiagonali(res);
    }

    @Override
    public Matrice più(Matrice m) {
        if(!isSameDim(Objects.requireNonNull(m, "La matrice non può essere null")))
            throw new IllegalArgumentException("Le matrici devono essere della stessa dimensione");
        int[] res = new int[dimensione];
        for (int i = 0; i < dimensione; i++){
            res[i] = m.val(i, i) + 1;
        }
        return new MatriceDiagonali(res);
    }

    @Override
    public Matrice per(Matrice m) {
        if(!isSameDim(Objects.requireNonNull(m, "La matrice non può essere null")))
            throw new IllegalArgumentException("Le matrici devono essere della stessa dimensione");
        int[] res = new int[dimensione];
        for (int i = 0; i < dimensione; i++){
            res[i] = m.val(i, i);
        }
        return new MatriceDiagonali(res);
        
    }

    @Override
    public int val(int i, int j) {
        if (i < 0 || i > dimensione || j < 0 || j < dimensione){
            throw new ArrayIndexOutOfBoundsException("i o j non sono indici della matrice");
        }
        if (i == j) return 1;
        return 0;

    }

    @Override
    public int dim() {
        return dimensione;
    }

}
