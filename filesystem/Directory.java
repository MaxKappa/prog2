import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;


public class Directory extends Entry implements Iterable<Entry> {

    private List<Entry> elements;

    public Directory(String nome) {
        super(nome);
        elements = new ArrayList<Entry>();
    }

    public void aggiungiEntry(Entry entry){
        elements.add(Objects.requireNonNull(entry, "L'entry non può essere null"));
    }

    @Override
    public int size() {
        int res = 0;
        for (Entry entry : elements) {
            res += entry.size();
        }
        return res;
    }

    @Override
    public Iterator<Entry> iterator() {
        return new Iterator<Entry>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                if (index == elements.size()-1) return false;
                return true;
            }
            @Override
            public Entry next() {
                if (!hasNext()) throw new NoSuchElementException("Non ci sono più elementi");
                return elements.get(index++);
            }       
        };
    }
    
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(getNome());
        for (Entry entry : elements) {
            s.append(entry.toString()).append("\n");
        }
        return s.toString();
    }


    @Override
    public boolean isDir() {
        return true;
    }

   

}