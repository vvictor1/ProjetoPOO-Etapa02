import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();
        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== SISTEMA DO RESTAURANTE ===");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Produto");
            System.out.println("3 - Adicionar Mesa ao Sistema");
            System.out.println("4 - Reservar Mesa");
            System.out.println("5 - Registrar Pedido");
            System.out.println("6 - Fechar Conta da Mesa");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Digite um número.");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.println("\n--- CADASTRAR CLIENTE ---");
                    System.out.print("ID do Cliente: ");
                    int idCli = Integer.parseInt(sc.nextLine());
                    System.out.print("Nome: ");
                    String nomeCli = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telCli = sc.nextLine();
                    
                    restaurante.cadastrarCliente(idCli, nomeCli, telCli);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("\n--- CADASTRAR PRODUTO ---");
                    System.out.print("ID do Produto: ");
                    int idProd = Integer.parseInt(sc.nextLine());
                    System.out.print("Nome do Produto: ");
                    String nomeProd = sc.nextLine();
                    System.out.print("Preço: R$ ");
                    double precoProd = Double.parseDouble(sc.nextLine());
                    
                    restaurante.cadastrarProduto(idProd, nomeProd, precoProd);
                    System.out.println("Produto adicionado ao cardápio!");
                    break;

                case 3:
                    System.out.println("\n--- ADICIONAR MESA ---");
                    System.out.print("Número da Mesa: ");
                    int numMesa = Integer.parseInt(sc.nextLine());
                    restaurante.adicionarMesa(numMesa);
                    System.out.println("Mesa " + numMesa + " cadastrada com sucesso!");
                    break;

                case 4:
                    System.out.println("\n--- RESERVAR MESA ---");
                    System.out.print("Número da Mesa para Reserva: ");
                    int reservaMesa = Integer.parseInt(sc.nextLine());
                    restaurante.reservarMesa(reservaMesa);
                    break;

                case 5:
                    System.out.println("\n--- REGISTRAR PEDIDO ---");
                    System.out.print("Número da Mesa: ");
                    int mesaPed = Integer.parseInt(sc.nextLine());
                    System.out.print("ID do Produto: ");
                    int idBusca = Integer.parseInt(sc.nextLine());
                    
                    // Busca o produto usando a estrutura do sistema
                    Produto produtoEncontrado = restaurante.buscarProduto(idBusca);
                    
                    if (produtoEncontrado != null) {
                        System.out.print("Quantidade: ");
                        int qtd = Integer.parseInt(sc.nextLine());
                        
                        // Calcula o total com base nas regras do objeto Pedido
                        double totalPedido = produtoEncontrado.getPreco() * qtd;
                        Pedido novoPedido = new Pedido(mesaPed, produtoEncontrado.getNome(), qtd, totalPedido);
                        
                        restaurante.registrarPedido(novoPedido);
                        System.out.println("Pedido de '" + produtoEncontrado.getNome() + "' adicionado!");
                    } else {
                        System.out.println("Erro: Produto com ID " + idBusca + " não encontrado.");
                    }
                    break;

                case 6:
                    System.out.println("\n--- FECHAMENTO DE CONTA ---");
                    System.out.print("Número da Mesa: ");
                    int mesaConta = Integer.parseInt(sc.nextLine());
                    
                    double totalMesa = restaurante.calcularTotalMesa(mesaConta);
                    System.out.println("----------------------------");
                    System.out.println("Mesa: " + mesaConta);
                    System.out.printf("Total acumulado a pagar: R$ %.2f\n", totalMesa);
                    System.out.println("----------------------------");
                    break;

                case 0:
                    System.out.println("Saindo do sistema do restaurante...");
                    break;

                default:
                    System.out.println("Opção incorreta! Tente de novo.");
                    break;
            }
        }
        sc.close();
    }
}