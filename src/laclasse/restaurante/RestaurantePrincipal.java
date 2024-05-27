package laclasse.restaurante;

import java.util.Scanner;

public class RestaurantePrincipal {

    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("***************MENU*******************************");
            System.out.println("1 - Verificar disponibilidade de mesas");
            System.out.println("2 - Adicionar cliente à fila de espera");
            System.out.println("3 - Adicionar cliente a mesa disponível");
            System.out.println("4 - Fazer pedido");
            System.out.println("5 - Liberar mesa");
            System.out.println("6 - Listar mesas");
            System.out.println("7 - Listar clientes na fila de espera");
            System.out.println("8 - Sair");
            System.out.println("**************************************************");
            System.out.print("Escolha uma opção: ");
            int escolha = Integer.parseInt(scanner.nextLine());

            switch (escolha) {
                case 1:
                    System.out.print("Digite a quantidade de clientes: ");
                    int quantidadeClientes = Integer.parseInt(scanner.nextLine());
                    boolean disponivel = restaurante.verificarDisponibilidade(quantidadeClientes);
                    if (disponivel) {
                        System.out.println("Há mesas disponíveis para a quantidade de clientes especificada.");
                    } else {
                        System.out.println("Não há mesas disponíveis para a quantidade de clientes especificada.");
                    }
                    break;
                case 2:
                    System.out.print("Digite o RG do cliente: ");
                    String rgCliente = scanner.nextLine();
                    Cliente cliente = new Cliente(rgCliente);
                    System.out.print("Digite a quantidade de clientes: ");
                    int qtClientes = Integer.parseInt(scanner.nextLine());
                    Requisicao requisicao = new Requisicao(cliente, qtClientes);
                    restaurante.adicionarFilaEspera(requisicao);
                    System.out.println("Cliente adicionado à fila de espera com sucesso.");
                    break;
                case 3:
                    System.out.print("Digite o RG do cliente: ");
                    String rgClienteMesa = scanner.nextLine();
                    Cliente clienteMesa = new Cliente(rgClienteMesa);
                    System.out.print("Digite a quantidade de clientes: ");
                    int qtClientesMesa = Integer.parseInt(scanner.nextLine());
                    Requisicao requisicaoMesa = new Requisicao(clienteMesa, qtClientesMesa);
                    boolean mesaAlocada = restaurante.verificarDisponibilidade(qtClientesMesa);
                    if (mesaAlocada) {
                        restaurante.alocarMesa(requisicaoMesa);
                        System.out.println("Cliente alocado a uma mesa disponível com sucesso.");
                    } else {
                        restaurante.adicionarFilaEspera(requisicaoMesa);
                        System.out.println("Não há mesas disponíveis. Cliente adicionado à fila de espera.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o RG do cliente: ");
                    String rgPedido = scanner.nextLine();
                    Cliente clientePedido = null;
                    for (Cliente c : restaurante.getClientes()) {
                        if (c.getRG().equals(rgPedido)) {
                            clientePedido = c;
                            break;
                        }
                    }

                    if (clientePedido != null) {
                        System.out.print("Digite o nome do prato ou bebida: ");
                        String itemNome = scanner.nextLine();
                        ItemMenu item = restaurante.getCardapio().getItemPorNome(itemNome);
                        if (item != null) {
                            System.out.println("Pedido feito com sucesso: " + item.getNome());
                        } else {
                            System.out.println("Item não encontrado no cardápio.");
                        }
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 5:
                    System.out.print("Digite o número da mesa a ser liberada: ");
                    int numeroMesaLiberar = Integer.parseInt(scanner.nextLine());
                    Mesa mesaLiberar = null;
                    for (Mesa mesa : restaurante.getMesas()) {
                        if (mesa.getNumero() == numeroMesaLiberar) {
                            mesaLiberar = mesa;
                            break;
                        }
                    }
                    if (mesaLiberar != null && mesaLiberar.estaOcupada()) {
                        for (Requisicao req : restaurante.getClientes().stream()
                                .map(clienteAtual -> new Requisicao(clienteAtual, 0))
                                .toList()) {
                            if (req.getMesa().equals(mesaLiberar)) {
                                restaurante.liberarMesa(req);
                                System.out.println("Mesa " + numeroMesaLiberar + " liberada com sucesso.");
                                break;
                            }
                        }
                    } else {
                        System.out.println("Mesa não encontrada ou já está desocupada.");
                    }
                    break;
                case 6:
                    System.out.println("Mesas disponíveis:");
                    for (Mesa mesa : restaurante.getMesas()) {
                        String status = mesa.estaOcupada() ? "Ocupada" : "Disponível";
                        System.out.println("- Mesa " + mesa.getNumero() + ": Capacidade " + mesa.getCapacidade() + " - " + status);
                    }
                    break;
                case 7:
                    System.out.println("Clientes na fila de espera:");
                    for (Requisicao req : restaurante.getFilaEspera()) {
                        System.out.println("- Cliente " + req.getCliente().getRG() + " (Quantidade de clientes: " + req.getQuantidadeCliente() + ")");
                    }
                    break;
                case 8:
                    System.out.println("Encerrando o programa...");
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }
}
