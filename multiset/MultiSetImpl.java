import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class MultiSetImpl<E> extends MultiSetAbs<E>{

    Map<E, Integer> elements;

    public MultiSetImpl(E[] args){
        elements = new HashMap<E, Integer>();
        for (E e : Objects.requireNonNull(args, "L'argomento non può essere null")) {
            add(e);
        }
    }

    public MultiSetImpl(){
        elements = new HashMap<E, Integer>();
    }

    @Override
    public Iterator<E> iterator() {
        return Collections.unmodifiableSet(elements.keySet()).iterator();
    }

    @Override
    public int add(E e) throws NullPointerException {
        if (elements.get(Objects.requireNonNull(e, "L'argomento non può essere null")) == null){
            elements.put(e, 1);
            return 1;
        }
        elements.put(e,elements.get(e)+1);
        return elements.get(e);
    }

    @Override
    public int remove(Object o) throws NullPointerException {
        if (!contains(Objects.requireNonNull(o, "L'argomento non può essere null"))) return 0;
        int res = elements.get(o);
        elements.remove(o);
        return res;
    }

    @Override
    public int multiplicity(Object o){
        if (!contains(o)) return 0;
        return elements.get(o);
    }

    @Override
    public int size() {
        int res = 0;
        for (E e : elements.keySet()) {
            res += elements.get(e);
        }
        return res;
    }

    @Override
    public MultiSet<E> union(MultiSet<? extends E> o) {
        Objects.requireNonNull(o, "Il parametro non può essere null");
        MultiSetImpl<E> result = new MultiSetImpl<E>();
        for (Map.Entry<E, Integer> elemMult : elements.entrySet()) {
            final E elem = elemMult.getKey();
            result.elements.put(elem, Math.max(elemMult.getValue(), o.multiplicity(elem)));
        }
        for (E elem : o)
            if (!elements.containsKey(elem)) result.elements.put(elem, o.multiplicity(elem));
        return result;
        
    }

    @Override
    public MultiSet<E> intersection(MultiSet<? extends E> o) {
            Objects.requireNonNull(o, "Il parametro non può essere null");
            MultiSetImpl<E> result = new MultiSetImpl<E>();
            for (Map.Entry<E, Integer> elemMult : elements.entrySet()) {
                final E elem = elemMult.getKey();
                final int mult = Math.min(elemMult.getValue(), o.multiplicity(elem));
                if (mult > 0) result.elements.put(elem, mult);
        }
        return result;
    }

    @Override
    public Set<E> supporto() {
        return elements.keySet();
    }

    
    public static void main(String[] args) {
        MultiSetImpl<String> m = new MultiSetImpl<String>();
        m.add("tre");
        m.add("uno");
        m.add("due");
        m.add("uno");
        m.add("tre");
        m.add("tre");
        MultiSetImpl<String> l = new MultiSetImpl<String>();
        l.add("quattro");
        l.add("due");
        l.add("tre");
        l.add("tre");
        l.add("due");
        
        System.out.println(m.toString());
        System.out.println(l.toString());
        System.out.println(m.union(l).toString());
        System.out.println(m.intersection(l).toString());
    }
   
    
}
