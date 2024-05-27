package laclasse.restaurante;

import java.io.Serializable;

public class ItemMenu implements Serializable {
    private String nome;
    private double preco;


    public ItemMenu(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }


    public String getNome() {
        return this.nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }


    @Override
    public String toString() {
        return this.nome + ": " + this.preco;
    }
}
