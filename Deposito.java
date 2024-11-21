import java.util.ArrayList;

public class Deposito {
    private ArrayList<Caixa> caixas;

    // Construtor
    public Deposito() {
        caixas = new ArrayList<>();
    }

    // Método para adicionar uma caixa
    public void adicionarCaixa(Caixa caixa) {
        caixas.add(caixa);
    }

    // Método para remover uma caixa pelo dono
    public boolean removerCaixa(String dono) {
        int posicao = encontrarCaixa(dono);
        if (posicao != -1) {
            caixas.remove(posicao);
            return true;
        }
        return false;
    }

    // Método para encontrar uma caixa pelo dono
    public int encontrarCaixa(String dono) {
        for (int i = 0; i < caixas.size(); i++) {
            if (caixas.get(i).getDono().equalsIgnoreCase(dono)) {
                return i;
            }
        }
        return -1; // Não encontrado
    }

    // Método para alterar corredor e posição de uma caixa
    public boolean alterarCaixa(String dono, String novoCorredor, int novaPosicao) {
        int posicao = encontrarCaixa(dono);
        if (posicao != -1) {
            Caixa caixa = caixas.get(posicao);
            caixa.setCorredor(novoCorredor);
            caixa.setPosicao(novaPosicao);
            return true;
        }
        return false;
    }

    // Método para retornar caixas com peso maior que um valor
    public Caixa[] caixasPesadas(double pesoMinimo) {
        ArrayList<Caixa> pesadas = new ArrayList<>();
        for (Caixa caixa : caixas) {
            if (caixa.getPeso() > pesoMinimo) {
                pesadas.add(caixa);
            }
        }
        return pesadas.toArray(new Caixa[0]);
    }

    // Método para listar todas as caixas (opcional para testes)
    public void listarCaixas() {
        if (caixas.isEmpty()) {
            System.out.println("Nenhuma caixa cadastrada.");
        } else {
            for (Caixa caixa : caixas) {
                System.out.println(caixa);
            }
        }
    }
}
