
import java.util.LinkedList;
import java.util.List;

public class Mercado {
    // Lista que armazena todos os clientes cadastrados no mercado
    // Usa LinkedList para facilitar inserções e remoções
    private List<Cliente> clientes = new LinkedList<>();

    // Método para adicionar um novo cliente à lista de clientes

    public void addClientes(Cliente cliente) {
        clientes.add(cliente);
    }

    // Método para buscar clientes pelo nome
    public List<Cliente> buscarClienteNome(String nome) {
        // Lista para armazenar os clientes encontrados
        List<Cliente> encontrados = new LinkedList<Cliente>();

        // Percorre todos os clientes cadastrados
        for (Cliente cliente : clientes) {
            // Verifica se o nome do cliente atual é igual ao nome buscado
            if (cliente.getNome().equals(nome))
                encontrados.add(cliente);  // Adiciona à lista de encontrados
        }

        // Retorna a lista (pode estar vazia se não encontrar ninguém)
        return encontrados;
    }

   //
    public Cliente buscarClienteCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;  // Retorna apenas se encontrar
            }
        }
        return null;
    }


    // Método para filtrar clientes que possuem ou não cartão fidelidade
    public List<Cliente> verificarCartao(boolean possuiCartao) {
        // Lista para armazenar os clientes encontrados
        List<Cliente> encontrados = new LinkedList<Cliente>();

        // Percorre todos os clientes cadastrados
        for (Cliente cliente : clientes) {
            // Verifica se o status do cartão do cliente corresponde ao buscado
            if (cliente.isCartao() == possuiCartao) {
                encontrados.add(cliente);  // Adiciona à lista de encontrados
            }
        }

        // Retorna a lista de clientes filtrados
        return encontrados;
    }

    // Método getter para obter a lista completa de clientes
    public List<Cliente> getClientes() {
        return clientes;
    }
}
