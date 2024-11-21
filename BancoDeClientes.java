import java.util.ArrayList;

public class BancoDeClientes {
    private ArrayList<Cliente> clientes;

    // Construtor
    public BancoDeClientes() {
        clientes = new ArrayList<>();
    }

    // Método para inserir um cliente
    public void inserirCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    // Método para remover um cliente pelo ID
    public boolean removerCliente(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                clientes.remove(cliente);
                return true;
            }
        }
        return false;
    }

    // Método para alterar os dados de um cliente pelo ID
    public boolean alterarCliente(int id, String novoNome, String novoFone) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                cliente.setNome(novoNome);
                cliente.setFone(novoFone);
                return true;
            }
        }
        return false;
    }

    // Método para listar os dados de um cliente específico pelo ID
    public Cliente listarCliente(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null; // Cliente não encontrado
    }

    // Método para listar todos os clientes
    public void listarTodosClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }
}
