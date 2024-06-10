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

    public ItemMenu getItemPorNome(String itemNome) {
    for (ItemMenu prato : this.pratos) {
        if (prato.getNome().equals(itemNome)) {
            return prato;
        }
    }
    for (ItemMenu bebida : this.bebidas) {
        if (bebida.getNome().equals(itemNome)) {
            return bebida;
        }
    }
    return null; // retorna null se o item não foi encontrado
}

    @Override
    public String toString() {
        return this.nome + ": " + this.preco;
    }
}
