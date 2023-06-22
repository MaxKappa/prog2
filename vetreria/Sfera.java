public class Sfera extends ContenitoreAbs{

    private final int raggio;
  
    public Sfera(int quantitàLiquido, String liquido, int raggio) {
        super(quantitàLiquido, liquido);
        if (raggio <= 0) throw new IllegalArgumentException();
        this.raggio = raggio;
    }


    @Override
    public double capienza() {
        return Math.round(raggio*raggio*raggio)*Math.PI*(4/3);
    }

    @Override
    public String toString() {
        return new StringBuilder(String.format("Sfera - raggio: %f\n ", raggio)).append(super.toString()).toString();
    }
    
}