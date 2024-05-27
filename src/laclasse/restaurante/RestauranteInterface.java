package laclasse.restaurante;

public interface RestauranteInterface {

    boolean verificarDisponibilidade(int quantidadeClientes);


    void alocarMesa(Requisicao requisicao);


    void liberarMesa(Requisicao requisicao);


    void adicionarMesa(Mesa mesa);


    void adicionarFilaEspera(Requisicao requisicao);


    void removerCliente(Cliente cliente);
}
