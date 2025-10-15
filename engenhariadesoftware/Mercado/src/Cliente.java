public class Cliente {
    // Atributos privados da classe
    private String nome;
    private String cpf;
    private boolean cartao;

    // Construtor da classe Cliente

    public Cliente(String nome, String cpf, boolean cartao) {
        this.nome = nome;
        this.cpf = cpf;
        this.cartao = cartao;
    }

    // Método getter para obter o nome do cliente

    public String getNome() {
        return nome;
    }

    // Método setter para modificar o nome do cliente

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método getter para obter o CPF do cliente

    public String getCpf() {
        return cpf;
    }

    // Método getter para verificar se o cliente possui cartão fidelidade

    public boolean isCartao() {
        return cartao;
    }

    // Método setter para modificar o status do cartão fidelidade

    public void setCartao(boolean cartao) {
        this.cartao = cartao;
    }
}
