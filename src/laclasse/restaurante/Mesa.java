package laclasse.restaurante;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private List<Mesa> mesas;

    public Restaurante() {
        this.mesas = new ArrayList<>();

        // Adiciona 4 mesas com capacidade para 4 pessoas
        for (int i = 0; i < 4; i++) {
            this.mesas.add(new Mesa(i + 1, 4));
        }

        // Adiciona 4 mesas com capacidade para 6 pessoas
        for (int i = 4; i < 8; i++) {
            this.mesas.add(new Mesa(i + 1, 6));
        }

        // Adiciona 2 mesas com capacidade para 8 pessoas
        for (int i = 8; i < 10; i++) {
            this.mesas.add(new Mesa(i + 1, 8));
        }
    }
    public class Mesa implements Serializable {
    // Outros campos e métodos...

    private Pedido pedido;

    public void fazerPedido() {
        this.pedido = new Pedido();
    }

    public void adicionarItemAoPedido(ItemMenu item, boolean isBebida) {
        if (isBebida) {
            this.pedido.adicionarBebida(item);
        } else {
            this.pedido.adicionarPrato(item);
        }
    }

    public double encerrarPedido() {
        double total = this.pedido.calcularTotalComServico();
        this.pedido = null; // Limpa o pedido atual
        return total;
    }
}
}
