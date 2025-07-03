// Arquivo: DrawGraph.java
package rede.view;

import rede.model.Aluno;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class DrawGraph extends JPanel {
    private ArrayList<Aluno> alunos;
    private int[][] matrizAdj;
    private static final int VERTEX_RADIUS_MIN = 25;
    private static final int VERTEX_RADIUS_MAX = 50;
    private static final int PADDING = 80;

    public DrawGraph(ArrayList<Aluno> alunos, int[][] matrizAdj) {
        this.alunos = alunos;
        this.matrizAdj = matrizAdj;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (alunos == null || alunos.isEmpty()) return;

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int n = alunos.size();
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int maxRadius = Math.min(centerX, centerY) - PADDING;
        int minRadius = 100;
        Point[] points = new Point[n];

        // Calcula grau de cada aluno
        int[] graus = new int[n];
        int grauMax = 1;
        for (int i = 0; i < n; i++) {
            int grau = 0;
            for (int j = 0; j < n; j++) {
                if (matrizAdj[i][j] > 0) grau += matrizAdj[i][j];
            }
            graus[i] = grau;
            if (grau > grauMax) grauMax = grau;
        }

        // Posiciona os alunos em círculo com distância radial proporcional ao grau
        for (int i = 0; i < n; i++) {
            double angle = 2 * Math.PI * i / n;
            double rel = (double) graus[i] / grauMax;
            int radius = (int) (maxRadius - rel * (maxRadius - minRadius));
            int x = centerX + (int) (radius * Math.cos(angle));
            int y = centerY + (int) (radius * Math.sin(angle));
            points[i] = new Point(x, y);
        }

        // Desenha as arestas com cor e peso
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int peso = matrizAdj[i][j];
                if (peso > 0) {
                    g2d.setColor(new Color(200, 100, 255));
                    g2d.setStroke(new BasicStroke(1 + peso));
                    g2d.drawLine(points[i].x, points[i].y, points[j].x, points[j].y);

                    // Desenha peso

                    g2d.setFont(new Font("Arial", Font.BOLD, 14)); // Tamanho 14 em negrito
                    g2d.setColor(Color.BLACK); // Cor preta para o peso

                    int mx = (points[i].x + points[j].x) / 2;
                    int my = (points[i].y + points[j].y) / 2;
                    g2d.drawString(String.valueOf(matrizAdj[i][j]), mx, my);

                }
            }
        }

        // Desenha os vértices (alunos)
        for (int i = 0; i < n; i++) {
            double rel = (double) graus[i] / grauMax;
            int raio = (int)(VERTEX_RADIUS_MIN + rel * (VERTEX_RADIUS_MAX - VERTEX_RADIUS_MIN));

            g2d.setColor(new Color(100, 255, 255));
            Ellipse2D.Double circle = new Ellipse2D.Double(points[i].x - raio / 2, points[i].y - raio / 2, raio, raio);
            g2d.fill(circle);
            g2d.setColor(Color.BLACK);
            g2d.draw(circle);

            // Nome do aluno
            String nome = alunos.get(i).getNome();
            FontMetrics fm = g2d.getFontMetrics();
            int textWidth = fm.stringWidth(nome);
            g2d.drawString(nome, points[i].x - textWidth / 2, points[i].y + raio / 2 + 15);
        }
    }

    public static void showGraph(ArrayList<Aluno> alunos, int[][] matrizAdj) {
        JFrame frame = new JFrame("Rede Social Acadêmica");
        DrawGraph panel = new DrawGraph(alunos, matrizAdj);
        frame.add(panel);
        frame.setSize(900, 900);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
