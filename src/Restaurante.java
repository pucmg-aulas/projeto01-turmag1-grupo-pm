import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Restaurante implements IRestaurante, MesaOperacoes, FilaEsperaOperacoes {
    private List<Mesa> mesas;
    private Queue<Requisicao> filaEspera;
    private Cardapio cardapio;

    public Restaurante() {
        this.mesas = new ArrayList<>();
        this.filaEspera = new LinkedList<>();
        this.cardapio = new Cardapio();
    }

    public void adicionarMesa(Mesa mesa) {
        mesas.add(mesa);
    }

    @Override
    public void ocuparMesa(Mesa mesa) {
        if (mesa == null) {
            System.out.println("Mesa não encontrada.");
            return;
        }
        if (!mesa.isOcupada()) {
            mesa.setOcupada(true);
            mesa.setHoraChegada(LocalTime.now());
            System.out.println("Mesa " + mesa.getNumero() + " está agora ocupada.");
        } else {
            System.out.println("A mesa " + mesa.getNumero() + " já está ocupada.");
        }
    }

    @Override
    public void desocuparMesa(Mesa mesa) {
        if (mesa == null) {
            System.out.println("Mesa não encontrada.");
            return;
        }
        if (mesa.isOcupada()) {
            mesa.setOcupada(false);
            mesa.setHoraSaida(LocalTime.now());
            System.out.println("Mesa " + mesa.getNumero() + " está agora desocupada.");
        } else {
            System.out.println("A mesa " + mesa.getNumero() + " já está desocupada.");
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
                System.out.println("Mesa " + mesa.getNumero() + " alocada para o cliente " + cliente.getRg());
                return mesa;
            }
        }
        Requisicao requisicao = new Requisicao(cliente, null, LocalTime.now(), LocalTime.now().plusHours(1), 1);
        filaEspera.add(requisicao);
        System.out.println("Não há mesas disponíveis. Cliente " + cliente.getRg() + " adicionado à fila de espera.");
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

    @Override
    public void adicionarRequisicao(Requisicao requisicao) {
        filaEspera.add(requisicao);
    }

    @Override
    public List<Requisicao> getRequisicoes() {
        return new ArrayList<>(filaEspera);
    }

    public void exibirCardapio() {
        System.out.println("Cardápio:");
        System.out.println("Pratos:");
        for (String prato : cardapio.getPratos()) {
            System.out.println("- " + prato);
        }
        System.out.println("Bebidas:");
        for (String bebida : cardapio.getBebidas()) {
            System.out.println("- " + bebida);
        }
    }

    public void fazerPedido(Cliente cliente) {
        Mesa mesa = null;
        for (Mesa m : mesas) {
            if (m.getCliente() != null && m.getCliente().equals(cliente) && m.isOcupada()) {
                mesa = m;
                break;
            }
        }
        if (mesa == null) {
            System.out.println("Cliente não está associado a nenhuma mesa ocupada.");
            return;
        }

        try (Scanner scanner = new Scanner(System.in)) {
            List<String> pratos = new ArrayList<>();
            List<String> bebidas = new ArrayList<>();
            String opcao;

            exibirCardapio();

            do {
                System.out.print("Digite 'prato' para adicionar um prato, 'bebida' para adicionar uma bebida ou 'sair' para concluir: ");
                opcao = scanner.nextLine();
                if (opcao.equals("prato")) {
                    System.out.print("Digite o nome do prato: ");
                    pratos.add(scanner.nextLine());
                } else if (opcao.equals("bebida")) {
                    System.out.print("Digite o nome da bebida: ");
                    bebidas.add(scanner.nextLine());
                } else if (!opcao.equals("sair")) {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } while (!opcao.equals("sair"));

            Pedido pedido = new Pedido(pratos, bebidas);
            cliente.setPedidoAtual(pedido);
        } catch (Exception e) {
            System.out.println("Erro ao processar o pedido: " + e.getMessage());
        }

        System.out.println("Pedido realizado com sucesso.");
    }

    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();
        Scanner scanner = new Scanner(System.in);

        // Adicionar pratos e bebidas ao cardápio
        restaurante.cardapio.adicionarPrato("Pizza");
        restaurante.cardapio.adicionarPrato("Hambúrguer");
        restaurante.cardapio.adicionarBebida("Coca-Cola");
        restaurante.cardapio.adicionarBebida("Suco de Laranja");

        System.out.print("Digite o RG do cliente 1: ");
        String rgCliente1 = scanner.nextLine();
        Cliente cliente1 = new Cliente(rgCliente1);

        System.out.print("Digite o RG do cliente 2: ");
        String rgCliente2 = scanner.nextLine();
        Cliente cliente2 = new Cliente(rgCliente2);

        for (int i = 1; i <= 10; i++) {
            restaurante.adicionarMesa(new Mesa(i, 4));
        }
        
        Mesa alocadaMesa = restaurante.alocarMesa(cliente1);
        if (alocadaMesa != null) {
            System.out.println("Mesa alocada para o cliente " + cliente1.getRg() + ": " + alocadaMesa.getNumero());
        }
        
        restaurante.adicionarClienteNaFila(cliente2);
        System.out.println("Cliente " + cliente2.getRg() + " adicionado à fila de espera.");
        
        restaurante.ocuparMesa(restaurante.mesas.get(0));
        restaurante.desocuparMesa(restaurante.mesas.get(0));
        
        // Cliente 1 faz pedido
        restaurante.fazerPedido(cliente1);
        
        scanner.close();
        }
    }