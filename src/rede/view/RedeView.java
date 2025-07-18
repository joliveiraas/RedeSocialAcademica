package rede.view;

import rede.controller.Grafo;
import rede.model.Aluno;
import rede.uteis.ListaEncadeada;

import javax.swing.*;
import java.awt.*;


public class RedeView extends JPanel {
    private Grafo grafo;
    private static final int VERTEX_RADIUS = 22;

    public RedeView(Grafo grafo) {
        this.grafo = grafo;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (grafo == null || grafo.getListAlunos().isEmpty()) return;

        int n = grafo.getListAlunos().getTamanho();
        Point[] positions = new Point[n];
        ListaEncadeada<Aluno> alunos = grafo.getListAlunos();

        // Detecta comunidades com base em disciplinas
        ListaEncadeada<ListaEncadeada<Aluno>> comunidades = grafo.detectarComunidades(alunos);

        // Define posições circulares para cada comunidade
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int clusterSpacing = 200;
        int clusterRadius = 100;

        for (int c = 0; c < comunidades.getTamanho(); c++) {
            ListaEncadeada<Aluno> grupo = comunidades.get(c);

            // Define centro de cada cluster ao redor do centro
            double angle = 2 * Math.PI * c / comunidades.getTamanho();
            int cx = centerX + (int)(clusterSpacing * Math.cos(angle));
            int cy = centerY + (int)(clusterSpacing * Math.sin(angle));

            for (int i = 0; i < grupo.getTamanho(); i++) {
                Aluno aluno = grupo.get(i);
                int idx = alunos.indexOf(aluno);

                double theta = 2 * Math.PI * i / grupo.getTamanho();
                int x = cx + (int)(clusterRadius * Math.cos(theta));
                int y = cy + (int)(clusterRadius * Math.sin(theta));
                positions[idx] = new Point(x, y);
            }
        }

        // Posição aleatória para alunos sem comunidade
        for (int i = 0; i < n; i++) {
            if (positions[i] == null) {
                int x = centerX + (int)(Math.random() * 300 - 150);
                int y = centerY + (int)(Math.random() * 300 - 150);
                positions[i] = new Point(x, y);
            }
        }

        // Arestas
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int peso = grafo.getMatrizAdj()[i][j];
                if (peso != 0) {
                    g.setColor(new Color(180, 100, 255));
                    g.drawLine(positions[i].x, positions[i].y, positions[j].x, positions[j].y);

                    // Peso
                    int mx = (positions[i].x + positions[j].x) / 2;
                    int my = (positions[i].y + positions[j].y) / 2;
                    g.setColor(Color.MAGENTA);
                    g.setFont(new Font("Arial", Font.BOLD, 12));
                    g.drawString(String.valueOf(peso), mx, my);
                }
            }
        }

        // Cores diferentes por comunidade
        Color[] cores = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE, Color.PINK, Color.CYAN, Color.YELLOW};

        // Vértices
        for (int i = 0; i < n; i++) {
            Point p = positions[i];
            int corIndex = comunidadeDoAluno(comunidades, i, alunos);
            g.setColor(cores[corIndex % cores.length]);
            g.fillOval(p.x - VERTEX_RADIUS / 2, p.y - VERTEX_RADIUS / 2, VERTEX_RADIUS, VERTEX_RADIUS);
            g.setColor(Color.BLACK);
            g.drawOval(p.x - VERTEX_RADIUS / 2, p.y - VERTEX_RADIUS / 2, VERTEX_RADIUS, VERTEX_RADIUS);

            String nome = alunos.get(i).getNome();
            FontMetrics fm = g.getFontMetrics();
            int textWidth = fm.stringWidth(nome);
            g.drawString(nome, p.x - textWidth / 2, p.y + VERTEX_RADIUS);
        }
    }

    // Comunidade do aluno para escolher cor
    private int comunidadeDoAluno(ListaEncadeada<ListaEncadeada<Aluno>> comunidades, int alunoIndex, ListaEncadeada<Aluno> todosAlunos) {
        Aluno aluno = todosAlunos.get(alunoIndex);
        for (int i = 0; i < comunidades.getTamanho(); i++) {
            if (comunidades.get(i).contem(aluno)) {
                return i;
            }
        }
        return comunidades.getTamanho();
    }

    public static void showGraph(Grafo grafo) {
       // JFrame frame = new JFrame("Rede Social Acadêmica");
        JDialog dialog = new JDialog((Frame)  null, "Rede Social Acadêmica", null);
        RedeView panel = new RedeView(grafo);
        dialog.add(panel);
        dialog.setSize(1366, 768);
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }
}

