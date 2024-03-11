import java.util.Queue;
import java.util.Scanner;
import java.util.Random;

public class kernelSimulacao {
    private CPU cpu;
    private RelogioGlobal relogio;

    public kernelSimulacao() {
        this.cpu = new CPU();
        this.relogio = RelogioGlobal.getInstance();
    }

    //agendar evento
    /*public void scheduler(Evento e){   
    }*/

    public void run(Queue<Processo> listaDeProcessos, CPU cpu) {
        // Inicializando o relógio global
        relogio.setData_atual(0);

        // Solicitar ao usuário que escolha um método de escalonamento
        System.out.println("Escolha um método de escalonamento: ");
        System.out.println("1: SJF");
        System.out.println("2: FIFO");

        Scanner scanner = new Scanner(System.in);
        int escolha = scanner.nextInt();

        // Executar a política de escalonamento com base na escolha do usuário
          switch (escolha) {
              case 1:
                  SJF fsjf = new SJF(cpu);
                  fsjf.executar(listaDeProcessos, cpu);
                  break;
              case 2:
                  FIFO  fifo = new FIFO(cpu);
                  fifo.executar(listaDeProcessos, cpu);
                  break;
              default:
                  System.out.println("Escolha inválida.");
                  break;
          }

        // Exibir estatísticas
        System.out.println();
        System.out.println("\tEstatísticas:");
        System.out.println("\t----------------------------------");
        System.out.println("\tTempo de ocupação da CPU: " + cpu.getTotalOcupado());
        System.out.println("\tTempo de ociosidade da CPU: " + cpu.getTotalOcioso());
        System.out.println("\tTempo de execução dos processos: " + cpu.getTotalExe());
        System.out.println("\t----------------------------------\n");
        System.out.println("\tTempo de execução dos processos: " + cpu.getTotalExe());


        scanner.close(); // Fechar o scanner após o uso
    }
}

