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
                    // Código existente...
                    break;
                case 2:
                    // Código existente...
                    break;
                case 3:
                    // Código existente...
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
                            // Adiciona o item ao pedido do cliente
                            boolean isBebida = restaurante.getCardapio().getBebidas().contains(item);
                            clientePedido.fazerRequisicao(1).fazerPedido().adicionarItemAoPedido(item, isBebida);
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
                        for (Cliente cliente : restaurante.getClientes()) {
                            Requisicao req = cliente.fazerRequisicao(1);
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
                    // Código existente...
                    break;
                case 7:
                    // Código existente...
                    break;
                case 8:
                    // Código existente...
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }
}
