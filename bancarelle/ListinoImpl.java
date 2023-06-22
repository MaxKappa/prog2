import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ListinoImpl implements Listino {

    HashMap<Giocattolo, Integer> listino;

    public ListinoImpl(HashMap<Giocattolo, Integer> listino){
        this.listino = listino.clone();
    }

    @Override
    public int prezzoPerQuantità(final Giocattolo g, int quantità){
        if (quantità <= 0) throw new IllegalArgumentException("La quantità deve essere maggiore di 0");
        return quantità * Objects.requireNonNull(g, "Il giocattolo non può essere null").getPrezzo();
    }
    
}
