public class Cliente {

    private String rg;
    private int qntClientes;

    // construtor
    public Cliente(String rg, int qntClientes) {
        this.rg = rg;
        this.qntClientes = qntClientes;
    }

    // getters and setters
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public int getQntClientes() {
        return qntClientes;
    }

    public void setQntClientes(int qntClientes) {
        this.qntClientes = qntClientes;
    }

}