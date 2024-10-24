package br.com.DTO; 
public class usuarioDTO {
    
    // Atributos da classe que representam as informações do usuário
    private int idUsuario; // ID do usuário
    private String nomeUsuario; // Nome do usuário
    private String loginUsuario; // Login do usuário
    private String emailUsuario; // E-mail do usuário
    private String senhaUsuario; // Senha do usuário

    // Métodos getter e setter para acessar e modificar os atributos

    public int getIdUsuario() {
        return idUsuario; // Retorna o ID do usuário
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario; // Define o ID do usuário
    }

    public String getNomeUsuario() {
        return nomeUsuario; // Retorna o nome do usuário
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario; // Define o nome do usuário
    }

    public String getLoginUsuario() {
        return loginUsuario; // Retorna o login do usuário
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario; // Define o login do usuário
    }

    public String getEmailUsuario() {
        return emailUsuario; // Retorna o e-mail do usuário
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario; // Define o e-mail do usuário
    }

    public String getSenhaUsuario() {
        return senhaUsuario; // Retorna a senha do usuário
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario; // Define a senha do usuário
    }
}
