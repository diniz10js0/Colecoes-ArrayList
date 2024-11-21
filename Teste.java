import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Deposito deposito = new Deposito();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Menu Deposito ---");
            System.out.println("1. Adicionar uma caixa");
            System.out.println("2. Remover uma caixa (pelo dono)");
            System.out.println("3. Procurar uma caixa (pelo dono)");
            System.out.println("4. Alterar corredor e posição de uma caixa");
            System.out.println("5. Listar caixas com peso maior que um valor");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opçao: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1: // Adicionar uma caixa
                    System.out.print("Digite o corredor: ");
                    String corredor = scanner.nextLine();
                    System.out.print("Digite a posiçao: ");
                    int posicao = scanner.nextInt();
                    System.out.print("Digite o peso: ");
                    double peso = scanner.nextDouble();
                    scanner.nextLine(); // Limpa o buffer
                    System.out.print("Digite o nome do dono: ");
                    String dono = scanner.nextLine();

                    Caixa caixa = new Caixa(corredor, posicao, peso, dono);
                    deposito.adicionarCaixa(caixa);
                    System.out.println("Caixa adicionada!");
                    break;

                case 2: // Remover uma caixa pelo dono
                    System.out.print("Digite o nome do dono: ");
                    String donoRemover = scanner.nextLine();
                    if (deposito.removerCaixa(donoRemover)) {
                        System.out.println("Caixa removida!");
                    } else {
                        System.out.println("Caixa nao encontrada!");
                    }
                    break;

                case 3: // Procurar uma caixa pelo dono
                    System.out.print("Digite o nome do dono: ");
                    String donoProcurar = scanner.nextLine();
                    int indice = deposito.encontrarCaixa(donoProcurar);
                    if (indice != -1) {
                        System.out.println("Caixa encontrada na posiçao " + indice);
                    } else {
                        System.out.println("Caixa nao encontrada!");
                    }
                    break;

                case 4: // Alterar corredor e posição
                    System.out.print("Digite o nome do dono: ");
                    String donoAlterar = scanner.nextLine();
                    System.out.print("Digite o novo corredor: ");
                    String novoCorredor = scanner.nextLine();
                    System.out.print("Digite a nova posiçao: ");
                    int novaPosicao = scanner.nextInt();

                    if (deposito.alterarCaixa(donoAlterar, novoCorredor, novaPosicao)) {
                        System.out.println("Caixa alterada com sucesso!");
                    } else {
                        System.out.println("Caixa nao encontrada!");
                    }
                    break;

                case 5: // Listar caixas com peso maior que um valor
                    System.out.print("Digite o peso minimo: ");
                    double pesoMinimo = scanner.nextDouble();
                    Caixa[] caixasPesadas = deposito.caixasPesadas(pesoMinimo);

                    if (caixasPesadas.length > 0) {
                        System.out.println("\n--- Caixas com peso maior que " + pesoMinimo + " ---");
                        for (Caixa c : caixasPesadas) {
                            System.out.println(c);
                        }
                    } else {
                        System.out.println("Nenhuma caixa encontrada com peso maior que " + pesoMinimo);
                    }
                    break;

                case 6: // Sair
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opçao inválida! Tente novamente.");
            }
        } while (opcao != 6);

        scanner.close();
    }
}
