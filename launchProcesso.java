//Noa funciona, corrigir 
import java.util.Queue;
import java.util.LinkedList;
import java.util.Queue;

class launchProcesso extends Evento {
    private RelogioGlobal relogio;
    private int timeStamp;
    private Processo processo;

    public launchProcesso(int data, Processo p) {
        super(data);
        Queue<Evento> listaEventos = new LinkedList<>();
        Evento e = new launchProcesso(data, p);
        listaEventos.add(e);
    }
    
    @Override
    public void execute() {
        //agendar evento
         System.out.println("\t---\t\n");
        
    }
}
