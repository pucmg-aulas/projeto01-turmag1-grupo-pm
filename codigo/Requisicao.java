import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Queue;

public class Restaurante {
    private Queue<Cliente> filaEspera;

    public Restaurante() {
        this.filaEspera = new LinkedList<>();
    }

    public void adicionarClienteNaFila(Cliente cliente) {
        filaEspera.offer(cliente);
        System.out.println("Cliente " + cliente.getNome() + " adicionado à fila de espera.");
    }

    public Cliente proximoClienteNaFila() {
        return filaEspera.poll();
    }

    public boolean filaDeEsperaVazia() {
        return filaEspera.isEmpty();
    }
}

public class Cliente {
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}


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

    public int getQuantidadeClientes() {
        return quantidadeClientes;
    }

    public void setQuantidadeClientes(int quantidadeClientes) {
        this.quantidadeClientes = quantidadeClientes;
    }

    public boolean verificarDisponibilidade() {
        return false;
    }
}
