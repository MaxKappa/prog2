import java.util.ArrayList;
import java.util.List;

public class BoolVectSparso implements BoolVect, Cloneable{

    private final List<Integer> vector;

    public BoolVectSparso(String s){
        this.vector = converti(s);
    }   

    public List<Integer> converti(String s) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i) == 'V') res.add(i);
        }
        return res;
    }


    @Override
    public int taglia() {
        return Integer.MAX_VALUE;
    }

    @Override
    public int dimensione() {
        return vector.get(vector.size()-1);
    }

    @Override
    public BoolVect set(int i, boolean value) {
        BoolVectSparso v = this.clone();
        for (Integer integer : vector) {
            if (i == integer){
                v.set(i, value);
                return v;
            }   
        }
        if(value == false) return v;
        v.vector.add(i);
        return v;
    }

    @Override
    public boolean get(int index) {
        if (vector.contains(index)) return true;
        return false;
    }

    @Override
    public BoolVect and(BoolVect vect) {
        List<Integer> l = new ArrayList<Integer>();
        for(int i = 0; i < vect.dimensione(); i++){
            if(vector.contains(i)) 
        }
    }

    @Override
    public BoolVect or(BoolVect vect) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'or'");
    }

    @Override
    public BoolVect xor(BoolVect vect) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'xor'");
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < vector.get(vector.size()-1); i++){
            s.append("F");
        }
        for (Integer integer : vector) {
            s.replace(integer, integer+1,"V");
        }
        return s.toString();
    }
    @Override
    protected BoolVectSparso clone() {
        return new BoolVectSparso(this.toString());
    }

    public static void main(String[] args) {
        
    }
}
