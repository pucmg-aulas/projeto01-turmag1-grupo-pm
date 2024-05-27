package laclasse.restaurante;

import java.io.Serializable;

public class Cliente implements Serializable {
    private String rg;
    private String nome;
    private String contato;

    public Cliente(String rgCliente) {

    }


    public Requisicao fazerRequisicao(int quantidadeClientes) {
        return new Requisicao(this, quantidadeClientes);
    }


    public String getRG() {
        return this.rg;
    }


    public String getNome() {
        return this.nome;
    }


    public String getContato() {
        return this.contato;
    }
}
