import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Restaurante implements MesaOperacoes, FilaEsperaOperacoes {
    private List<Mesa> mesas;
    private Queue<Requisicao> filaEspera;

    public Restaurante() {
        this.mesas = new ArrayList<>();
        this.filaEspera = new LinkedList<>();
    }

    public void adicionarMesa(Mesa mesa) {
        mesas.add(mesa);
    }

    @Override
    public void ocuparMesa(Mesa mesa) {
        if (!mesa.isOcupada()) {
            mesa.setOcupada(true);
            mesa.setHoraChegada(LocalTime.now()); // Registra a hora de entrada
        } else {
            System.out.println("A mesa já está ocupada");
        }
    }

    @Override
    public void desocuparMesa(Mesa mesa) {
        if (mesa.isOcupada()) {
            mesa.setOcupada(false);
            mesa.setHoraSaida(LocalTime.now());
        } else {
            System.out.println("A mesa já está desocupada");
        }
    }

    @Override
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

    @Override
    public void adicionarClienteNaFila(Cliente cliente) {
        Requisicao requisicao = new Requisicao(cliente, null, LocalTime.now(), null, 1);
        filaEspera.offer(requisicao);
        System.out.println("Cliente " + cliente.getRg() + " adicionado à fila de espera.");
    }

    @Override
    public Requisicao proximoClienteNaFila() {
        return filaEspera.poll();
    }

    @Override
    public boolean filaDeEsperaVazia() {
        return filaEspera.isEmpty();
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
        if (alocadaMesa != null)
            System.out.println("Mesa alocada para o cliente " + cliente1.getRg() + ": " + alocadaMesa.getNumero());

        restaurante.adicionarClienteNaFila(cliente2);
        System.out.println("Cliente " + cliente2.getRg() + " adicionado à fila de espera.");
    }
}