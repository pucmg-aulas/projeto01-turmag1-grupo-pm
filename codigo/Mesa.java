public class Mesa {
    private int capacidade;
    private boolean ocupada;

    // construtor
    public Mesa(int capacidade, boolean ocupada) {
        this.capacidade = capacidade;
        this.ocupada = ocupada;
    }

    // getters and setters
    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
}