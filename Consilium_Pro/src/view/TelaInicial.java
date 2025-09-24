package view;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import modelo.Usuario;

/**
 * Tela inicial do sistema, com opções de login e cadastro.
 */
public class TelaInicial extends JFrame {

    // Lista de usuários cadastrados
    public static ArrayList<Usuario> usuarios = new ArrayList<>();

    // Construtor da tela inicial
    public TelaInicial() {
        setTitle("Consilium_pro - Início");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        // Título centralizado
        JLabel lblTitulo = new JLabel("Bem-vindo ao Consilium_pro", SwingConstants.CENTER);

        // Botões de ação
        JButton btnLogin = new JButton("Login");
        JButton btnCadastrar = new JButton("Cadastrar");

        // Ação do botão Login
        btnLogin.addActionListener(e -> new Login(usuarios));

        // Ação do botão Cadastrar
        btnCadastrar.addActionListener(e -> new CadastroUsuario(usuarios));

        // Adiciona os componentes à tela
        add(lblTitulo);
        add(btnLogin);
        add(btnCadastrar);

        setLocationRelativeTo(null); // Centraliza a janela
        setVisible(true);
    }
}