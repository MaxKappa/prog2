public class Cilindro extends ContenitoreAbs{

    private final double raggio;
    private final double altezza;

    public Cilindro(int quantitàLiquido, String liquido, double raggio, double altezza) {
        super(quantitàLiquido, liquido);
        if(raggio <= 0 || altezza <= 0 ) throw new IllegalArgumentException();
        this.raggio = raggio;
        this.altezza = altezza;
    }

    @Override
    public double capienza() {
        return Math.PI * raggio*altezza*raggio;
    }

    @Override
    public String toString() {
        return new StringBuilder(String.format("Cilindro - altezza: %f, raggio: %f ", altezza, raggio)).append(super.toString()).toString();
    }


    
}