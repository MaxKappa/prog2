public abstract class Entry {
    
    private final String nome;

    public Entry(final String nome){
        if (nome.length() <= 0) throw new IllegalArgumentException("Il nome deve essere di almeno un carattere");
        this.nome = nome;
    }

    public abstract int size();

    public abstract boolean isDir();

    public String getNome(){
        return nome;
    }

}