
public class Processo {
    private boolean estado; 
    private int timeStamp;
    private int pri;
    private int mi;
    private int ram;
    private int io;
    private CPU cpu;


    public Processo(int timeStamp, int pri, int mi, int ram, int io){
        this.timeStamp = timeStamp;
        this.pri = pri;
        this.mi = mi;
        this.ram = ram;
        this.io = io;

    } 
    public void setPri(int pri) {
        this.pri = pri;
    }
    public void setMi(int mi) {
        this.mi = mi;
    }
    public void setIo(int io) {
        this.io = io;
    }
    public int getIo() {
        return io;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public boolean getEstado() {
        return estado;
    }
    public int getPri() {
        return pri;
    }
    public int getMi() {
        return mi;
    }

    public int getRam() {
        return ram;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void executar(CPU cpu) {
        // Se o processo não precisar de operações de I/O, define seu estado como pronto
        if (getIo() == 0) {
            setEstado(true);
        } else {
            // Se o processo precisar de operações de I/O, continua executando até que as operações de I/O sejam concluídas
            while (getIo() != 0) {
                setEstado(false);  
                setIo(getIo() - 1);  
                RelogioGlobal relogio = RelogioGlobal.getInstance();  // Obtém a instância única de RelogioGlobal
                cpu.increaseQuantum(); 
                relogio.setData_atual(relogio.getData_atual() + cpu.getQuantum());  // Atualiza o relógio global
                System.out.println("***");  // suspensão para simular a execução
                cpu.executaProcesso(getTimeStamp(), getRam(), getMi(), getEstado());  // Executa o processo na CPU
            }
            setEstado(false);  // Quando as operações de I/O forem concluídas, define o estado do processo como pronto (0)
        }
        // Se o processo estiver pronto imprime as informações sobre a execução do processo na CPU
        if (getEstado() == true) {
            System.out.println("\n\tProcesso timeStamp \t" + getTimeStamp());
            cpu.executaProcesso(getTimeStamp(), getRam(), getMi(), getEstado());
            System.out.println("\t----------------------------------\n");
            System.out.println("\t-----------------------------------------------------------\n");
        }
    }
}