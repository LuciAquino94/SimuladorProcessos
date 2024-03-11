import java.util.Queue;
public class FIFO extends Escalonamento <Processo> {

        private int tempoDeExe;

        public FIFO() {
            super(new CPU());

        }
        public FIFO(CPU cpu){
            super(cpu);
        }


        @Override
        public void selecionarCPU(CPU cpu){
            cpu.setEstadoAtual(0); //colocando a cpu em uso
        }

        @Override
        public void executar(Queue<Processo> listaDeProcessos, CPU cpu){
            selecionarCPU(cpu);

            while(!listaDeProcessos.isEmpty()){
                Processo processoAtual = listaDeProcessos.poll();
                processoAtual.executar(cpu);

            }
            cpu.setEstadoAtual(1); //cpu livre
        }


    }