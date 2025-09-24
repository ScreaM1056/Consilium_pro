package view;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import modelo.Usuario;

/**
 * Tela principal exibida após o login, com opções diferentes para cada perfil.
 */
public class PainelPrincipal extends JFrame {

    // Construtor recebe o usuário logado e a lista de usuários
    public PainelPrincipal(Usuario usuario, ArrayList<Usuario> usuarios) {
        setTitle("Painel - " + usuario.getPerfil());
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Mensagem de boas-vindas
        JLabel lblBoasVindas = new JLabel("Olá, " + usuario.getNome() + " (" + usuario.getPerfil() + ")");
        lblBoasVindas.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(lblBoasVindas);

        // Exibe opções conforme o perfil do usuário
        switch (usuario.getPerfil()) {
            case "Admin":
                // Botão para cadastrar novo usuário
                JButton btnCadastrarUsuario = new JButton("Cadastrar Usuário");
                btnCadastrarUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
                btnCadastrarUsuario.addActionListener(e -> new CadastroUsuario(usuarios));
                add(btnCadastrarUsuario);

                // Botão para visualizar todos os usuários
                JButton btnVisualizarUsuarios = new JButton("Visualizar Usuários");
                btnVisualizarUsuarios.setAlignmentX(Component.CENTER_ALIGNMENT);
                btnVisualizarUsuarios.addActionListener(e -> {
                    StringBuilder sb = new StringBuilder("Usuários cadastrados:\n");
                    for (Usuario u : usuarios) {
                        sb.append(u.toString()).append("\n");
                    }
                    JOptionPane.showMessageDialog(this, sb.toString());
                });
                add(btnVisualizarUsuarios);
                break;

            case "Gerente":
                // Botão para cadastrar novo projeto
                JButton btnCadastrarProjeto = new JButton("Cadastrar Projeto");
                btnCadastrarProjeto.setAlignmentX(Component.CENTER_ALIGNMENT);
                btnCadastrarProjeto.addActionListener(e -> new CadastroProjeto(usuario));
                add(btnCadastrarProjeto);

                // Botão para cadastrar nova equipe
                JButton btnCadastrarEquipe = new JButton("Cadastrar Equipe");
                btnCadastrarEquipe.setAlignmentX(Component.CENTER_ALIGNMENT);
                btnCadastrarEquipe.addActionListener(e -> new CadastroEquipe(usuarios));
                add(btnCadastrarEquipe);
                break;

            case "Colaborador":
                // Botão para visualizar projetos disponíveis
                JButton btnVisualizarProjetos = new JButton("Visualizar Projetos");
                btnVisualizarProjetos.setAlignmentX(Component.CENTER_ALIGNMENT);
                btnVisualizarProjetos.addActionListener(e -> {
                    StringBuilder sb = new StringBuilder("Projetos disponíveis:\n");
                    for (var p : CadastroProjeto.projetos) {
                        sb.append(p.toString()).append("\n\n");
                    }
                    JOptionPane.showMessageDialog(this, sb.toString());
                });
                add(btnVisualizarProjetos);
                break;
        }

        // Botão para voltar à tela inicial
        JButton btnVoltar = new JButton("Voltar para Tela Inicial");
        btnVoltar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnVoltar.addActionListener(e -> {
            dispose();
            new TelaInicial();
        });
        add(Box.createVerticalStrut(10)); // espaço extra
        add(btnVoltar);

        setLocationRelativeTo(null); // Centraliza a janela
        setVisible(true);
    }
}