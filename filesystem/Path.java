import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;


public class Path implements Iterable<Entry>, Cloneable{
    
    private List<Entry> entries;
    private boolean absolute;


    public Path(){
        entries = new ArrayList<Entry>();
        absolute = false;
    }

    public void updatePath(Entry entry){
        if (absolute == true) throw new IllegalStateException("Non posso aggiungere al path la entry");
        if (!entry.toString().contains("*")) absolute = true;
        entries.add(Objects.requireNonNull(entry, "Entry non può essere null"));
    }

    @Override
    public Iterator<Entry> iterator() {
        return new Iterator<Entry>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                if (index == entries.size()-1) return false;
                return true;
            }
            @Override
            public Entry next() {
                if (!hasNext()) throw new NoSuchElementException("Non ci sono più entries");
                return entries.get(index++);
            }       
        };
    }

    public Entry getLastEntry(){
        return entries.get(entries.size()-1);
    }

    public Entry getLBOEntry(){
        return entries.get(entries.size()-2);
    }


    @Override
    public String toString() {
        String res = "";
        for (Entry entry : entries) {
            res += "/" + entry;
        }
        return res;
    }

    @Override
    public Path clone(){
        Path p = new Path();
        List<Entry> res = new ArrayList<Entry>();
        for (Entry entry : entries) {
            res.add(entry);
        }
        p.entries = res;
        p.absolute = absolute;
        return p;
    }
    public static void main(String[] args) {
        Path p = new Path();
        Entry e = new File("prova.txt", 10);
        Entry b = new Directory("cazzo");
        p.updatePath(b);
        p.updatePath(e);
        System.out.println(p.toString());
    }

}