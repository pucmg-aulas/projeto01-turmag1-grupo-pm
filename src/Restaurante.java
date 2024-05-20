import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Restaurante implements IRestaurante, MesaOperacoes, FilaEsperaOperacoes {
    private List<Mesa> mesas;
    private Queue<Requisicao> filaEspera;
    private Cardapio cardapio;

    @Override
    public Mesa alocarMesa(Cliente cliente) {
        Mesa mesaSelecionada = null;
    
        // Encontra uma mesa disponível
        for (Mesa mesa : mesas) {
            if (!mesa.isOcupada()) {
                mesaSelecionada = mesa;
                break;
            }
        }
    
        // Alocar cliente se tiver mesa
        if (mesaSelecionada != null) {
            mesaSelecionada.setOcupada(true);
            mesaSelecionada.setHoraChegada(LocalTime.now());
            mesaSelecionada.setCliente(cliente);
            System.out.println("Mesa " + mesaSelecionada.getNumero() + " alocada para o cliente " + cliente.getRg());
        } else {
            // Se não encontrou mesa disponível, adiciona o cliente à fila de espera
            Requisicao requisicao = new Requisicao(cliente, null, LocalTime.now(), null, 1);
            filaEspera.add(requisicao);
            System.out.println("Não há mesas disponíveis. Cliente " + cliente.getRg() + " adicionado à fila de espera.");
        }
    
        return mesaSelecionada;
    }

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
    public Mesa alocarMesa(Cliente cliente, int numeroMesa) {
        Mesa mesaSelecionada = null;

        // Encontra a mesa pelo número
        for (Mesa mesa : mesas) {
            if (mesa.getNumero() == numeroMesa && !mesa.isOcupada()) {
                mesaSelecionada = mesa;
                break;
            }
        }

        // Se a mesa foi encontrada e está disponível, aloca o cliente
        if (mesaSelecionada != null) {
            mesaSelecionada.setOcupada(true);
            mesaSelecionada.setHoraChegada(LocalTime.now());
            mesaSelecionada.setHoraSaida(LocalTime.now().plusHours(1));
            mesaSelecionada.setCliente(cliente);
            System.out.println("Mesa " + mesaSelecionada.getNumero() + " alocada para o cliente " + cliente.getRg());
        } else {
            // Se a mesa não foi encontrada ou está ocupada, adiciona o cliente à fila de espera
            Requisicao requisicao = new Requisicao(cliente, null, LocalTime.now(), LocalTime.now().plusHours(1), 1);
            filaEspera.add(requisicao);
            System.out.println("Não há mesas disponíveis. Cliente " + cliente.getRg() + " adicionado à fila de espera.");
        }

        return mesaSelecionada;
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
                System.out.println("""
                    \n  ***************MENU*******************************
                        * 1 - Moqueca de Tilápia                         *
                        * 2 - Falafel Assado                             *
                        * 3 - Salada Primavera com Macarrão Konjac       *
                        * 4 - Escondidinho de Frango                     *
                        * 5 - Strogonoff                                 *
                        * 6 - Caçarola de Carne com legumes              *
                        * 7 - Água                                       *
                        * 8 - Suco                                       *
                        * 9 - Refrigerante                               *
                        * 10 - Cerveja                                   *
                        * 11 - Taça de Vinho                             *
                        * 12 - Cancelar Pedido                           *
                        **************************************************""");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextLine();
                switch (opcao) {
                    case "1":
                        pratos.add("Moqueca de Tilápia");
                        break;
                    case "2":
                        pratos.add("Falafel Assado");
                        break;
                    case "3":
                        pratos.add("Salada Primavera com Macarrão Konjac");
                        break;
                    case "4":
                        pratos.add("Escondidinho de Frango");
                        break;
                    case "5":
                        pratos.add("Strogonoff");
                        break;
                    case "6":
                        pratos.add("Caçarola de Carne com legumes");
                        break;
                    case "7":
                        bebidas.add("Água");
                        break;
                    case "8":
                        bebidas.add("Suco");
                        break;
                    case "9":
                        bebidas.add("Refrigerante");
                        break;
                    case "10":
                        bebidas.add("Cerveja");
                        break;
                    case "11":
                        bebidas.add("Taça de Vinho");
                        break;
                    case "12":
                        System.out.println("Pedido cancelado.");
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } while (!opcao.equals("12"));

            Pedido pedido = new Pedido(pratos, bebidas);
            cliente.setPedidoAtual(pedido);
            System.out.println("Pedido realizado com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao processar o pedido: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();
        try (Scanner scanner = new Scanner(System.in)) {

            boolean sair = false;
            while (!sair) {
                System.out.println("***************MENU*******************************");
                System.out.println("* 1 - Abrir Requisição                           *");
                System.out.println("* 2 - Finalizar Requisição                       *");
                System.out.println("* 3 - Listar requisições na lista de espera      *");
                System.out.println("* 4 - Listar requisições abertas                 *");
                System.out.println("* 5 - Adicionar uma nova mesa                    *");
                System.out.println("* 6 - Listar mesas                               *");
                System.out.println("* 7 - Fazer pedido                               *");
                System.out.println("* 8 - Sair                                       *");
                System.out.println("**************************************************");

                System.out.print("Escolha uma opção: ");
                int escolha = Integer.parseInt(scanner.nextLine());

                switch (escolha) {
                    case 1:
                        System.out.println("Abrir Requisição selecionado.");
                        System.out.print("Digite o RG do cliente: ");
                        String rgClienteRequisicao = scanner.nextLine();
                        Cliente clienteRequisicao = new Cliente(rgClienteRequisicao);
                        restaurante.adicionarRequisicao(new Requisicao(clienteRequisicao, null, LocalTime.now(), null, 1));
                        System.out.println("Requisição aberta com sucesso.");
                        break;
                    case 2:
                        System.out.println("Finalizar Requisição selecionado.");
                        if (!restaurante.filaDeEsperaVazia()) {
                            Requisicao proximaRequisicao = restaurante.proximoClienteNaFila();
                            System.out.println("Requisição finalizada para o cliente: " + proximaRequisicao.getCliente().getRg());
                        } else {
                            System.out.println("Não há requisições na lista de espera para finalizar.");
                        }
                        break;
                    case 3:
                        System.out.println("Listar requisições na lista de espera selecionado.");
                        List<Requisicao> requisicoesNaFila = restaurante.getRequisicoes();
                        if (requisicoesNaFila.isEmpty()) {
                            System.out.println("Não há requisições na lista de espera.");
                        } else {
                            System.out.println("Requisições na lista de espera:");
                            for (Requisicao requisicao : requisicoesNaFila) {
                                System.out.println("- Cliente: " + requisicao.getCliente().getRg() + ", Hora de chegada: " + requisicao.getHoraChegada());
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Listar requisições abertas selecionado.");
                        List<Mesa> mesasOcupadas = restaurante.mesas.stream()
                                .filter(Mesa::isOcupada)
                                .collect(Collectors.toList());
                        if (mesasOcupadas.isEmpty()) {
                            System.out.println("Não há requisições abertas.");
                        } else {
                            System.out.println("Requisições abertas:");
                            for (Mesa mesa : mesasOcupadas) {
                                System.out.println("- Mesa: " + mesa.getNumero() + ", Cliente: " + mesa.getCliente().getRg());
                            }
                        }
                        break;
                    case 5:
                        System.out.println("Adicionar uma nova mesa selecionado.");
                        System.out.print("Digite o número da nova mesa: ");
                        int numeroNovaMesa = Integer.parseInt(scanner.nextLine());
                        System.out.print("Digite a capacidade da nova mesa: ");
                        int capacidadeNovaMesa = Integer.parseInt(scanner.nextLine());
                        restaurante.adicionarMesa(new Mesa(numeroNovaMesa, capacidadeNovaMesa));
                        System.out.println("Nova mesa adicionada com sucesso.");
                        break;
                    case 6:
                        System.out.println("Listar mesas selecionado.");
                        if (restaurante.mesas.isEmpty()) {
                            System.out.println("Não há mesas cadastradas.");
                        } else {
                            System.out.println("Mesas disponíveis:");
                            for (Mesa mesa : restaurante.mesas) {
                                System.out.println("- Mesa: " + mesa.getNumero() + ", Capacidade: " + mesa.getCapacidade());
                            }
                        }
                        break;
                    case 7:
                        System.out.println("Fazer pedido selecionado.");
                        System.out.print("Digite o RG do cliente: ");
                        String rgClientePedido = scanner.nextLine();
                        Cliente clientePedido = new Cliente(rgClientePedido);
                        System.out.print("Digite o número da mesa: ");
                        int numeroMesa = Integer.parseInt(scanner.nextLine());
                        restaurante.alocarMesa(clientePedido, numeroMesa);
                        restaurante.fazerPedido(clientePedido);
                        break;
                    case 8:
                        System.out.println("Sair selecionado. Encerrando programa...");
                        sair = true;
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
