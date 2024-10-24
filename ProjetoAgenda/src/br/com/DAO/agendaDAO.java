package br.com.DAO; 
import br.com.DTO.agendaDTO; 
import br.com.View.telaAgenda; 
import static br.com.View.telaAgenda.tabelaAgenda; 
import java.sql.Connection; 
import java.sql.Date; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.text.SimpleDateFormat; 
import java.util.ArrayList;
import java.util.List; 
import javax.swing.JOptionPane; 
import javax.swing.JTable; 
import javax.swing.table.DefaultTableModel; 

public class agendaDAO { 

    Connection conexao = null; // Declaração da variável de conexão ao banco de dados
    PreparedStatement pst = null; // Declaração da variável para instruções preparadas
    ResultSet rs = null; // Declaração da variável para armazenar resultados de consultas

    public void agendar(agendaDTO adto) { // Método para agendar
        // Comando SQL para inserir um novo agendamento
        String sql = "insert into agendas(idAgendamento, nomeCliente, conteudo, datas, hora) values (?, ?, ?, ?, ?)";
        conexao = new conexaoDAO().conector(); // Estabelece conexão com o banco de dados

        try {
            java.util.Date dataHoje = new java.util.Date(); // Obtém a data atual
            // Verifica se a data do agendamento é anterior à data atual
            if (adto.getData().before(dataHoje)) {
                // Exibe mensagem de erro se a data for anterior
                JOptionPane.showMessageDialog(null, "Não é permitido agendar para uma data anterior à data atual!!!");
                return; // Sai do método
            }

            pst = conexao.prepareStatement(sql); // Prepara a instrução SQL
            pst.setInt(1, adto.getIDclienteAgenda()); // Define o ID do cliente
            pst.setString(2, adto.getCliente()); // Define o nome do cliente
            pst.setString(3, adto.getConteudo()); // Define o conteúdo do agendamento
            // Converte a data do agendamento para o formato SQL
            java.sql.Date sqlDate = new java.sql.Date(adto.getData().getTime());
            pst.setDate(4, sqlDate); // Define a data do agendamento
            pst.setString(5, adto.getHora()); // Define a hora do agendamento

            int add = pst.executeUpdate(); // Executa a inserção no banco de dados
            if (add > 0) { // Verifica se a inserção foi bem-sucedida
                pst.close(); // Fecha a instrução preparada
                // Exibe mensagem de sucesso
                JOptionPane.showMessageDialog(null, "Agendado com sucesso!!!");
                limpar(); // Limpa os campos da tela
                preencherTabela(); // Atualiza a tabela de agendamentos
            }

        } catch (Exception e) { // Trata exceções
            // Exibe mensagem de erro se houver problemas ao inserir o agendamento
            JOptionPane.showMessageDialog(null, "inserir agendamento" + e);
        }

    }

    public void pesquisar(agendaDTO adto) { // Método para pesquisar um agendamento
        // Comando SQL para selecionar um agendamento específico
        String sql = "select * from agendas where idAgendamento = ?";
        conexao = conexaoDAO.conector(); // Estabelece conexão com o banco de dados

        try {
            pst = conexao.prepareStatement(sql); // Prepara a instrução SQL
            pst.setInt(1, adto.getIDclienteAgenda()); // Define o ID do cliente para pesquisa
            rs = pst.executeQuery(); // Executa a consulta

            if (rs.next()) { // Verifica se um resultado foi encontrado
                // Preenche os campos da tela com os dados do agendamento encontrado
                telaAgenda.txtNomeCliente.setText(rs.getString(2));
                telaAgenda.txtAreaConteudo.setText(rs.getString(3));
                telaAgenda.txtData.setText(rs.getString(4));
                telaAgenda.txtHora.setText(rs.getString(5));
            } else { // Se nenhum resultado for encontrado
                // Exibe mensagem informando que o agendamento não existe
                JOptionPane.showMessageDialog(null, "Este agendamento não existe!!!");
                limpar(); // Limpa os campos da tela
            }
        } catch (Exception e) { // Trata exceções
            // Exibe mensagem de erro se houver problemas na pesquisa
            JOptionPane.showMessageDialog(null, "método pesquisar" + e);
        }

    }

