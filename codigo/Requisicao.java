import java.time.LocalTime;

public class Requisicao {

    private Cliente cliente;
    private Mesa mesa;
    private LocalTime horaChegada;
    private LocalTime horaSaida;
    private int qntClientes;

    // construtor
    public Requisicao(Cliente cliente, Mesa mesa, LocalTime horaChegada,
            LocalTime horaSaida, int qntClientes) {
        this.cliente = cliente;
        this.mesa = mesa;
        this.horaChegada = horaChegada;
        this.horaSaida = horaSaida;
        this.qntClientes = qntClientes;
    }

    // getters and setters
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public LocalTime getHoraChegada() {
        return horaChegada;
    }

    public void setHoraChegada(LocalTime horaChegada) {
        this.horaChegada = horaChegada;
    }

    public LocalTime getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(LocalTime horaSaida) {
        this.horaSaida = horaSaida;
    }

    public int getQntClientes() {
        return qntClientes;
    }

    public void setQntClientes(int qntClientes) {
        this.qntClientes = qntClientes;
    }
}