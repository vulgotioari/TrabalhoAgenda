package br.com.DAO; 

import br.com.DAO.conexaoDAO; // Importa a classe para gerenciar a conexão com o banco de dados
import br.com.DTO.usuarioDTO; // Importa a classe de Data Transfer Object para usuários
import br.com.View.telaPrincipal; // Importa a classe da tela principal
import br.com.View.telaUsuario; // Importa a classe da tela de usuário
import java.sql.*; // Importa classes para trabalhar com SQL
import javax.swing.JOptionPane; // Importa classe para exibir diálogos de mensagem
import javax.swing.table.DefaultTableModel; // Importa classe para manipulação de tabelas

public class usuarioDAO {

    Connection conexao = null; // Objeto para gerenciar a conexão
    PreparedStatement pst = null; // Objeto para preparar as instruções SQL
    ResultSet rs = null; // Objeto para armazenar os resultados da consulta
    
    // Método para incluir um novo usuário no banco de dados
    public void IncluirUsuario(usuarioDTO udto) {
        String sql = "insert into usuarios(id, nome, email, usuario, senha) values(?,?,?,?,?)"; // SQL de inserção
        
        conexao = new conexaoDAO().conector(); // Estabelece a conexão
        
        try {
            pst = conexao.prepareStatement(sql); // Prepara a consulta SQL
            // Define os parâmetros da consulta
            pst.setInt(1, udto.getIdUsuario());
            pst.setString(2, udto.getNomeUsuario());
            pst.setString(3, udto.getEmailUsuario());
            pst.setString(4, udto.getLoginUsuario());
            pst.setString(5, udto.getSenhaUsuario());
            
            int add = pst.executeUpdate(); // Executa a inserção
            if (add > 0) { // Se a inserção for bem-sucedida
                pst.close(); // Fecha o PreparedStatement
                JOptionPane.showMessageDialog(null, "Usuários inserido com sucesso!"); // Mensagem de sucesso
                limpar(); // Limpa os campos
                preenchertabela(); // Atualiza a tabela de usuários
            }
        } catch (SQLException e) { // Captura exceções de SQL
            JOptionPane.showMessageDialog(null, "inserir usuário" + e); // Mensagem de erro
        }
    }
    
    // Método para realizar o login do usuário
    public void logar(usuarioDTO udto) {
        String sql = "select * from usuarios where usuario = ? and senha = ?"; // SQL de login
        conexao = new conexaoDAO().conector(); // Estabelece a conexão
        
        try {
            pst = conexao.prepareStatement(sql); // Prepara a consulta
            // Define os parâmetros da consulta
            pst.setString(1, udto.getLoginUsuario());
            pst.setString(2, udto.getSenhaUsuario());

            rs = pst.executeQuery(); // Executa a consulta
            if (rs.next()) { // Se um usuário for encontrado
                telaPrincipal principal = new telaPrincipal(); // Cria a tela principal
                principal.setVisible(true); // Torna a tela principal visível
                telaPrincipal.lblNome.setText(rs.getString(2)); // Exibe o nome do usuário logado
            } else {
                JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválidos!!!"); // Mensagem de erro
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "metodo logar" + e); // Mensagem de erro
        }
    }
    
    // Método para editar as informações de um usuário
    public void editar(usuarioDTO udto) {
        String sql = "update usuarios set nome = ?, email = ?, nome_usuario = ?, senha = ? where id = ?"; // SQL de atualização
        conexao = conexaoDAO.conector(); // Estabelece a conexão
        
        try {
            pst = conexao.prepareStatement(sql); // Prepara a consulta
            // Define os parâmetros da consulta
            pst.setInt(5, udto.getIdUsuario());
            pst.setString(1, udto.getNomeUsuario());
            pst.setString(2, udto.getEmailUsuario());
            pst.setString(3, udto.getLoginUsuario());
            pst.setString(4, udto.getSenhaUsuario());
            
            int add = pst.executeUpdate(); // Executa a atualização
            if (add > 0) { // Se a atualização for bem-sucedida
                conexao.close(); // Fecha a conexão
                JOptionPane.showMessageDialog(null, "Usuários editado com sucesso!"); // Mensagem de sucesso
                limpar(); // Limpa os campos
                preenchertabela(); // Atualiza a tabela de usuários
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Método editar " + e); // Mensagem de erro
        }
    }
    
    // Método para pesquisar um usuário pelo ID
    public void pesquisar(usuarioDTO udto) {
        String sql = "select * from usuarios where id = ? "; // SQL de pesquisa
        conexao = conexaoDAO.conector(); // Estabelece a conexão
        
        try {
            pst = conexao.prepareStatement(sql); // Prepara a consulta
            pst.setInt(1, udto.getIdUsuario()); // Define o parâmetro
            rs = pst.executeQuery(); // Executa a consulta
            
            if (rs.next()) { // Se o usuário for encontrado
                // Preenche os campos da tela de usuário com as informações do banco
                telaUsuario.txtNome.setText(rs.getString(2));
                telaUsuario.txtEmailUsuario.setText(rs.getString(3));
                telaUsuario.txtNomeDeUsuario.setText(rs.getString(4));
                telaUsuario.txtSenha.setText(rs.getString(5));
                conexao.close(); // Fecha a conexão
            } else {
                JOptionPane.showMessageDialog(null, "Este usuário não existe!!!"); // Mensagem de erro
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "método pesquisar(DAO)" + e); // Mensagem de erro
        }
    }
    
    // Método para deletar um usuário
    public void deletar(usuarioDTO udto) {
        String sql = "delete from usuarios where id = ?"; // SQL de deleção
        conexao = new conexaoDAO().conector(); // Estabelece a conexão
        
        try {
            pst = conexao.prepareStatement(sql); // Prepara a consulta
            pst.setInt(1, udto.getIdUsuario()); // Define o parâmetro
            
            int add = pst.executeUpdate(); // Executa a deleção
            if (add > 0) { // Se a deleção for bem-sucedida
                conexao.close(); // Fecha a conexão
                JOptionPane.showMessageDialog(null, "Usuário deletado com sucesso!"); // Mensagem de sucesso
                limpar(); // Limpa os campos
                preenchertabela(); // Atualiza a tabela de usuários
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Método deletar(DAO)" + e); // Mensagem de erro
        }
    }
    
    // Método para limpar os campos da tela de usuário
    public void limpar() {
        // Limpa todos os campos de entrada
        telaUsuario.txtIDusuario.setText(null);
        telaUsuario.txtNome.setText(null);
        telaUsuario.txtEmailUsuario.setText(null);
        telaUsuario.txtNomeDeUsuario.setText(null);
        telaUsuario.txtSenha.setText(null);
    }
    
    // Método para preencher a tabela de usuários na interface
    public void preenchertabela() {
        String sql = "select nome from usuarios"; // SQL para selecionar os nomes dos usuários  
        conexao = conexaoDAO.conector(); // Estabelece a conexão
        
        try {
            pst = conexao.prepareStatement(sql); // Prepara a consulta
            rs = pst.executeQuery(); // Executa a consulta
            
            DefaultTableModel model = (DefaultTableModel) telaUsuario.tabelaUsuarios.getModel(); // Obtém o modelo da tabela
            model.setRowCount(0);  // Limpa a tabela antes de adicionar novos dados
            
            // Adiciona cada nome de usuário na tabela
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("nome") 
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela: " + e); // Mensagem de erro
        }
    }
}