    public void excluir(agendaDTO adto) { // Método para excluir um agendamento
        // Comando SQL para deletar um agendamento
        String sql = "delete from agendas where idAgendamento = ?";
        conexao = new conexaoDAO().conector(); // Estabelece conexão com o banco de dados

        try {
            pst = conexao.prepareStatement(sql); // Prepara a instrução SQL
            pst.setInt(1, adto.getIDclienteAgenda()); // Define o ID do cliente para exclusão

            int add = pst.executeUpdate(); // Executa a exclusão
            if (add > 0) { // Verifica se a exclusão foi bem-sucedida
                conexao.close(); // Fecha a conexão com o banco de dados
                // Exibe mensagem de sucesso
                JOptionPane.showMessageDialog(null, "Agendamento deletado com sucesso!");
                limpar(); // Limpa os campos da tela
                preencherTabela(); // Atualiza a tabela de agendamentos
            }
        } catch (Exception e) { // Trata exceções
            // Exibe mensagem de erro se houver problemas na exclusão
            JOptionPane.showMessageDialog(null, "Método deletar agendamento" + e);
        }

    }

    public void editar(agendaDTO adto) { // Método para editar um agendamento
        // Comando SQL para atualizar um agendamento
        String sql = "update agendas set nomeCliente = ?, conteudo = ?, datas = ?, hora = ? where idAgendamento = ?";
        conexao = conexaoDAO.conector(); // Estabelece conexão com o banco de dados

        try {
            pst = conexao.prepareStatement(sql); // Prepara a instrução SQL
            pst.setInt(5, adto.getIDclienteAgenda()); // Define o ID do cliente para edição
            pst.setString(1, adto.getCliente()); // Define o nome do cliente
            pst.setString(2, adto.getConteudo()); // Define o conteúdo do agendamento
            // Converte a data do agendamento para o formato SQL
            java.sql.Date sqlDate = new java.sql.Date(adto.getData().getTime());
            pst.setDate(3, sqlDate); // Define a nova data do agendamento
            pst.setString(4, adto.getHora()); // Define a nova hora do agendamento

            int add = pst.executeUpdate(); // Executa a atualização
            if (add > 0) { // Verifica se a atualização foi bem-sucedida
                pst.close(); // Fecha a instrução preparada
                // Exibe mensagem de sucesso
                JOptionPane.showMessageDialog(null, "Agendamento editado com sucesso!!!");
                limpar(); // Limpa os campos da tela
                preencherTabela(); // Atualiza a tabela de agendamentos
            }
        } catch (Exception e) { // Trata exceções
            // Exibe mensagem de erro se houver problemas na edição
            JOptionPane.showMessageDialog(null, "Método editar " + e);
        }
    }

    public void limpar() { // Método para limpar os campos da tela
        telaAgenda.txtAreaConteudo.setText(null); // Limpa o campo de conteúdo
        telaAgenda.txtData.setText(null); // Limpa o campo de data
        telaAgenda.txtHora.setText(null); // Limpa o campo de hora
        telaAgenda.txtIdAgendamento.setText(null); // Limpa o campo de ID do agendamento
        telaAgenda.txtNomeCliente.setText(null); // Limpa o campo de nome do cliente
    }

    public void preencherTabela() { // Método para preencher a tabela com os agendamentos
        String sql = "select * from agendas"; // Comando SQL para selecionar todos os agendamentos
        conexao = conexaoDAO.conector(); // Estabelece conexão com o banco de dados

        try {
            pst = conexao.prepareStatement(sql); // Prepara a instrução SQL
            rs = pst.executeQuery(); // Executa a consulta

            // Obtém o modelo da tabela da interface gráfica
            DefaultTableModel model = (DefaultTableModel) telaAgenda.tabelaAgenda.getModel();
            model.setRowCount(0); // Limpa a tabela antes de adicionar novos dados

            // Adiciona cada agendamento retornado à tabela
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("idAgendamento"), // ID do agendamento
                    rs.getString("nomeCliente"), // Nome do cliente
                    rs.getString("conteudo"), // Conteúdo do agendamento
                    rs.getDate("datas"), // Data do agendamento
                    rs.getString("hora") // Hora do agendamento
                });
            }
        } catch (Exception e) { // Trata exceções
            // Exibe mensagem de erro se houver problemas ao preencher a tabela
            JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela: " + e);
        }
    }

} 
