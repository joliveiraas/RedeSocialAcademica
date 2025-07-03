package rede.controller;
import java.util.List;

public class Grafo {
    // atributos: listaAlunos, matrizAdj
    // operações:
    // 1.addAluno, 2.addDisciplina, 3. buscarAluno (Nataly)
    // 4.criarRede, 5. maisConectado, 6.sugerirAmigos, 7.grauAluno (Joana)
    // 8.listarAmigos, 9. verComunidade , 10.buscarCaminho, 11.parAlunos (JP)

    private List<Aluno> listaAlunos;
    private int[][] matrizAdj;

    public Grafo(List<Aluno> listaAlunos, int[][] matrizAdj) {
        this.listaAlunos = listaAlunos;
        this.matrizAdj = matrizAdj;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    public int[][] getMatrizAdj() {
        return matrizAdj;
    }

    public void setMatrizAdj(int[][] matrizAdj) {
        this.matrizAdj = matrizAdj;
    }


}
