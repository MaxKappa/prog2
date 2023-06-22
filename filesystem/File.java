public class File extends Entry{
    
    private final int dimensione;

    public File(String nome, int dimensione) {
        super(nome);
        if (dimensione <= 0) throw new IllegalArgumentException("Il file deve avere una dimensione positiva");
        this.dimensione = dimensione;
    }

    @Override
    public int size() {
        return dimensione;
    }

    @Override
    public boolean isDir(){
        return false;
    }

    @Override
    public String toString() {
        return this.getNome();
    }


}
