import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    // Referência ao gerenciador do banco de dados
    private Gerente_BD gerenteBd;

    //Construtor da classe Biblioteca
    public Biblioteca(Gerente_BD gerenteBd) {
        this.gerenteBd = gerenteBd;
        // Cria as tabelas no banco de dados ao inicializar a biblioteca
        this.gerenteBd.criarTabelas();
    }

    // Método para adicionar um novo livro ao banco de dados

    public void addLivro(Livro livro) {
        // SQL preparado para inserir um livro (os ? são placeholders para os valores)
        String sql = "INSERT INTO livros(isbn, titulo, autor) VALUES (?, ?, ?)";

        // try-with-resources: fecha automaticamente a conexão e o statement
        try (Connection conn = gerenteBd.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Substitui os placeholders (?) pelos valores reais
            stmt.setString(1, livro.getIsbn());
            stmt.setString(2, livro.getTitulo());
            stmt.setString(3, livro.getAutor());

            // Executa a inserção no banco de dados
            stmt.executeUpdate();
        } catch (SQLException e) {
            // Captura e exibe erros de SQL
            System.err.println("Erro ao adicionar livro: " + e.getMessage());
        }
    }

    // Método para buscar livros por título

    public List<Livro> buscarLivroTitulo(String titulo) {
        // Lista para armazenar os livros encontrados
        List<Livro> encontrados = new ArrayList<>();

        // SQL preparado para buscar livros por título
        String sql = "SELECT * FROM livros WHERE titulo = ?";

        try (Connection conn = gerenteBd.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Define o título a ser buscado
            stmt.setString(1, titulo);

            // Executa a query e recebe os resultados
            ResultSet rs = stmt.executeQuery();

            // Itera sobre todos os resultados encontrados
            while (rs.next()) {
                // Cria um objeto Livro com os dados do banco e adiciona à lista
                encontrados.add(new Livro(
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("isbn")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar livros: " + e.getMessage());
        }

        // Retorna a lista de livros encontrados (pode estar vazia se não encontrar nada)
        return encontrados;
    }

    //Método para buscar um livro específico pelo ISBN

    public Livro buscarLivroIsbn(String isbn) {
        // SQL preparado para buscar livro por ISBN
        String sql = "SELECT * FROM livros WHERE isbn = ?";

        try (Connection conn = gerenteBd.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Define o ISBN a ser buscado
            stmt.setString(1, isbn);

            // Executa a query
            ResultSet rs = stmt.executeQuery();

            // Como ISBN é chave primária, só pode ter um resultado
            if (rs.next()) {
                // Retorna o livro encontrado
                return new Livro(
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("isbn")
                );
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar livro por ISBN: " + e.getMessage());
        }

        // Retorna null se não encontrar o livro
        return null;
    }

    // Método para adicionar um novo usuário ao banco de dados
    public void addUsuario(Usuario usuario) {
        // SQL preparado para inserir um usuário
        String sql = "INSERT INTO usuarios(id, nome) VALUES (?, ?)";

        try (Connection conn = gerenteBd.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Substitui os placeholders pelos valores
            stmt.setString(1, usuario.getRa());    // Primeiro ? recebe o RA
            stmt.setString(2, usuario.getNome());  // Segundo ? recebe o nome

            // Executa a inserção
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar usuário: " + e.getMessage());
        }
    }

    // Método para listar todos os usuários cadastrados

    public List<Usuario> listarUsuarios() {
        // Lista para armazenar os usuários
        List<Usuario> usuarios = new ArrayList<>();

        // SQL para selecionar todos os usuários
        String sql = "SELECT * FROM usuarios";

        try (Connection conn = gerenteBd.connect();
             Statement stmt = conn.createStatement();  // Statement simples (sem parâmetros)
             ResultSet rs = stmt.executeQuery(sql)) {

            // Itera sobre todos os resultados
            while (rs.next()) {
                // Cria um objeto Usuario e adiciona à lista
                usuarios.add(new Usuario(
                        rs.getString("nome"),  // Obtém o nome da coluna "nome"
                        rs.getString("id")     // Obtém o RA da coluna "id"
                ));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar usuários: " + e.getMessage());
        }

        // Retorna a lista de usuários (pode estar vazia se não houver usuários)
        return usuarios;
    }
}