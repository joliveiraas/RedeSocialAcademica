package rede;

import rede.controller.Grafo;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        Grafo grafo = new Grafo();

        //Adicionadno alunos
        grafo.addAluno("ABC", "123");
        grafo.addAluno("DEF", "456");

        //Teste dos Alunos

        for(int i = 0; i < grafo.getListaAlunos().size() ; i++){
            System.out.print(grafo.getListaAlunos().get(i).getNome() + "  ");
        }
        //Adicionando disciplinas
        grafo.addDisciplina("123", "MEC", "987");
        grafo.addDisciplina("123", "C4", "677");
        grafo.addDisciplina("123", "CD", "087");

        //Teste
        System.out.println(grafo.getListaAlunos().get(0).getListaDisciplinas().get(0).getNome());
        System.out.println(grafo.getListaAlunos().get(0).getListaDisciplinas().get(1).getNome());
        System.out.println(grafo.getListaAlunos().get(0).getListaDisciplinas().get(2).getNome());


    }
}