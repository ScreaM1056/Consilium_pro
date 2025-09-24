package view;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import modelo.Equipe;
import modelo.Usuario;

/**
 * Tela para cadastrar uma nova equipe.
 */
public class CadastroEquipe extends JFrame {

    // Lista estática que armazena todas as equipes cadastradas
    public static ArrayList<Equipe> equipes = new ArrayList<>();

    // Construtor que recebe a lista de usuários disponíveis
    public CadastroEquipe(ArrayList<Usuario> usuarios) {
        setTitle("Cadastro de Equipe");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        // Campo para nome da equipe
        JLabel lblNome = new JLabel("Nome da Equipe:");
        JTextField txtNome = new JTextField();

        // Campo para selecionar o responsável pela equipe
        JLabel lblResponsavel = new JLabel("Responsável:");
        JComboBox<String> comboResponsavel = new JComboBox<>();
        for (Usuario u : usuarios) {
            comboResponsavel.addItem(u.getNome());
        }

        // Botões de ação
        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnVoltar = new JButton("Voltar");

        // Ação do botão Cadastrar
        btnCadastrar.addActionListener(e -> {
            String nome = txtNome.getText().trim();
            String responsavel = (String) comboResponsavel.getSelectedItem();

            // Validação dos campos
            if (nome.isEmpty() || responsavel == null) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
                return;
            }

            // Criação da equipe e adição à lista
            Equipe equipe = new Equipe(nome, responsavel);
            equipes.add(equipe);
            JOptionPane.showMessageDialog(this, "Equipe cadastrada com sucesso!");

            // Fecha a tela e volta para a tela inicial
            dispose();
            new TelaInicial();
        });

        // Ação do botão Voltar
        btnVoltar.addActionListener(e -> {
            dispose();
            new TelaInicial();
        });

        // Adiciona os componentes à tela
        add(lblNome); add(txtNome);
        add(lblResponsavel); add(comboResponsavel);
        add(btnCadastrar); add(btnVoltar);

        setLocationRelativeTo(null); // Centraliza a janela
        setVisible(true);
    }
}