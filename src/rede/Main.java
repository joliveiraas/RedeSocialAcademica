package rede;

import rede.controller.Grafo;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        Grafo grafo = new Grafo();

        //Adicionadno alunos
        grafo.addAluno("ABC", "123");
        grafo.addAluno("DEF", "456");
        grafo.addAluno("XYZ", "126");

        //Adicionando disciplinas
        grafo.addDisciplina("123", "MEC", "987");
        grafo.addDisciplina("456", "MEC", "987");
        grafo.addDisciplina("123", "C2", "444");
        grafo.addDisciplina("456", "C2", "444");
        grafo.addDisciplina("126", "MEC", "987");

            // ABC e DEF 2 disciplinas e XYZ tem 1 em comum
        grafo.criarRede();

        grafo.imprimirMatriz();



    }
}