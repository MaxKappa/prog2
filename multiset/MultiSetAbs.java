import java.util.Iterator;

/**
 * Classe astratta che implementa il metodo {@code toString()} 
 */

public abstract class MultiSetAbs<E> implements MultiSet<E>{

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Iterator<E> it = iterator();
        s.append(size()).append(" {");
        while(it.hasNext()){
            E temp = it.next();
            s.append(temp).append(": ").append(multiplicity(temp));
            if (it.hasNext()) s.append(", ");
        }
        s.append("}");
        return s.toString();
    }
    
}
