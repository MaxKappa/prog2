import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Vetreria implements Iterable<Contenitore>{

    private final List<Contenitore> elements;

    public Vetreria(List<Contenitore> elements){
        this.elements = new ArrayList<Contenitore>();
        for (Contenitore contenitore : elements) {
            this.elements.add(contenitore);
        }
    }

    @Override
    public Iterator<Contenitore> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
    
    
}