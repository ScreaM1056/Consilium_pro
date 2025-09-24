package view;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import modelo.Usuario;

/**
 * Tela para cadastrar um novo usuário.
 */
public class CadastroUsuario extends JFrame {

    // Construtor recebe a lista de usuários já cadastrados
    public CadastroUsuario(ArrayList<Usuario> usuarios) {
        setTitle("Cadastro de Usuário");
        setSize(400, 320);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(9, 2));

        // Campos de entrada
        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField();

        JLabel lblCpf = new JLabel("CPF:");
        JTextField txtCpf = new JTextField();

        JLabel lblEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField();

        JLabel lblCargo = new JLabel("Cargo:");
        JTextField txtCargo = new JTextField();

        JLabel lblLogin = new JLabel("Login:");
        JTextField txtLogin = new JTextField();

        JLabel lblSenha = new JLabel("Senha:");
        JPasswordField txtSenha = new JPasswordField();

        JLabel lblPerfil = new JLabel("Perfil:");
        String[] perfis = {"Admin", "Gerente", "Colaborador"};
        JComboBox<String> comboPerfil = new JComboBox<>(perfis);

        // Botões de ação
        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnVoltar = new JButton("Voltar");

        // Ação do botão Cadastrar
        btnCadastrar.addActionListener(e -> {
            String nome = txtNome.getText().trim();
            String cpf = txtCpf.getText().trim();
            String email = txtEmail.getText().trim();
            String cargo = txtCargo.getText().trim();
            String login = txtLogin.getText().trim();
            String senha = new String(txtSenha.getPassword()).trim();
            String perfil = comboPerfil.getSelectedItem().toString();

            // Verifica se todos os campos foram preenchidos
            if (nome.isEmpty() || cpf.isEmpty() || email.isEmpty() || cargo.isEmpty() || login.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos.");
                return;
            }

            // Cria o usuário e adiciona à lista
            Usuario usuario = new Usuario(nome, cpf, email, cargo, login, senha, perfil);
            usuarios.add(usuario);
            JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso:\n" + usuario.toString());

            // Fecha a tela e abre a tela de login
            dispose();
            new Login(usuarios);
        });

        // Ação do botão Voltar para tela inicial
        btnVoltar.addActionListener(e -> {
            dispose();
            new TelaInicial();
        });

        // Adiciona os componentes à tela
        add(lblNome); add(txtNome);
        add(lblCpf); add(txtCpf);
        add(lblEmail); add(txtEmail);
        add(lblCargo); add(txtCargo);
        add(lblLogin); add(txtLogin);
        add(lblSenha); add(txtSenha);
        add(lblPerfil); add(comboPerfil);
        add(btnCadastrar); add(btnVoltar);

        setLocationRelativeTo(null); // Centraliza a janela
        setVisible(true);
    }
}