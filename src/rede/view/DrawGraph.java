package rede.view;

import rede.controller.Grafo;
import rede.model.Aluno;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class DrawGraph extends JPanel {
    private Grafo grafo;
    private static final int RADIUS = 30;
    private static final int VERTEX_RADIUS = 22;

    public DrawGraph(Grafo grafo) {
        this.grafo = grafo;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (grafo == null || grafo.getListaAlunos().isEmpty()) return;

        int n = grafo.getListaAlunos().size();
        Point[] positions = new Point[n];

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int clusterRadius = 100;

        // Define os centros dos clusters por casa
        Map<String, Point> centros = new HashMap<>();
        centros.put("COMPUTACAO", new Point(centerX - 250, centerY - 150));
        centros.put("ELETRICA", new Point(centerX + 250, centerY - 150));
        centros.put("CIVIL", new Point(centerX - 250, centerY + 150));
        centros.put("MECANICA", new Point(centerX + 250, centerY + 150));
        centros.put("INDEFINIDO", new Point(centerX, centerY));


        // Agrupa alunos por curso
        Map<String, List<Integer>> comunidades = new HashMap<>();
        for (String curso : centros.keySet()) {
            comunidades.put(curso, new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            Aluno aluno = grafo.getListaAlunos().get(i);
            String curso = aluno.afinidadeCurso();
            if (!comunidades.containsKey(curso)) curso = "INDEFINIDO";  // fallback
            comunidades.get(curso).add(i);
        }

        // Posiciona os alunos em círculo dentro de cada cluster
        for (Map.Entry<String, List<Integer>> entry : comunidades.entrySet()) {
            List<Integer> indices = entry.getValue();
            Point centro = centros.get(entry.getKey());

            for (int j = 0; j < indices.size(); j++) {
                double angle = 2 * Math.PI * j / indices.size();
                int x = centro.x + (int) (clusterRadius * Math.cos(angle));
                int y = centro.y + (int) (clusterRadius * Math.sin(angle));
                positions[indices.get(j)] = new Point(x, y);
            }
        }

        // Desenha arestas com pesos
        Random rand = new Random(42);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int peso = grafo.getMatrizAdj()[i][j];
                if (peso != 0) {
                    g.setColor(new Color(180, 100, 255));
                    g.drawLine(positions[i].x, positions[i].y, positions[j].x, positions[j].y);

                    // Escreve o peso
                    int mx = (positions[i].x + positions[j].x) / 2;
                    int my = (positions[i].y + positions[j].y) / 2;
                    g.setColor(Color.MAGENTA);
                    g.setFont(new Font("Arial", Font.BOLD, 12));
                    g.drawString(String.valueOf(peso), mx, my);
                }
            }
        }

        // Desenha os vértices (alunos)
        for (int i = 0; i < n; i++) {
            Aluno aluno = grafo.getListaAlunos().get(i);
            String curso = aluno.afinidadeCurso();

            // Cor por casa
            switch (curso) {
                case "COMPUTACAO": g.setColor(Color.RED); break;
                case "ELETRICA": g.setColor(Color.GREEN); break;
                case "CIVIL": g.setColor(Color.BLUE); break;
                case "MECANICA": g.setColor(Color.ORANGE); break;
                default: g.setColor(Color.CYAN);
            }

            Point p = positions[i];
            g.fillOval(p.x - VERTEX_RADIUS / 2, p.y - VERTEX_RADIUS / 2, VERTEX_RADIUS, VERTEX_RADIUS);
            g.setColor(Color.BLACK);
            g.drawOval(p.x - VERTEX_RADIUS / 2, p.y - VERTEX_RADIUS / 2, VERTEX_RADIUS, VERTEX_RADIUS);

            // Nome do aluno
            String nome = aluno.getNome();
            FontMetrics fm = g.getFontMetrics();
            int textWidth = fm.stringWidth(nome);
            g.drawString(nome, p.x - textWidth / 2, p.y + VERTEX_RADIUS);
        }
    }

    public static void showGraph(Grafo grafo) {
        JFrame frame = new JFrame("Rede Social Acadêmica");
        DrawGraph panel = new DrawGraph(grafo);
        frame.add(panel);
        frame.setSize(1500, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
