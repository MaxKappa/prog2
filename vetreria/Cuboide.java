public class Cuboide extends ContenitoreAbs{

    private final double a;
    private final double b;
    private final double c;

    public Cuboide(int quantitàLiquido, String liquido, double a, double b, double c) {
        super(quantitàLiquido, liquido);
        if(a <= 0 || b <= 0 || c <= 0) throw new IllegalArgumentException();
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double capienza() {
        return a*b*c;
    }

    @Override
    public String toString() {
        return new StringBuilder(String.format("Cuboide - lati: %f, %f, %f\n ", a, b, c)).append(super.toString()).toString();
    }


}