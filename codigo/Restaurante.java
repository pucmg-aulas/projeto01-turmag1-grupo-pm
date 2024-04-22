import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private List<Mesa> mesas;
    private List<Requisicao> filaEspera;

    public Restaurante() {
        this.mesas = new ArrayList<>();
        this.filaEspera = new ArrayList<>();
    }

    public void adicionarMesa(Mesa mesa) {
        mesas.add(mesa);
    }

    public Mesa alocarMesa(Cliente cliente) {
        for (Mesa mesa : mesas) {
            if (!mesa.isOcupada()) {
                mesa.setOcupada(true);
                mesa.setHoraChegada(LocalTime.now());
                mesa.setHoraSaida(LocalTime.now().plusHours(1));
                mesa.setCliente(cliente);
                return mesa;
            }
        }
        Requisicao requisicao = new Requisicao(cliente, null, LocalTime.now(), LocalTime.now().plusHours(1), 1);
        filaEspera.add(requisicao);
        return null;
    }

    public void adicionarFilaEspera(Requisicao requisicao) {
        filaEspera.add(requisicao);
    }

    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();
    
        Cliente cliente1 = new Cliente("123456");
        Cliente cliente2 = new Cliente("654321");
    
        Mesa mesa1 = new Mesa(1, 2);
        Mesa mesa2 = new Mesa(2, 4);
    
        restaurante.adicionarMesa(mesa1);
        restaurante.adicionarMesa(mesa2);
    
        Mesa alocadaMesa = restaurante.alocarMesa(cliente1);
        System.out.println("Mesa alocada para o cliente " + cliente1.getRg() + ": " + alocadaMesa.getNumero());
    
        Requisicao requisicao = new Requisicao(cliente2, null, LocalTime.now(), LocalTime.now().plusHours(1), 2);
        restaurante.adicionarFilaEspera(requisicao);
        System.out.println("Cliente " + cliente2.getRg() + " adicionado à fila de espera.");
    }
}