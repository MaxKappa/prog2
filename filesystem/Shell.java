import java.util.ArrayList;
import java.util.List;

public class Shell implements Filesystem{
    
    private Directory current;
    private Radice root;

    public Shell(){
        root = new Radice();
        current = root;
    }

    @Override
    public List<Entry> ls(Path path) {
        List<Entry> res = new ArrayList<Entry>();
        if(!path.getLastEntry().isDir()) return res;
        Directory d = (Directory) path.getLastEntry();
        for (Entry entry : d) {
            res.add(entry);
        }
        return res;
    }

    @Override
    public void mkdir(Path path) {
        if(!path.getLBOEntry().isDir()); //path invalido
        Directory curr = (Directory) path.getLBOEntry();
        curr.aggiungiEntry(new Directory(path.getLastEntry().getNome()));
    }

    /**
     * Cambia la directory corrente in quella definita dal path
     * 
     * @param path della nuova current directory
     */
    public void cd(Path path){
        if (!path.getLastEntry().isDir()); //non valido
        current = (Directory) path.getLastEntry();
    }

    public String pwd(){
        return current.toString();
    }

    @Override
    public void touch(Path path, int dimensione) {
        if(!path.getLBOEntry().isDir()); //path invalido
        Directory curr = (Directory) path.getLBOEntry();
        curr.aggiungiEntry(new File(path.getLastEntry().getNome(), dimensione));
    }

    @Override
    public int size(Path path) {
        if(path.getLastEntry().isDir()){
            Directory d = (Directory) path.getLastEntry();
            return d.size();
        } 
        File f = (File) path.getLastEntry();
        return f.size();
    }



    public static void main(String[] args) {
        Shell s = new Shell();
        
    }



}