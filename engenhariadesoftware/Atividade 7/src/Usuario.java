public class Usuario {

    // Atributos privados da classe
    private String nome;
    private String ra;

    //Construtor da classe Usuario
    public Usuario(String nome, String ra) {
        this.nome = nome;
        this.ra = ra;
    }

    //Método getter para obter o nome do usuário
    public String getNome() {
        return nome;
    }

    //Método setter para modificar o nome do usuário
    void setNome(String nome) {
        this.nome = nome;
    }

    //Método getter para obter o RA do usuário
    public String getRa() {
        return ra;
    }

    //Método setter para modificar o RA do usuário
    public void setRa(String ra) {
        this.ra = ra;
    }
}