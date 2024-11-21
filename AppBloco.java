import java.util.Scanner;

public class AppBloco {
    public static void main(String[] args) {
        BlocoDeNotas bloco = new BlocoDeNotas();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Menu Bloco de Notas ---");
            System.out.println("1. Inserir uma nota");
            System.out.println("2. Remover uma nota");
            System.out.println("3. Alterar uma nota");
            System.out.println("4. Listar todas as notas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opçao: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1: // Inserir uma nota
                    System.out.print("Digite a nota: ");
                    String novaNota = scanner.nextLine();
                    bloco.inserirNota(novaNota);
                    System.out.println("Nota adicionada!");
                    break;

                case 2: // Remover uma nota
                    System.out.print("Digite a nota para remover: ");
                    String notaRemover = scanner.nextLine();
                    if (bloco.removerNota(notaRemover)) {
                        System.out.println("Nota removida!");
                    } else {
                        System.out.println("Nota nao encontrada!");
                    }
                    break;

                case 3: // Alterar uma nota
                    System.out.print("Digite a nota que deseja alterar: ");
                    String notaAntiga = scanner.nextLine();
                    int posicao = bloco.buscarNota(notaAntiga);
                    if (posicao != -1) {
                        System.out.print("Digite a nova nota: ");
                        String notaNova = scanner.nextLine();
                        bloco.removerNota(notaAntiga);
                        bloco.inserirNota(notaNova);
                        System.out.println("Nota alterada!");
                    } else {
                        System.out.println("Nota nao encontrada!");
                    }
                    break;

                case 4: // Listar todas as notas
                    System.out.println("\n--- Lista de Notas ---");
                    bloco.listarNotas();
                    break;

                case 5: // Sair
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opçao invalida! Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }
}
