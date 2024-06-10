package laclasse.restaurante;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Restaurante implements RestauranteInterface, Serializable {
    private List<Mesa> mesas;
    private Queue<Requisicao> filaEspera;
    private List<Cliente> clientes;
    private Cardapio cardapio;

    public Restaurante() {
        this.mesas = new ArrayList<>();
        this.filaEspera = new LinkedList<>();
        this.clientes = new ArrayList<>();
        this.cardapio = new Cardapio();

        // Initialize mesas
        for (int i = 0; i < 4; i++) {
            mesas.add(new Mesa(i + 1, 4));
        }
        for (int i = 0; i < 4; i++) {
            mesas.add(new Mesa(i + 5, 6));
        }
        for (int i = 0; i < 2; i++) {
            mesas.add(new Mesa(i + 9, 8));
        }

        // Initialize cardapio
        cardapio.adicionarPrato(new ItemMenu("Moqueca de Tilápia", 30.0));
        cardapio.adicionarPrato(new ItemMenu("Falafel Assado", 25.0));
        cardapio.adicionarPrato(new ItemMenu("Salada Primavera com Macarrão Konjac", 20.0));
        cardapio.adicionarPrato(new ItemMenu("Escondidinho de Frango", 28.0));
        cardapio.adicionarPrato(new ItemMenu("Strogonoff", 27.0));
        cardapio.adicionarPrato(new ItemMenu("Caçarola de carne com legumes", 32.0));
        cardapio.adicionarBebida(new ItemMenu("Água", 5.0));
        cardapio.adicionarBebida(new ItemMenu("Suco", 8.0));
        cardapio.adicionarBebida(new ItemMenu("Refrigerante", 7.0));
        cardapio.adicionarBebida(new ItemMenu("Cerveja", 10.0));
        cardapio.adicionarBebida(new ItemMenu("Taça de vinho", 15.0));
    }

    @Override
    public boolean verificarDisponibilidade(int quantidadeClientes) {
        for (Mesa mesa : mesas) {
            if (!mesa.estaOcupada() && mesa.getCapacidade() >= quantidadeClientes) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void alocarMesa(Requisicao requisicao) {
        for (Mesa mesa : mesas) {
            if (!mesa.estaOcupada() && mesa.getCapacidade() >= requisicao.getQuantidadeCliente()) {
                mesa.ocuparMesa();
                requisicao.setMesa(mesa);
                clientes.add(requisicao.getCliente());
                return;
            }
        }
        filaEspera.add(requisicao);
        clientes.add(requisicao.getCliente());
    }

    @Override
    public void liberarMesa(Requisicao requisicao) {
        Mesa mesa = requisicao.getMesa();
        if (mesa != null) {
            requisicao.liberarMesa();
        }
        if (!filaEspera.isEmpty()) {
            alocarMesa(filaEspera.poll());
        }
    }

    @Override
    public void adicionarMesa(Mesa mesa) {
        mesas.add(mesa);
    }

    @Override
    public void adicionarFilaEspera(Requisicao requisicao) {
        filaEspera.add(requisicao);
    }

    @Override
    public void removerCliente(Cliente cliente) {
        clientes.remove(cliente);
        filaEspera.removeIf(requisicao -> requisicao.getCliente().equals(cliente));
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    public Queue<Requisicao> getFilaEspera() {
        return filaEspera;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public Cardapio getCardapio() {
        return cardapio;
    }
}
