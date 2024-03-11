//classe evento
abstract class Evento {
    private RelogioGlobal relogio;
    private int timeStamp;

    // Construtor da classe Evento
    public Evento(int timeStamp) {
        this.timeStamp = timeStamp;
    }
    
    public int getTimeStamp() {
        return timeStamp;
    }

    public abstract void execute();
}