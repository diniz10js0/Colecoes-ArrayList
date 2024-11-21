import java.util.ArrayList;

public class BlocoDeNotas {
    private ArrayList<String> notas;

    // Construtor
    public BlocoDeNotas() {
        notas = new ArrayList<>();
    }

    // Método para inserir uma nota
    public void inserirNota(String nota) {
        notas.add(nota);
    }

    // Método para remover uma nota
    public boolean removerNota(String nota) {
        return notas.remove(nota);
    }

    // Método para buscar uma nota
    public int buscarNota(String nota) {
        return notas.indexOf(nota);
    }

    // Método para listar todas as notas
    public void listarNotas() {
        if (notas.isEmpty()) {
            System.out.println("Nenhuma nota cadastrada.");
        } else {
            for (int i = 0; i < notas.size(); i++) {
                System.out.println((i + 1) + ". " + notas.get(i));
            }
        }
    }
}
