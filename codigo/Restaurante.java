public class Restaurante {
    private Mesa mesa;
    private Requisicao filaEspera[];
    private Cliente clientes[];

    // construtor
    public Restaurante(Mesa mesa, Requisicao[] filaEspera, Cliente[] clientes) {
        this.mesa = mesa;
        this.filaEspera = filaEspera;
        this.clientes = clientes;
    }

    // getters and setters
    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Requisicao[] getFilaEspera() {
        return filaEspera;
    }

    public void setFilaEspera(Requisicao[] filaEspera) {
        this.filaEspera = filaEspera;
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    public void setClientes(Cliente[] clientes) {
        this.clientes = clientes;
    }
}