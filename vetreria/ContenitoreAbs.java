public abstract class ContenitoreAbs implements Contenitore{

    private int quantitàLiquido;
    private String liquido;

    public ContenitoreAbs(int quantitàLiquido, String liquido){
        if (capienza() <= 0 || quantitàLiquido < 0 || liquido.isEmpty()) throw new IllegalArgumentException();
        this.quantitàLiquido = quantitàLiquido;
        this.liquido = liquido;
    }
    public ContenitoreAbs(){
        this.quantitàLiquido = 0;
        this.liquido = "";
    }

    @Override
    public int quantitàLiquido() {
        return quantitàLiquido;
    }

    @Override
    public String liquido() {
        return liquido;
    }

    @Override
    public void aggiungiLiquido(int quantitàLiquido, String liquido) {
        if (this.quantitàLiquido == 0 && !this.liquido.isEmpty()){
            this.liquido = liquido;
        }
        this.quantitàLiquido = quantitàLiquido;
    }

    @Override
    public void versa(Contenitore contenitore) {
        if (!contenitore.liquido().equals(this.liquido) || this.quantitàLiquido > contenitore.capienza()) throw new IllegalArgumentException();
        contenitore.aggiungiLiquido(this.quantitàLiquido, this.liquido);
        this.quantitàLiquido = 0;
        this.liquido = "";
    }

    @Override
    public int compareTo(Contenitore o) {
        return Double.compare(quantitàLiquido, quantitàLiquido);
    }

    @Override
    public String toString() {
        return String.format(" (capienza: %f, contenuto: %f, liquido: %s)", capienza(), quantitàLiquido(), liquido());
    }

}