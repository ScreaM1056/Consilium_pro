package modelo;

/**
 * Representa um usuário do sistema com dados pessoais e perfil de acesso.
 */
public class Usuario {
    // Atributos do usuário
    private String nome;
    private String cpf;
    private String email;
    private String cargo;
    private String login;
    private String senha;
    private String perfil; // Pode ser "Admin", "Gerente" ou "Colaborador"

    // Construtor que define os dados do usuário
    public Usuario(String nome, String cpf, String email, String cargo, String login, String senha, String perfil) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.cargo = cargo;
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
    }

    // Retorna o nome do usuário
    public String getNome() { return nome; }

    // Retorna o CPF
    public String getCpf() { return cpf; }

    // Retorna o email
    public String getEmail() { return email; }

    // Retorna o cargo
    public String getCargo() { return cargo; }

    // Retorna o login
    public String getLogin() { return login; }

    // Retorna a senha
    public String getSenha() { return senha; }

    // Retorna o perfil
    public String getPerfil() { return perfil; }

    // Mostra os dados principais do usuário em formato de texto
    @Override
    public String toString() {
        return nome + " (" + perfil + ") - " + email;
    }
}