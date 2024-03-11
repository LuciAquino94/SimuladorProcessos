//classe singleton
public class RelogioGlobal {
    private static RelogioGlobal instance; 
    private int data_atual;

    // Construtor privado para impedir a criação de instâncias fora da classe
    private RelogioGlobal() {
        data_atual = 0;
    }

    // Método estático para obter a instância única da classe
    public static RelogioGlobal getInstance() {
        // Se a instância ainda não foi criada, cria uma nova
        if (instance == null) {
            instance = new RelogioGlobal();
        }
        // Retorna a instância única
        return instance;
    }

    // Métodos para acessar e modificar data_atual
    public void setData_atual(int data_atual) {
        this.data_atual = data_atual;
    }

    public int getData_atual() {
        return data_atual;
    }
}
