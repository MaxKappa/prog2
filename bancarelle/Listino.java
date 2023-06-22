import java.util.List;

public interface Listino{

    public int prezzoPerQuantità(final Giocattolo g, int quantità);

    default public int prezzoUnitario(final Giocattolo g){
        return g.getPrezzo();
    }

}