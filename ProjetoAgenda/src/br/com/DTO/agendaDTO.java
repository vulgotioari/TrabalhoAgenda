package br.com.DTO; 

import java.util.Date; // Importa a classe Date para manipulação de datas
import javax.swing.table.DefaultTableModel; // Importa a classe para manipulação de tabelas

public class agendaDTO {
    private int IDclienteAgenda; // ID do cliente na agenda
    private String cliente; // Nome do cliente
    private String conteudo; // Conteúdo da agenda (descrição do compromisso)
    private Date data; // Data do compromisso
    private String hora; // Hora do compromisso

    // Métodos getter e setter para acessar e modificar os atributos

    public int getIDclienteAgenda() {
        return IDclienteAgenda; // Retorna o ID do cliente na agenda
    }

    public void setIDclienteAgenda(int IDclienteAgenda) {
        this.IDclienteAgenda = IDclienteAgenda; // Define o ID do cliente na agenda
    }

    public String getCliente() {
        return cliente; // Retorna o nome do cliente
    }

    public void setCliente(String cliente) {
        this.cliente = cliente; // Define o nome do cliente
    }

    public String getConteudo() {
        return conteudo; // Retorna o conteúdo da agenda
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo; // Define o conteúdo da agenda
    }

    public Date getData() {
        return data; // Retorna a data do compromisso
    }

    public void setData(Date data) {
        this.data = data; // Define a data do compromisso
    }

    public String getHora() {
        return hora; // Retorna a hora do compromisso
    }

    public void setHora(String hora) {
        this.hora = hora; // Define a hora do compromisso
    }
}
