import java.util.Objects;

/**
 * OVERVIEW: La classe implementa una matrice diagonale quadrata a coefficienti interi, dove tutti 
 * gli elementi che non si trovano nella diagonale principale (da (0,0) a (len(m)-1, len(m)-1)) sono uguali a 0 
 */

public class MatriceDiagonali implements Matrice {

    private final int[] diagonale;

    /**
     * Costruisce una matrice diagonale a partire da un array di interi che corrispondono ai valori nella diagonale
     * della nuova matrice
     * @param diagonale array di valori che corrispondono alla diagonale della nuova matrice
     * @throws NullPointerException se diagonale è null
     */
    public MatriceDiagonali(int[] diagonale){
        this.diagonale = Objects.requireNonNull(diagonale, "La diagonale non può essere nulla");
    }

    @Override
    public Matrice perScalare(int alpha) {
        int[] res = new int[diagonale.length];
        for (int i = 0; i < diagonale.length; i++){
            res[i] = alpha*diagonale[i];
        }
        return new MatriceDiagonali(res);
    }

    @Override
    public Matrice più(Matrice m) {
        if(!isSameDim(Objects.requireNonNull(m, "La matrice non può essere null")))
            throw new IllegalArgumentException("La matrice deve essere della stessa dimensione");
        int[] res = new int[diagonale.length];
        for (int i = 0; i < diagonale.length; i++){
            res[i] = m.val(i, i) + diagonale[i];
        }
        return new MatriceDiagonali(res);
    }

    @Override
    public Matrice per(Matrice m) {
        if(!isSameDim(Objects.requireNonNull(m, "La matrice non può essere null")))
            throw new IllegalArgumentException("La matrice deve essere della stessa dimensione");
        int[] res = new int[diagonale.length];
        for (int i = 0; i < diagonale.length; i++){
            res[i] = m.val(i, i) * diagonale[i];
        }
        return new MatriceDiagonali(res);
    }

    @Override
    public int val(int i, int j) {
        if (i < 0 || i > diagonale.length || j < 0 || j < diagonale.length){
            throw new ArrayIndexOutOfBoundsException("i o j non sono indici della matrice");
        }
        if (i == j){
            return diagonale[i];
        }
        return 0;
    }

    @Override
    public int dim() {
        return diagonale.length;
    }
    
}
