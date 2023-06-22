import java.util.Objects;

public class VettoreDenso implements Vettore {
    
    /**
     * Elementi del vettore
     */
    private final int[] elements;
   
    /**
     * Costruice un vettore denso non vuoto a partire da un array di elementi che corrispondono agli elementi del nuovo array
     * @param elements del nuovo array
     * @throws NullPointerException se l'array è nullo
     * @throws IllegalArgumentException se la lunghezza dell'array è uguale a 0
     */
    public VettoreDenso(int[] elements) {
        if (elements.length == 0) throw new IllegalArgumentException("L'array deve contenere almeno un elemento");
        this.elements = Objects.requireNonNull(elements, "L'array non può essere nullo.");
    }

    @Override
    public int dim() {
        return elements.length;
    }

    @Override
    public int val(int i) {
        if (i > elements.length || i < 0) {
            throw new ArrayIndexOutOfBoundsException("L'indice non è nel vettore");
        }
        return elements[i];
    }

    @Override
    public Vettore per(int alpha) {
        int[] res = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            res[i] = alpha*elements[i];
        }
        return new VettoreDenso(res);
    }

    @Override
    public Vettore più(Vettore v) {
        if(!isSameDim(Objects.requireNonNull(v, "Il vettore non può essere null")))
            throw new IllegalArgumentException("I vettori devono essere della stessa dimensione");
        int[] res = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            res[i] = elements[i] + v.val(i);
        }
        return new VettoreDenso(res);
    }
    public static void main(String[] args) {
        int[] temp = new int[5];
        temp[3] = 3;
        VettoreDenso v = new VettoreDenso(temp);
        temp = null;
        v.per(3);
        for (int i = 0; i < v.elements.length; i++){
            System.out.println(v.elements[i]);
        }
}

}
