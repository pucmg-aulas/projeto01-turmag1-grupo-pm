package laclasse.restaurante;

import java.io.Serializable;

public class Mesa implements Serializable {
    private int numero;
    private int capacidade;
    private boolean estaOcupada;

    public Mesa(int numero, int capacidade) {
        this.numero = numero;
        this.capacidade = capacidade;
        this.estaOcupada = false;
    }

    public int getNumero() {
        return this.numero;
    }

    public int getCapacidade() {
        return this.capacidade;
    }

    public boolean estaOcupada() {
        return this.estaOcupada;
    }

    public void ocuparMesa() {
        this.estaOcupada = true;
    }

    public void desocuparMesa() {
        this.estaOcupada = false;
    }
}
