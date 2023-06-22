public interface Contenitore extends Comparable<Contenitore>{

    public void versa(Contenitore contenitore);

    public int quantitàLiquido();
    
    public String liquido();

    public double capienza();

    public void aggiungiLiquido(int quantitàLiquido, String liquido);
}