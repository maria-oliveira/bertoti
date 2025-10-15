import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//Classe responsável por gerenciar a conexão com o banco de dados SQLite e criar as tabelas necessárias para o sistema de biblioteca
public class Gerente_BD {
    // URL padrão para conexão com SQLite (não é usada diretamente, mas está definida)
    private static final String URL = "jdbc:sqlite:meubanco.db";

    // URL da conexão que será efetivamente usada
    private final String url;

    // Objeto de conexão com o banco de dados
    private Connection conn;

    //Construtor da classe Gerente_BD
    public Gerente_BD(String url) {
        this.url = url;
        connect();
    }

    //Método para estabelecer conexão com o banco de dados
    public Connection connect() {
        try {
            // Verifica se não existe conexão ou se ela está fechada
            if (conn == null || conn.isClosed()) {
                // Cria uma nova conexão usando o DriverManager
                conn = DriverManager.getConnection(this.url);
                System.out.println("Conexão com SQLite estabelecida.");
            }
        } catch (SQLException e) {
            // Captura e exibe erros de conexão
            System.err.println("Erro ao conectar com o banco de dados: " + e.getMessage());
        }
        return conn;
    }

    // Método para criar as tabelas necessárias no banco de dados
    public void criarTabelas() {
        // SQL para criar a tabela de livros
        // isbn é a chave primária (PRIMARY KEY) - identificador único
        String sqlLivros = "CREATE TABLE IF NOT EXISTS livros (" +
                "isbn TEXT PRIMARY KEY," +
                "titulo TEXT NOT NULL," +
                "autor TEXT NOT NULL" +
                ");";

        // SQL para criar a tabela de usuários
        // id (RA) é a chave primária
        String sqlUsuarios = "CREATE TABLE IF NOT EXISTS usuarios (" +
                "id TEXT PRIMARY KEY," +
                "nome TEXT NOT NULL" +
                ");";

        try (Statement stmt = connect().createStatement()) {
            // Executa a criação da tabela de livros
            stmt.execute(sqlLivros);

            // Executa a criação da tabela de usuários
            stmt.execute(sqlUsuarios);

            System.out.println("Tabelas criadas com sucesso.");
        } catch (SQLException e) {
            // Captura e exibe erros na criação das tabelas
            System.err.println("Erro ao criar tabelas: " + e.getMessage());
        }
    }
}