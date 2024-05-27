

package laclasse.restaurante.test;

import laclasse.restaurante.ItemMenu;
import laclasse.restaurante.Pedido;

public class PedidoTest {
    @Test
    public void testAdicionarPrato() {
        Pedido pedido = new Pedido();
        ItemMenu prato = new ItemMenu("Strogonoff", 27.0);
        pedido.adicionarPrato(prato);
        assertEquals(27.0, pedido.calcularTotal());
    }

    @Test
    public void testAdicionarBebida() {
        Pedido pedido = new Pedido();
        ItemMenu bebida = new ItemMenu("Água", 5.0);
        pedido.adicionarBebida(bebida);
        assertEquals(5.0, pedido.calcularTotal());
    }

    @Test
    public void testCalcularTotalComServico() {
        Pedido pedido = new Pedido();
        ItemMenu prato = new ItemMenu("Strogonoff", 27.0);
        ItemMenu bebida = new ItemMenu("Água", 5.0);
        pedido.adicionarPrato(prato);
        pedido.adicionarBebida(bebida);
        assertEquals(35.2, pedido.calcularTotalComServico());
    }

    @Test
    public void testCalcularPorPessoa() {
        Pedido pedido = new Pedido();
        ItemMenu prato = new ItemMenu("Strogonoff", 27.0);
        ItemMenu bebida = new ItemMenu("Água", 5.0);
        pedido.adicionarPrato(prato);
        pedido.adicionarBebida(bebida);
        assertEquals(17.6, pedido.calcularPorPessoa(2));
  }
}
