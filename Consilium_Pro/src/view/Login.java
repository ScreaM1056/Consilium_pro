package view;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import modelo.Usuario;

/**
 * Tela de login para acesso ao sistema.
 */
public class Login extends JFrame {

    // Construtor recebe a lista de usuários cadastrados
    public Login(ArrayList<Usuario> usuarios) {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        // Campos de entrada para login e senha
        JLabel lblLogin = new JLabel("Login:");
        JTextField txtLogin = new JTextField();

        JLabel lblSenha = new JLabel("Senha:");
        JPasswordField txtSenha = new JPasswordField();

        // Botões de ação
        JButton btnEntrar = new JButton("Entrar");
        JButton btnVoltar = new JButton("Voltar");

        // Ação do botão Entrar
        btnEntrar.addActionListener(e -> {
            String login = txtLogin.getText().trim();
            String senha = new String(txtSenha.getPassword()).trim();

            // Verifica se o login e senha correspondem a algum usuário
            Usuario usuarioLogado = null;
            for (Usuario u : usuarios) {
                if (u.getLogin().equals(login) && u.getSenha().equals(senha)) {
                    usuarioLogado = u;
                    break;
                }
            }

            // Se encontrado, abre o painel principal
            if (usuarioLogado != null) {
                JOptionPane.showMessageDialog(this, "Bem-vindo, " + usuarioLogado.getNome());
                dispose();
                new PainelPrincipal(usuarioLogado, usuarios);
            } else {
                JOptionPane.showMessageDialog(this, "Login ou senha inválidos.");
            }
        });

        // Ação do botão Voltar para tela inicial
        btnVoltar.addActionListener(e -> {
            dispose();
            new TelaInicial();
        });

        // Adiciona os componentes à tela
        add(lblLogin); add(txtLogin);
        add(lblSenha); add(txtSenha);
        add(btnEntrar); add(btnVoltar);

        setLocationRelativeTo(null); // Centraliza a janela
        setVisible(true);
    }
}