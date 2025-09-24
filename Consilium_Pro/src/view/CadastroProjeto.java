package view;

import javax.swing.*;
import java.awt.*;
import modelo.Projeto;
import modelo.Usuario;
import java.util.ArrayList;

/**
 * Tela para cadastrar um novo projeto.
 */
public class CadastroProjeto extends JFrame {

    // Lista de projetos cadastrados
    public static ArrayList<Projeto> projetos = new ArrayList<>();

    // Construtor recebe o gerente responsável pelo projeto
    public CadastroProjeto(Usuario gerente) {
        setTitle("Cadastro de Projeto");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        // Campos de entrada
        JLabel lblNome = new JLabel("Nome do Projeto:");
        JTextField txtNome = new JTextField();

        JLabel lblDescricao = new JLabel("Descrição:");
        JTextField txtDescricao = new JTextField();

        // Botões
        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnVoltar = new JButton("Voltar");

        // Ação do botão Cadastrar
        btnCadastrar.addActionListener(e -> {
            String nome = txtNome.getText().trim();
            String descricao = txtDescricao.getText().trim();

            // Verifica se os campos foram preenchidos
            if (nome.isEmpty() || descricao.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
                return;
            }

            // Cria o projeto e adiciona à lista
            Projeto projeto = new Projeto(nome, descricao, gerente);
            projetos.add(projeto);
            JOptionPane.showMessageDialog(this, "Projeto cadastrado com sucesso!");

            // Fecha a tela e volta para o painel principal
            dispose();
            new PainelPrincipal(gerente, null); // pode passar a lista de usuários se necessário
        });

        // Ação do botão Voltar
        btnVoltar.addActionListener(e -> {
            dispose();
            new TelaInicial();
        });

        // Adiciona os componentes à tela
        add(lblNome); add(txtNome);
        add(lblDescricao); add(txtDescricao);
        add(btnCadastrar); add(btnVoltar);

        setLocationRelativeTo(null); // Centraliza a janela
        setVisible(true);
    }
}