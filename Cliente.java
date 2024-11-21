public class Cliente {
    private String nome;
    private String fone;
    private int id;

    // Construtor
    public Cliente(String nome, String fone, int id) {
        this.nome = nome;
        this.fone = fone;
        this.id = id;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Método toString para exibição
    @Override
    public String toString() {
        return "Cliente [ID: " + id + ", Nome: " + nome + ", Telefone: " + fone + "]";
    }
}
