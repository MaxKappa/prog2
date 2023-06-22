import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;



public class Inventario implements Iterable<Giocattolo>{

    private final HashMap<Giocattolo, Integer> elementi;

    public Inventario(){
        elementi = new HashMap<Giocattolo, Integer>();
    }

    public void remove(final Giocattolo g) throws NoSuchElementException,IllegalArgumentException,NullPointerException {
        if (elementi.isEmpty()) throw new NoSuchElementException("L'inventario è vuoto.");
        if (!elementi.containsKey(Objects.requireNonNull(g, "Il giocattolo non può essere null"))) throw new IllegalArgumentException("Il giocattolo da rimuovere non è presente nell'inventario");
        int numeroCorrente = elementi.get(g);
        if (numeroCorrente == 1){
            elementi.remove(g);
            return;
        } 
        elementi.put(g, numeroCorrente-1);
    }

    private int istanzePerGiocattolo(final Giocattolo g) throws NullPointerException{
        if (!elementi.containsKey(Objects.requireNonNull(g, "Il giocattolo non può essere null"))) return 0;
        return elementi.get(g);
    }

    public void insert(final Giocattolo g) throws NullPointerException{
        if(elementi.get(Objects.requireNonNull(g, "Il giocattolo non può essere null")) == null){
            elementi.put(g, 1);
            return;
        } 
        int numeroCorrente = elementi.get(g);
        elementi.put(g, numeroCorrente+1);
    }
    
    @Override
    public String toString() {
        String s = "";
        String temp = "";
        for (Giocattolo e : elementi.keySet()) {
            s += temp.format("num. %d %s\n",elementi.get(e), e.toString());
        }
        return s;
    }
    
    public List<Giocattolo> getElementi(){
        List<Giocattolo> returnvalues = new ArrayList<Giocattolo>();
        Giocattolo[] s = new Giocattolo[elementi.size()];
        elementi.keySet().toArray(s);

        for (Giocattolo giocattolo : s) {
            returnvalues.add(giocattolo);
        }

        return returnvalues;
    }

    @Override
    protected HashMap<Giocattolo,Integer> clone() throws CloneNotSupportedException {
        HashMap<Giocattolo,Integer> returnvalues = new HashMap<>();
        for (Giocattolo g : elementi.keySet()) {
            returnvalues.put(g, returnvalues.get(g) == null ? 1: returnvalues.get(g)+1);
        }
        return returnvalues;
    }

    public boolean containsKey(Giocattolo g){
        return elementi.containsKey(g);
    }

    public Iterator<Giocattolo> iterator() {
    
        return new Iterator<Giocattolo>() {
          int size = elementi.size();
          int index = 0;
    
          @Override
          public Giocattolo next() {
            if (!hasNext()) throw new NoSuchElementException("Non ci sono più elementi nell'inventario");
            Giocattolo[] s = new Giocattolo[size];
            elementi.keySet().toArray(s);
            return s[index++];   
          }
          @Override
          public boolean hasNext() {
            if (index >= elementi.size()) return false;
            return true;
          }
        };
      }

      public static void main(String[] args) {
        Inventario i = new Inventario();
        Giocattolo g = new Giocattolo("Biglia", "vetro", 10);
        Giocattolo p = new Giocattolo("Biglia", "plastica", 13);
        i.insert(g);
        i.insert(p);
        i.insert(p);
        i.remove(g);
        i.remove(p);
        System.out.println(i.toString());

    }


}