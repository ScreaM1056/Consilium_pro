package modelo;

import java.util.ArrayList;

/**
 * Representa uma equipe com nome, descrição e lista de membros.
 */
public class Equipe {
    private String nome;
    private String descricao;
    private ArrayList<Usuario> membros;

    // Construtor que define nome e descrição da equipe
    public Equipe(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.membros = new ArrayList<>();
    }

    // Retorna o nome da equipe
    public String getNome() { return nome; }

    // Retorna a descrição da equipe
    public String getDescricao() { return descricao; }

    // Retorna a lista de membros
    public ArrayList<Usuario> getMembros() { return membros; }

    // Adiciona um usuário à equipe
    public void adicionarMembro(Usuario usuario) {
        membros.add(usuario);
    }

    // Mostra os dados da equipe em formato de texto
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Equipe: " + nome + "\nDescrição: " + descricao + "\nMembros:\n");
        for (Usuario u : membros) {
            sb.append("- ").append(u.getNome()).append(" (").append(u.getPerfil()).append(")\n");
        }
        return sb.toString();
    }
}


