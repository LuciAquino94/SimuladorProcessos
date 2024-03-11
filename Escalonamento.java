import java.util.Queue;
public abstract class Escalonamento {

    private CPU cpu;
    private Queue<Processo> listaDeProcessos;

    public Escalonamento(CPU cpu) {
        this.cpu = cpu;
    }

    abstract public void executar(Queue<Processo> listaDeProcessos, CPU cpu);

    abstract public void selecionarCPU(CPU cpu);
}
