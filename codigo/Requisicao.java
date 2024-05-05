import java.time.LocalTime;
import java.util.Objects;

public class Requisicao {
    private Cliente cliente;
    private Mesa mesa;
    private LocalTime horaChegada;
    private LocalTime horaSaida;
    private int quantidadeClientes;

    public Requisicao(Cliente cliente, Mesa mesa, LocalTime horaChegada, LocalTime horaSaida, int quantidadeClientes) {
        this.cliente = cliente;
        this.mesa = mesa;
        this.horaChegada = horaChegada;
        this.horaSaida = horaSaida;
        this.quantidadeClientes = quantidadeClientes;
    }


    public Requisicao() {
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mesa getMesa() {
        return this.mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public LocalTime getHoraChegada() {
        return this.horaChegada;
    }

    public void setHoraChegada(LocalTime horaChegada) {
        this.horaChegada = horaChegada;
    }

    public LocalTime getHoraSaida() {
        return this.horaSaida;
    }

    public void setHoraSaida(LocalTime horaSaida) {
        this.horaSaida = horaSaida;
    }

    public int getQuantidadeClientes() {
        return this.quantidadeClientes;
    }

    public void setQuantidadeClientes(int quantidadeClientes) {
        this.quantidadeClientes = quantidadeClientes;
    }

    public Requisicao cliente(Cliente cliente) {
        setCliente(cliente);
        return this;
    }

    public Requisicao mesa(Mesa mesa) {
        setMesa(mesa);
        return this;
    }

    public Requisicao horaChegada(LocalTime horaChegada) {
        setHoraChegada(horaChegada);
        return this;
    }

    public Requisicao horaSaida(LocalTime horaSaida) {
        setHoraSaida(horaSaida);
        return this;
    }

    public Requisicao quantidadeClientes(int quantidadeClientes) {
        setQuantidadeClientes(quantidadeClientes);
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Requisicao other = (Requisicao) obj;

        return quantidadeClientes == other.quantidadeClientes &&
               Objects.equals(cliente, other.cliente) &&
               Objects.equals(mesa, other.mesa) &&
               Objects.equals(horaChegada, other.horaChegada) &&
               Objects.equals(horaSaida, other.horaSaida);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliente, mesa, horaChegada, horaSaida, quantidadeClientes);
    }


}