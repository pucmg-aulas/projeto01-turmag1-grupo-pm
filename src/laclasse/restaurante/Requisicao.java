package laclasse.restaurante;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

public class Requisicao implements Serializable {
    private Cliente cliente;
    private Mesa mesa;
    private LocalDateTime horaChegada;
    private LocalDateTime horaSaida;
    private int quantidadeCliente;

    public Requisicao(Cliente cliente, int quantidadeCliente) {
        this.cliente = cliente;
        this.quantidadeCliente = quantidadeCliente;
        this.horaChegada = LocalDateTime.now();
    }

    public Duration calcularTempo() {
        if (this.horaSaida == null) {
            this.horaSaida = LocalDateTime.now();
        }
        return Duration.between(this.horaChegada, this.horaSaida);
    }

    public void fazerPedido(Pedido pedido) {
        double totalComServico = pedido.calcularTotalComServico();
        double totalPorPessoa = pedido.calcularPorPessoa(this.quantidadeCliente);

        System.out.println("Valor total com serviço: " + totalComServico);
        System.out.println("Valor por pessoa: " + totalPorPessoa);
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public void liberarMesa() {
        if (this.mesa != null) {
            this.mesa.desocuparMesa();
            this.mesa = null;
        }
    }

    public int getQuantidadeCliente() {
        return this.quantidadeCliente;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public LocalDateTime getHoraChegada() {
        return this.horaChegada;
    }

    public LocalDateTime getHoraSaida() {
        return this.horaSaida;
    }

    public void setHoraSaida(LocalDateTime horaSaida) {
        this.horaSaida = horaSaida;
    }

    public Mesa getMesa() {
        return this.mesa;
    }
}
