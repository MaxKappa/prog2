public class Giocattolo{

    private final String nome;

    private final String materiale;

    private final int prezzo;
    
    public Giocattolo(final String nome, final String materiale, final int prezzo){
        this.nome = nome;
        this.materiale = materiale;
        this.prezzo = prezzo;
    }

    public int getPrezzo(){
        return prezzo;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((materiale == null) ? 0 : materiale.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Giocattolo other = (Giocattolo) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (materiale == null) {
            if (other.materiale != null)
                return false;
        } else if (!materiale.equals(other.materiale))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return String.format("%s di %s, prezzo: %f", nome, materiale, prezzo);
    }
    

    

    


}