import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.List;

// Classe de teste para validar o funcionamento do sistema de Biblioteca

class Teste {

    // Método de teste que valida as funcionalidades principais da biblioteca

    @Test
    void test() {
        // 1. PREPARAÇÃO: Criar o gerente de banco de dados
        // Cria um arquivo de banco de dados chamado "teste.db"
        Gerente_BD gerenteBd = new Gerente_BD("jdbc:sqlite:teste.db");

        // 2. CRIAÇÃO: Instanciar a biblioteca com o gerente de BD
        // Isso também cria as tabelas necessárias automaticamente
        Biblioteca bib = new Biblioteca(gerenteBd);

        // 3. INSERÇÃO: Adicionar livros ao banco de dados
        // Adiciona "O Senhor dos Anéis" de Tolkien com ISBN 123
        bib.addLivro(new Livro("Senhor de Aneis", "Tolkien", "123"));

        // Adiciona livro "Java" de autor genérico com ISBN 321
        bib.addLivro(new Livro("Java", "autor", "321"));

        // 4. TESTE 1: Buscar livro por título
        // Busca todos os livros com título "Java"
        List<Livro> busca = bib.buscarLivroTitulo("Java");

        // Verifica se o autor do primeiro livro encontrado é "autor"
        // assertEquals compara se os dois valores são iguais
        assertEquals(busca.get(0).getAutor(), "autor");

        // 5. TESTE 2: Buscar livro por ISBN
        // Busca o livro com ISBN "123"
        Livro liv = bib.buscarLivroIsbn("123");

        // Verifica se o título do livro encontrado é "Senhor de Aneis"
        assertEquals(liv.getTitulo(), "Senhor de Aneis");

        // Se chegou até aqui sem erros, todos os testes passaram! ✅
    }
}