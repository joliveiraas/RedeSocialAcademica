package rede;

import rede.controller.Grafo;
import rede.model.Disciplina;
import rede.model.Aluno;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Grafo rede = new Grafo();

        // Lista de alunos fictícios com personagens de Harry Potter
        Aluno[] alunos = {
                new Aluno("Harry Potter", "2023001"),
                new Aluno("Hermione Granger", "2023002"),
                new Aluno("Ron Weasley", "2023003"),
                new Aluno("Draco Malfoy", "2023004"),
                new Aluno("Luna Lovegood", "2023005"),
                new Aluno("Neville Longbottom", "2023006"),
                new Aluno("Ginny Weasley", "2023007"),
                new Aluno("Cho Chang", "2023008"),
                new Aluno("Cedric Diggory", "2023009"),
                new Aluno("Severus Snape", "2023010"),
                new Aluno("Sirius Black", "2023011"),
                new Aluno("Remus Lupin", "2023012"),
                new Aluno("Minerva McGonagall", "2023013"),
                new Aluno("Albus Dumbledore", "2023014"),
                new Aluno("Rubeus Hagrid", "2023015"),
                new Aluno("Bellatrix Lestrange", "2023016"),
                new Aluno("Lucius Malfoy", "2023017"),
                new Aluno("Dolores Umbridge", "2023018"),
                new Aluno("Horace Slughorn", "2023019"),
                new Aluno("Lord Voldemort", "2023020")
        };

        // Lista de disciplinas da faculdade
        Disciplina[] disciplinas = Disciplina.getTodasDisciplinas();

        // Atribuir disciplinas aleatórias (5 disciplinas por aluno)
        for (int i = 0; i < alunos.length; i++) {
            Aluno aluno = alunos[i];
            List<Disciplina> disciplinasAluno = Arrays.asList(
                    disciplinas[(i * 3) % disciplinas.length],
                    disciplinas[(i * 3 + 1) % disciplinas.length],
                    disciplinas[(i * 3 + 2) % disciplinas.length],
                    disciplinas[(i * 3 + 3) % disciplinas.length],
                    disciplinas[(i * 3 + 4) % disciplinas.length]
            );
            aluno.setListaDisciplinas(disciplinasAluno);
            rede.addAluno(aluno.getNome(), aluno.getMatricula());
        }

        Aluno harry = rede.getListaAlunos().getFirst();
        for (Disciplina d: harry.getListaDisciplinas()){
            System.out.println(d);
        }

    }



}