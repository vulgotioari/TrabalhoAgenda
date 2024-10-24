/*
 * Para alterar o cabeçalho desta licença, escolha Licença nos Propriedades do Projeto.
 * Para alterar este arquivo de modelo, escolha Ferramentas | Modelos 
 * e abra o modelo no editor.
 */
package br.com.DAO;

import java.sql.Connection; // Classe para gerenciar a conexão SQL
import java.sql.DriverManager; // Classe para gerenciar a conexão com o driver SQL
import javax.swing.JOptionPane; // Classe para exibir diálogos de mensagem

/**
 * Classe responsável por gerenciar a conexão com o banco de dados.
 * 
 * @author aluno.saolucas
 */
public class conexaoDAO {
    java.sql.Connection conexao = null; // Objeto de conexão com o banco de dados
    
    // URL, usuário e senha para conexão ao banco de dados
    String url = "jdbc:mysql://localhost:3306/TelaAgenda";
String usuario = "root"; // ou outro usuário, se necessário
String senha = "root"; // verifique a senha


    /**
     * Método que estabelece a conexão com o banco de dados.
     * 
     * @return A conexão estabelecida ou null em caso de erro.
     */
    public static Connection conector() {
        java.sql.Connection conexao = null; // Objeto de conexão local

        // Nome do driver para o MySQL
        String driver = "com.mysql.jdbc.Driver";

        // URL, usuário e senha para conexão ao banco de dados
        String url = "jdbc:mysql://localhost:3306/projetoagenda";
        String user = "root";
        String password = "root";

        try {
            Class.forName(driver); // Registra o driver JDBC
            conexao = DriverManager.getConnection(url, user, password); // Estabelece a conexão
            return conexao; // Retorna a conexão estabelecida

        } catch (Exception e) { // Trata exceções na conexão
            JOptionPane.showMessageDialog(null, "Conexão" + e); // Mensagem de erro
            return null; // Retorna null em caso de erro
        }
    }
}
