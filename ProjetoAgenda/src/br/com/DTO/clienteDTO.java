package br.com.DTO; // Pacote onde a classe está localizada

public class clienteDTO {
    // Atributos da classe que representam as informações do cliente
    int idClientes; // ID do cliente
    String nomeClientes; // Nome do cliente
    String enderecoClientes; // Endereço do cliente
    String telefoneClientes; // Telefone do cliente
    String emailClientes; // E-mail do cliente
    String cpf_cnpjClientes; // CPF ou CNPJ do cliente

    // Métodos getter e setter para acessar e modificar os atributos

    public int getIdClientes() {
        return idClientes; // Retorna o ID do cliente
    }

    public void setIdClientes(int idClientes) {
        this.idClientes = idClientes; // Define o ID do cliente
    }

    public String getNomeClientes() {
        return nomeClientes; // Retorna o nome do cliente
    }

    public void setNomeClientes(String nomeClientes) {
        this.nomeClientes = nomeClientes; // Define o nome do cliente
    }

    public String getEnderecoClientes() {
        return enderecoClientes; // Retorna o endereço do cliente
    }

    public void setEnderecoClientes(String enderecoClientes) {
        this.enderecoClientes = enderecoClientes; // Define o endereço do cliente
    }

    public String getTelefoneClientes() {
        return telefoneClientes; // Retorna o telefone do cliente
    }

    public void setTelefoneClientes(String telefoneClientes) {
        this.telefoneClientes = telefoneClientes; // Define o telefone do cliente
    }

    public String getEmailClientes() {
        return emailClientes; // Retorna o e-mail do cliente
    }

    public void setEmailClientes(String emailClientes) {
        this.emailClientes = emailClientes; // Define o e-mail do cliente
    }

    public String getCpf_cnpjClientes() {
        return cpf_cnpjClientes; // Retorna o CPF ou CNPJ do cliente
    }

    public void setCpf_cnpjClientes(String cpf_cnpjClientes) {
        this.cpf_cnpjClientes = cpf_cnpjClientes; // Define o CPF ou CNPJ do cliente
    }
}
