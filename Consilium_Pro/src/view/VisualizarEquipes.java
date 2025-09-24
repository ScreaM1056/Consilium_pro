package view;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import modelo.Equipe;

/**
 * Tela para visualizar todas as equipes cadastradas.
 */
public class VisualizarEquipes extends JFrame {

    // Construtor recebe a lista de equipes
    public VisualizarEquipes(ArrayList<Equipe> equipes) {
        setTitle("Equipes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Área de texto para exibir as equipes
        JTextArea area = new JTextArea();
        for (Equipe e : equipes) {
            area.append(e.toString() + "\n\n");
        }
        area.setEditable(false); // impede edição
        add(new JScrollPane(area), BorderLayout.CENTER); // adiciona com rolagem

        // Botão para voltar à tela inicial
        JButton btnVoltar = new JButton("Voltar para Tela Inicial");
        btnVoltar.addActionListener(e -> {
            dispose();
            new TelaInicial();
        });
        add(btnVoltar, BorderLayout.SOUTH);

        setLocationRelativeTo(null); // centraliza a janela
        setVisible(true);
    }
}