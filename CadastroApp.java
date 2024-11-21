import java.util.Scanner;

public class CadastroApp {
    public static void main(String[] args) {
        BancoDeClientes banco = new BancoDeClientes();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Menu Cadastro de Clientes ---");
            System.out.println("1. Inserir um cliente");
            System.out.println("2. Remover um cliente");
            System.out.println("3. Alterar um cliente");
            System.out.println("4. Listar os dados de um cliente");
            System.out.println("5. Listar todos os clientes");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opçao: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1: // Inserir um cliente
                    System.out.print("Digite o ID do cliente: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer
                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o telefone do cliente: ");
                    String fone = scanner.nextLine();

                    Cliente cliente = new Cliente(nome, fone, id);
                    banco.inserirCliente(cliente);
                    System.out.println("Cliente inserido com sucesso!");
                    break;

                case 2: // Remover um cliente
                    System.out.print("Digite o ID do cliente a ser removido: ");
                    int idRemover = scanner.nextInt();
                    if (banco.removerCliente(idRemover)) {
                        System.out.println("Cliente removido com sucesso!");
                    } else {
                        System.out.println("Cliente nao encontrado!");
                    }
                    break;

                case 3: // Alterar um cliente
                    System.out.print("Digite o ID do cliente a ser alterado: ");
                    int idAlterar = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer
                    System.out.print("Digite o novo nome do cliente: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Digite o novo telefone do cliente: ");
                    String novoFone = scanner.nextLine();

                    if (banco.alterarCliente(idAlterar, novoNome, novoFone)) {
                        System.out.println("Cliente alterado com sucesso!");
                    } else {
                        System.out.println("Cliente nao encontrado!");
                    }
                    break;

                case 4: // Listar os dados de um cliente
                    System.out.print("Digite o ID do cliente a ser listado: ");
                    int idListar = scanner.nextInt();
                    Cliente clienteEncontrado = banco.listarCliente(idListar);
                    if (clienteEncontrado != null) {
                        System.out.println(clienteEncontrado);
                    } else {
                        System.out.println("Cliente nao encontrado!");
                    }
                    break;

                case 5: // Listar todos os clientes
                    System.out.println("\n--- Lista de Todos os Clientes ---");
                    banco.listarTodosClientes();
                    break;

                case 6: // Sair
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opçao invalida! Tente novamente.");
            }
        } while (opcao != 6);

        scanner.close();
    }
}
