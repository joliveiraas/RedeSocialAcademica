package rede.controller;
import rede.model.Aluno;
import rede.model.Disciplina;

import java.util.ArrayList;


public class Grafo {
    // atributos: listaAlunos, matrizAdj
    // operações:
    // 1.addAluno, 2.addDisciplina, 3. buscarAluno (Nataly)
    // 4.criarRede, 5. maisConectado, 6.sugerirAmigos, 7.grauAluno (Joana)
    // 8.listarAmigos, 9. verComunidade , 10.buscarCaminho, 11.parAlunos (JP)

    private ArrayList<Aluno> listaAlunos;
    private int[][] matrizAdj;

    public Grafo() {
        this.listaAlunos = new ArrayList<>();
        this.matrizAdj = new int[0][0];
    }

    public void addAluno(String nome, String matricula){
        Aluno novoAluno = new Aluno(nome, matricula);
        getListaAlunos().add(novoAluno);
    }

    public void addDisciplina(String matricula, String nomeDisciplina, String codigo){
        Disciplina novaDisciplina = new Disciplina(nomeDisciplina, codigo);
        for(Aluno a : getListaAlunos()){
            if(a.getMatricula().equals(matricula)){
                a.getListaDisciplinas().add(novaDisciplina);
            }
        }
    }

    public ArrayList<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(ArrayList<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    public int[][] getMatrizAdj() {
        return matrizAdj;
    }

    public void setMatrizAdj(int[][] matrizAdj) {
        this.matrizAdj = matrizAdj;
    }


}