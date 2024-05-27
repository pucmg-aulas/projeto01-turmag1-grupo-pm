package laclasse.restaurante;

import java.io.Serializable;

public interface PedidoInterface extends Serializable {
    void adicionarPrato(ItemMenu prato);
    void removerPrato(ItemMenu prato);
    void adicionarBebida(ItemMenu bebida);
    void removerBebida(ItemMenu bebida);
    double calcularTotal();
    double calcularTotalComServico();
    double calcularPorPessoa(int numeroDePessoas);
}
