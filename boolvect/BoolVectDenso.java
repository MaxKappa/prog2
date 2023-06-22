import java.util.ArrayList;
import java.util.List;

public class BoolVectDenso implements BoolVect, Cloneable {

    private List<Boolean> vector;

    public BoolVectDenso(List<Boolean> vector){
        this.vector = new ArrayList<Boolean>();
        for (Boolean boolean1 : vector) {
            this.vector.add(boolean1);
        }
    }

    public BoolVectDenso(String s){
        this.vector = converti(s);
    }

    public List<Boolean> converti(String s){
        List<Boolean> list = new ArrayList<Boolean>();
        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i) == 'V') list.add(true);
            else if (s.charAt(i) == 'F') list.add(false);
            else throw new IllegalArgumentException("La stringa deve essere composta da soli caratteri V o F"); 
        }
        return list;
    }

    @Override
    protected BoolVectDenso clone(){
        return new BoolVectDenso(vector);
    }

    @Override
    public int taglia() {
        return vector.size() + 1;
    }

    @Override
    public int dimensione() {
        for (int i = vector.size()-1; i >= 0; i--){
            if (vector.get(i)) return i+1;
        }
        return 1;
    }

    @Override
    public BoolVect set(int i, boolean value) {
        if(i >= vector.size() || i < 0) throw new IndexOutOfBoundsException("L'indice non è compreso nella dimensione del vettore");
        BoolVectDenso res = this.clone();
        res.vector.set(i, value);
        return res;
    }

    @Override
    public boolean get(int index) {
        if (index >= vector.size()) return false;
        return vector.get(index);
    }

    @Override
    public BoolVect and(BoolVect vect) {
        int dim = 0;
        if (this.taglia() > vect.taglia()) dim = vect.taglia()-1;
        else dim = this.taglia()-1;
        List<Boolean> res = new ArrayList<Boolean>();
        for(int i = 0; i < dim; i++){
            if(vector.get(i) && vect.get(i)) res.add(true);
            else res.add(false);
        }
        return new BoolVectDenso(res);
    }

    @Override
    public BoolVect or(BoolVect vect) {
        int dim = 0;
        if (this.taglia() > vect.taglia()) dim = vect.taglia()-1;
        else dim = this.taglia()-1;
        List<Boolean> res = new ArrayList<Boolean>();
        for(int i = 0; i < dim; i++){
            if(vector.get(i) || vect.get(i)) res.add(true);
            else res.add(false);
        }
        return new BoolVectDenso(res);
    }

    @Override
    public BoolVect xor(BoolVect vect) {
        int dim = 0;
        if (this.taglia() > vect.taglia()) dim = vect.taglia()-1;
        else dim = this.taglia()-1;
        List<Boolean> res = new ArrayList<Boolean>();
        for(int i = 0; i < dim; i++){
            if((vector.get(i) && !vect.get(i)) || (!vector.get(i) && vect.get(i))) res.add(true);
            else res.add(false);
        }
        return new BoolVectDenso(res);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Boolean boolean1 : vector) {
            if (boolean1) s.append("V");
            else s.append("F");
        }
        return s.toString();
    }


    public static void main(String[] args) {
        BoolVect b = new BoolVectDenso("FVFV");
        BoolVect c = new BoolVectDenso("VVFF");
        BoolVect res = b.xor(c);
        System.out.println(b.toString());
        System.out.println(b.dimensione());
        System.out.println(c.toString());
        System.out.println(res.toString());
        
    }
    
}
