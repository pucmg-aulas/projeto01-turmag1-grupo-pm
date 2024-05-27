package laclasse.restaurante;

import java.util.ArrayList;
import java.util.List;

public class Pedido implements PedidoInterface {
    private List<ItemMenu> pratos;
    private List<ItemMenu> bebidas;


    public Pedido() {
        this.pratos = new ArrayList<>();
        this.bebidas = new ArrayList<>();
    }


    @Override
    public void adicionarPrato(ItemMenu prato) {
        this.pratos.add(prato);
    }


    @Override
    public void removerPrato(ItemMenu prato) {
        this.pratos.remove(prato);
    }


    @Override
    public void adicionarBebida(ItemMenu bebida) {
        this.bebidas.add(bebida);
    }

    @Override
    public void removerBebida(ItemMenu bebida) {
        this.bebidas.remove(bebida);
    }


    @Override
    public double calcularTotal() {
        double total = 0;
        for (ItemMenu prato : pratos) {
            total += prato.getPreco();
        }
        for (ItemMenu bebida : bebidas) {
            total += bebida.getPreco();
        }
        return total;
    }


    @Override
    public double calcularTotalComServico() {
        return this.calcularTotal() * 1.10;
    }


    @Override
    public double calcularPorPessoa(int numeroDePessoas) {
        return this.calcularTotalComServico() / numeroDePessoas;
    }
}
