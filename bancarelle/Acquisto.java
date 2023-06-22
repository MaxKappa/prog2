import java.util.HashMap;
import java.util.Set;

public class Acquisto{

    private final Giocattolo giocattolo;
    private final int quantità;
    private final int prezzo;
    private final HashMap<Bancarella, Integer> bancarelle;

    public Acquisto(final Giocattolo giocattolo, final int quantità, final int prezzo){
        this.giocattolo = giocattolo;
        this.quantità = quantità;
        this.prezzo = prezzo;
        this.bancarelle = new HashMap<>();
    }


}