package br.com.DAO;

import br.com.DTO.agendaDTO; 
import br.com.DTO.clienteDTO;
import br.com.DTO.usuarioDTO;
import br.com.View.telaAgenda; 
import static br.com.View.telaAgenda.tabelaAgenda; 
import br.com.View.telaPrincipal;
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import javax.swing.JOptionPane; 
import javax.swing.table.DefaultTableModel;

public class clienteDAO { 
    Connection conexao = null; // Conexão com o banco de dados
    PreparedStatement pst = null; // Instrução SQL preparada
    ResultSet rs = null; // Resultados da consulta

    public void agendar(agendaDTO adto) { // Método para agendar
        String sql = "INSERT INTO agendas(idAgendamento, nomeCliente, conteudo, datas, hora) VALUES (?, ?, ?, ?, ?)"; // SQL para inserção
        conexao = new conexaoDAO().conector(); // Estabelece conexão com o banco de dados

        try {
            java.util.Date dataHoje = new java.util.Date(); // Obtém a data atual
            if (adto.getData().before(dataHoje)) { // Verifica se a data é anterior à data atual
                JOptionPane.showMessageDialog(null, "Não é permitido agendar para uma data anterior à data atual!!!");
                return; // Sai do método se a data for inválida
            }

            pst = conexao.prepareStatement(sql); // Prepara a instrução SQL
            pst.setInt(1, adto.getIDclienteAgenda()); // Define o ID do cliente
            pst.setString(2, adto.getCliente()); // Define o nome do cliente
            pst.setString(3, adto.getConteudo()); // Define o conteúdo do agendamento
            pst.setDate(4, new java.sql.Date(adto.getData().getTime())); // Converte a data para SQL
            pst.setString(5, adto.getHora()); // Define a hora do agendamento

            int add = pst.executeUpdate(); // Executa a inserção
            if (add > 0) { // Verifica se a inserção foi bem-sucedida
                JOptionPane.showMessageDialog(null, "Agendado com sucesso!!!");
                limpar(); // Limpa os campos da tela
                preencherTabela(); // Atualiza a tabela de agendamentos
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir agendamento: " + e); // Mensagem de erro
        }
    }
    
    
    public void logar (usuarioDTO udto){
        String sql = "select *from usuario where usuario = ? and senha =?";
        conexao = new conexaoDAO().conector();
        
        try {
            //preparar a consulta no banco de dados, em funçao do que foi inserido nas caixas de texto
            pst = conexao.prepareStatement(sql);
            pst.setString(1, udto.getLoginUsuario());
             pst.setString(2, udto.getSenhaUsuario());
             
             //executar query
             rs = pst.executeQuery();
             if(rs.next()){
                 telaPrincipal principal = new telaPrincipal();
                 principal.setVisible(true);//mudamos a visu da tela
                 
             }else{
                 JOptionPane.showMessageDialog(null,"Usuario e ou senha incorretos" );
        }
        
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "tela de login " + e);
        }
        
    }
    
    

    public void pesquisar(agendaDTO adto) { // Método para pesquisar um agendamento
        String sql = "SELECT * FROM agendas WHERE idAgendamento = ?"; // SQL para seleção
        conexao = conexaoDAO.conector(); // Estabelece conexão com o banco de dados

        try {
            pst = conexao.prepareStatement(sql); // Prepara a instrução SQL
            pst.setInt(1, adto.getIDclienteAgenda()); // Define o ID do cliente
            rs = pst.executeQuery(); // Executa a consulta

            if (rs.next()) { // Se um resultado for encontrado
                telaAgenda.txtNomeCliente.setText(rs.getString(2)); // Preenche o nome do cliente
                telaAgenda.txtAreaConteudo.setText(rs.getString(3)); // Preenche o conteúdo
                telaAgenda.txtData.setText(rs.getString(4)); // Preenche a data
                telaAgenda.txtHora.setText(rs.getString(5)); // Preenche a hora
            } else {
                JOptionPane.showMessageDialog(null, "Este agendamento não existe!!!");
                limpar(); // Limpa os campos da tela
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar agendamento: " + e); // Mensagem de erro
        }
    }

    public void excluir(agendaDTO adto) { // Método para excluir um agendamento
        String sql = "DELETE FROM agendas WHERE idAgendamento = ?"; // SQL para deleção
        conexao = new conexaoDAO().conector(); // Estabelece conexão

        try {
            pst = conexao.prepareStatement(sql); // Prepara a instrução SQL
            pst.setInt(1, adto.getIDclienteAgenda()); // Define o ID do cliente

            int add = pst.executeUpdate(); // Executa a deleção
            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Agendamento deletado com sucesso!");
                limpar(); // Limpa os campos da tela
                preencherTabela(); // Atualiza a tabela
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar agendamento: " + e); // Mensagem de erro
        }
    }

    public void editar(agendaDTO adto) { // Método para editar um agendamento
        String sql = "UPDATE agendas SET nomeCliente = ?, conteudo = ?, datas = ?, hora = ? WHERE idAgendamento = ?"; // SQL para atualização
        conexao = conexaoDAO.conector(); // Estabelece conexão

        try {
            pst = conexao.prepareStatement(sql); // Prepara a instrução SQL
            pst.setString(1, adto.getCliente()); // Define o nome do cliente
            pst.setString(2, adto.getConteudo()); // Define o conteúdo
            pst.setDate(3, new java.sql.Date(adto.getData().getTime())); // Define a nova data
            pst.setString(4, adto.getHora()); // Define a nova hora
            pst.setInt(5, adto.getIDclienteAgenda()); // Define o ID do cliente

            int add = pst.executeUpdate(); // Executa a atualização
            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Agendamento editado com sucesso!!!");
                limpar(); // Limpa os campos da tela
                preencherTabela(); // Atualiza a tabela
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar agendamento: " + e); // Mensagem de erro
        }
    }

    public void limpar() { // Método para limpar os campos da tela
        telaAgenda.txtAreaConteudo.setText(null);
        telaAgenda.txtData.setText(null);
        telaAgenda.txtHora.setText(null);
        telaAgenda.txtIdAgendamento.setText(null);
        telaAgenda.txtNomeCliente.setText(null);
    }

    public void preencherTabela() { // Método para preencher a tabela com os agendamentos
        String sql = "SELECT * FROM agendas"; // SQL para selecionar todos os agendamentos
        conexao = conexaoDAO.conector(); // Estabelece conexão

        try {
            pst = conexao.prepareStatement(sql); // Prepara a instrução SQL
            rs = pst.executeQuery(); // Executa a consulta

            DefaultTableModel model = (DefaultTableModel) telaAgenda.tabelaAgenda.getModel(); // Obtém o modelo da tabela
            model.setRowCount(0); // Limpa a tabela antes de adicionar novos dados

            while (rs.next()) { // Para cada resultado encontrado
                model.addRow(new Object[]{
                    rs.getInt("idAgendamento"), // ID do agendamento
                    rs.getString("nomeCliente"), // Nome do cliente
                    rs.getString("conteudo"), // Conteúdo do agendamento
                    rs.getDate("datas"), // Data do agendamento
                    rs.getString("hora") // Hora do agendamento
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela: " + e); // Mensagem de erro
        }
    }

    public void pesquisar(clienteDTO cdto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void incluirClientes(clienteDTO cdto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deletarCliente(clienteDTO cdto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void editarClientes(clienteDTO cdto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void preenchertabela() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
