
//Classe que representa um Livro no sistema de biblioteca
//Contém as informações básicas de um livro: título, autor e ISBN
public class Livro {

    // Atributos privados da classe
    private String titulo;
    private String autor;
    private String isbn;

    //Construtor da classe Livro
    public Livro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }

    // Método getter para obter o título do livro
    public String getTitulo() {
        return titulo;
    }

    // Método setter para modificar o título do livro
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    //Método getter para obter o autor do livro
    public String getAutor() {
        return autor;
    }

    //Método setter para modificar o autor do livro
    public void setAutor(String autor) {
        this.autor = autor;
    }


    //Método getter para obter o ISBN do livro
    public String getIsbn() {
        return isbn;
    }

    //Método setter para modificar o ISBN do livro
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}