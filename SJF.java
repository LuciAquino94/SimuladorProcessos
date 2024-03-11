import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
public class SJF extends Escalonamento <Processo> {

    public SJF() {
        super(new CPU());
    }

    public SJF(CPU cpu) {
        super(cpu);
    }

    @Override
    public void selecionarCPU(CPU cpu) {
        cpu.setEstadoAtual(0); // colocando a cpu em uso
    }

    @Override
    public void executar(Queue<Processo> listaDeProcessos, CPU cpu) {
        selecionarCPU(cpu);

        // Cria uma fila de prioridade usando o tempo de execução como critério de ordenação
        PriorityQueue<Processo> filaDeProcessos = new PriorityQueue<>(Comparator.comparingInt(Processo::getTimeStamp));

        // Adiciona todos os processos à fila de prioridade
        filaDeProcessos.addAll(listaDeProcessos);

        while (!filaDeProcessos.isEmpty()) {
            Processo processoAtual = filaDeProcessos.poll(); // Retira o próximo processo da fila
            processoAtual.executar(cpu);
        }

        cpu.setEstadoAtual(1); // cpu livre
    }
}
