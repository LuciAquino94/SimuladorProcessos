import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        System.out.println("\t----------Simulador de Processos-----------\t\n");
        //ler processo 
        Queue<Processo> listaDeProcessos = lerArquivoCSV("src/main/java/arquivo.csv");
        
        CPU cpu1 = new CPU();
        cpu1.setVelocidade(5);
        cpu1.setEstadoAtual(0);
        cpu1.setMemoria(8);
        cpu1.setQuantum(0);

        CPU cpu2 = new CPU();
        cpu2.setVelocidade(2);
        cpu2.setEstadoAtual(0);
        cpu2.setMemoria(16);
        cpu2.setQuantum(0);

        CPU cpu3 = new CPU();
        cpu3.setVelocidade(7);
        cpu3.setEstadoAtual(0);
        cpu3.setMemoria(32);
        cpu3.setQuantum(0);

        System.out.print("Escolha a CPU (1, 2, 3): ");
        Scanner scanner = new Scanner(System.in);
        int escolha = scanner.nextInt();
        
        kernelSimulacao kernel = new kernelSimulacao();

        if(escolha == 1){
              kernel.run(listaDeProcessos, cpu1);
        } else if(escolha == 2){
              kernel.run(listaDeProcessos, cpu2);
        } else if(escolha == 3){
              kernel.run(listaDeProcessos, cpu3);
        } else {
             System.out.println("Escolha inválida!");
        }
    
    }
    
     private static Queue<Processo> lerArquivoCSV(String arquivoCSV) {
            Queue<Processo> listaDeProcessos = new LinkedList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV))) {
                String linha;
                while ((linha = br.readLine()) != null) {
                    if (!linha.trim().startsWith("#")) {
                        String[] dados = linha.split(",");
                        int timestamp = Integer.parseInt(dados[0].trim());
                        int prioridade = Integer.parseInt(dados[1].trim());
                        int mi = Integer.parseInt(dados[2].trim());
                        int ram = Integer.parseInt(dados[3].trim());
                        int ioRate = Integer.parseInt(dados[4].trim());
                        listaDeProcessos.add(new Processo(timestamp, prioridade, mi, ram, ioRate));
                    }
                }
            } catch (IOException e) {
                System.err.println("Erro ao ler o arquivo CSV: " + e.getMessage());
            }
            return listaDeProcessos;
        }
    }