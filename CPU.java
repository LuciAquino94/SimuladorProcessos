public class CPU {
    private int velocidade;
    private int memoria;
    private int estadoAtual; 
    private int tempoOcioso;
    private int tempoOcupado;
    private int quantum;
    private int totalExe;
    private int totalOcioso;
    private int totalOcupado;

  //  private static final int DEFAULT_VALUE = 0;

    public CPU() {
        this.velocidade = 0;
        this.memoria = 0;
        this.estadoAtual = 0;
        this.tempoOcioso = 0;
        this.tempoOcupado = 0;
        this.totalExe = 0;
        this.totalOcioso = 0;
        this.totalOcupado = 0;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    public int getMemoria() {
        return memoria;
    }

    public int getEstadoAtual() {
        return estadoAtual;
    }

    public void setEstadoAtual(int estadoAtual) {
        this.estadoAtual = estadoAtual;
    }

    public int getTempoOcioso() {
        return tempoOcioso;
    }

    public int getTempoOcupado() {
        return tempoOcupado;
    }

    public void setTempoOcioso(int tempoOcioso) {
        this.tempoOcioso = tempoOcioso;
    }

    public void setTempoOcupado(int tempoOcupado) {
        this.tempoOcupado = tempoOcupado;
    }

    public void setQuantum(int quantum) {
        this.quantum = quantum;
    }

    public void increaseQuantum() {
        this.quantum++;
    }

    public int getQuantum() {
        return quantum;
    }

    public int getTotalExe() {
        return totalExe;
    }

    public void setTotalExe(int totalE) {
        this.totalExe = totalE;
    }

    public int getTotalOcioso() {
        return totalOcioso;
    }

    public void setTotalOcioso(int totalOcioso) {
        this.totalOcioso = totalOcioso;
    }

    public int getTotalOcupado() {
        return totalOcupado;
    }

    public void setTotalOcupado(int totalOcupado) {
        this.totalOcupado = totalOcupado;
    }

    public void executaProcesso(int timeStamp, int ram, int mi, boolean estadoProcesso) {
        int tempoExe;
        if (estadoProcesso == true) { // Processo em execução
           RelogioGlobal relogio = RelogioGlobal.getInstance();
            tempoExe = (mi / velocidade); // Tempo de execução do processo
            tempoExe += tempoOcioso; // Adiciona o tempo ocioso
            relogio.setData_atual(timeStamp + tempoExe); // Atualiza o relógio global
            setTempoOcupado(tempoExe);
            System.out.println("\tProcesso finalizado.");
            System.out.println("\tTempo de Ocupação da CPU: " + getTempoOcupado());

            totalExe += getTempoOcupado();
            totalOcupado += getTempoOcupado();
            
        } else { // Processo não realizado
            setTempoOcioso(timeStamp + getQuantum());
            System.out.println("\tProcesso não realizado.");
            System.out.println("\tTempo ocioso da CPU: " + getTempoOcioso());

            totalOcioso += getTempoOcioso();
        }
    }
}
