import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;



public class SistemaAstronomico implements Iterable<CorpoCeleste>{

    private List<CorpoCeleste> elements;
    private long energiaTotale;
    
    /**
     * Costruisce un sistema astronomico vuoto, con un energia totale pari a 0
     */
    public SistemaAstronomico(){
        elements = new ArrayList<>();
        energiaTotale = 0;
    }
    /**
     * Metodo per calcolare l'energia totale del sistema, scorre tutti gli elementi nella lista elements,
     * somma le loro energie e salva il risultato nella variabile energiaTotale.
     */
    private void calcolaEnergiaTotale(){
        energiaTotale = 0;
        for (CorpoCeleste corpoCeleste : elements) {
            energiaTotale += corpoCeleste.energia();
        }
    }
    /**
     * Metodo per aggiungere un corpo celeste al sistema astronomico.
     * @param c corpo celeste da aggiungere al sistema astronomico
     * @throws NullPointerException se il parametro c è null
     */
    public void aggiungiCorpoCeleste(CorpoCeleste c) throws NullPointerException{
        elements.add(Objects.requireNonNull(c, "Il corpo celeste non può essere null"));
        calcolaEnergiaTotale();
    }
    /**
     * Metodo privato che aggiorna la posizione di tutti i corpi celesti nel sistema astronomico
     */
    private void aggiornaPosizioneSistema(){
        for (CorpoCeleste corpoCeleste : elements) {
            corpoCeleste.modificaPosizione();
        }
    }
    /**
     * Metodo privato che aggiorna la velocità di tutti i corpi celesti nel sistema astronomico
     */
    private void aggiornaVelocitàSistema(){
        for (CorpoCeleste c_i : elements) {
            for (CorpoCeleste c_j : elements) {
                c_i.modificaVelocità(c_j);
            }
        }
    }
    /**
     * Metodo pubblico che ritorna un iteratore che scorre i corpi celesti in un sistema astronomico
     * 
     * @return l'iteratore
     */
    public Iterator<CorpoCeleste> iterator(){
        return new Iterator<CorpoCeleste>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                if(index == elements.size()-1) return false;
                return true;
            }

            @Override
            public CorpoCeleste next() {
                if (!hasNext()) throw new NoSuchElementException("Non ci sono più elementi");
                CorpoCeleste res = elements.get(index++);
                return res;
            }
            
        };
    }
    /**
     * Metodo privato che fa il parsing dell'input e aggiunge adeguatamente un corpo celeste al sistema astronomico
     * @param pOrS che può essere P o S, indica se aggiungere un pianeta o una stella al sistema astronomico 
     * @param posizione iniziale del corpo celeste   da aggiungere al sistema astronomico 
     * @param name del corpo celeste da aggiungere al sistema astronomico
     */
    private void parsaInput(char pOrS, Punto posizione,String name){
        if (pOrS == 'P') this.aggiungiCorpoCeleste(new Pianeta(name, posizione));
        else this.aggiungiCorpoCeleste(new StelleFisse(name, posizione));
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x = 0;
        int y = 0;
        int z = 0;
        char pOrS = 'd';
        String name = "";
        SistemaAstronomico sysAst =  new SistemaAstronomico();
        while (s.hasNext()) {
            pOrS = s.next().charAt(0); // can be P or S
            name = s.next();
            x = s.nextInt();
            y = s.nextInt();
            z = s.nextInt();
            sysAst.parsaInput(pOrS, new Punto(x, y, z), name);
        }
        s.close();
        sysAst.aggiornaVelocitàSistema();
        sysAst.aggiornaPosizioneSistema();
        for (CorpoCeleste corpoCeleste : sysAst.elements) {
            System.out.println(corpoCeleste.toString());
        }
        
        sysAst.calcolaEnergiaTotale();
        System.out.println(sysAst.energiaTotale);
    }
}
