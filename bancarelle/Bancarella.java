
import java.util.Objects;

public class Bancarella{

    private final String proprietario;
    private final Inventario inventario;
    private final Listino listino;

 
    public Bancarella(final String proprietario, final Inventario inventario){
        this.proprietario = proprietario;
        this.inventario = inventario;
        this.listino = new ListinoImpl();
    }

    public Giocattolo vendiGiocattolo(Giocattolo g){
        Objects.requireNonNull(g, "Il giocattolo non può essere null");
        inventario.remove(g);
        return g;
    }
    


}