
public class Cliente implements ICliente {
    private String rg;
    private Pedido pedidoAtual;

    public Cliente(String rg) {
        this.rg = rg;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public void fazerPedido(Pedido pedido) {
        this.pedidoAtual = pedido;
    }

    @Override
    public Pedido getPedidoAtual() {
        return pedidoAtual;
    }

    public void setPedidoAtual(Pedido pedido) {

        throw new UnsupportedOperationException("Unimplemented method 'setPedidoAtual'");
    }
}
