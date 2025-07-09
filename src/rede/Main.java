package rede;

import rede.controller.Grafo;
import rede.model.Aluno;
import rede.model.Disciplina;
import rede.uteis.ListaEncadeada;
import rede.view.RedeView;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Grafo rede = new Grafo();

        Disciplina[] bcet = Disciplina.BCET;
        Disciplina[] mec = Disciplina.MECANICA;
        Disciplina[] civil = Disciplina.CIVIL;
        Disciplina[] eletrica = Disciplina.ELETRICA;
        Disciplina[] computacao = Disciplina.COMPUTACAO;

        Aluno[] alunos = {
                new Aluno("Harry Potter", "2023001"),
                new Aluno("Hermione Granger", "2023002"),
                new Aluno("Ron Weasley", "2023003"),
                new Aluno("Draco Malfoy", "2023004"),
                new Aluno("Luna Lovegood", "2023005"),
                new Aluno("Neville Longbottom", "2023006"),
                new Aluno("Ginny Weasley", "2023007"),
                new Aluno("Dean Thomas", "2023010"),
                new Aluno("Pansy Parkinson", "2023015"),
                new Aluno("Susan Bones", "2023019"),
                new Aluno("Terry Boot", "2023020")
        };
//  -------------------------------------------------- CRIA REDE -------------------------------------------------------

        // Sorteia 5 disciplinas únicas do BCET para cada aluno
        for (int i = 0; i < alunos.length; i++) {
            Aluno aluno = alunos[i];
            rede.addAluno(aluno.getNome(), aluno.getMatricula());
            Random rand = new Random(i * 31); // semente diferente para cada aluno

            while(rede.getListAlunos().get(i).getListaDisciplinas().getTamanho() < 5){
                int idx = rand.nextInt(bcet.length);
                Disciplina d = bcet[idx];
                if(!aluno.getListaDisciplinas().contem(d)){
                    rede.addDisciplina(aluno.getMatricula(), aluno.getNome(), d.getCodigo());
                }
            }
        }

        // Sorteia 15 disciplinas de terminalidade para cada aluno
        for (int i = 0; i < alunos.length; i++) {
            Aluno aluno = alunos[i];

            ListaEncadeada<Disciplina> disciplinasAluno = new ListaEncadeada<>();
            Disciplina[] conjunto;

            // Computação
            if (aluno.getNome().equals("Harry Potter") || aluno.getNome().equals("Hermione Granger") || aluno.getNome().equals("Ron Weasley")) {
                conjunto = computacao;
            }
            // Elétrica
            else if (aluno.getNome().equals("Draco Malfoy") || aluno.getNome().equals("Pansy Parkinson") || aluno.getNome().equals("Susan Bones")) {
                conjunto = eletrica;
            }
            // Civil
            else if (aluno.getNome().equals("Luna Lovegood") || aluno.getNome().equals("Dean Thomas") || aluno.getNome().equals("Terry Boot")) {
                conjunto = civil;
            }
            // Mecânica
            else {
                conjunto = mec;
            }

            ListaEncadeada<Integer> indicesUsados = new ListaEncadeada<>();
            Random rand = new Random(i * 31); // semente diferente para cada aluno

            while (disciplinasAluno.getTamanho() < 15) {
                int idx = rand.nextInt(conjunto.length);
                if (!indicesUsados.contem(idx)) {
                    disciplinasAluno.adiciona(conjunto[idx]);
                    indicesUsados.adiciona(idx);
                }
            }

            // Adiciona as disciplinas ao aluno
            for (Disciplina d : disciplinasAluno) {
                rede.addDisciplina(aluno.getMatricula(), d.getNome(), d.getCodigo());
            }
        }

        rede.criarRede();

        // Verificando alunos e suas disciplinas
        for(int i = 0; i < rede.getListAlunos().getTamanho(); i++){
            Aluno aluno = rede.getListAlunos().get(i);
            System.out.println("========== " + aluno.getNome() + " ==========");
            System.out.println(aluno);
            ListaEncadeada<Disciplina> disciplinasAluno = rede.getListAlunos().get(i).getListaDisciplinas();

            for(int j = 0; j < disciplinasAluno.getTamanho(); j++){
                System.out.println(disciplinasAluno.get(j));
            }
        }

        // Adiciona um aluno novo, com apenas 1 disciplina
        Aluno teste = new Aluno("Joana","xxxxxx");
        rede.addAluno(teste.getNome(), teste.getMatricula());
        rede.addDisciplina(teste.getMatricula(), bcet[1].getNome(), bcet[1].getCodigo());

        rede.criarRede();
        RedeView.showGraph(rede);

//  -------------------------------------------------- TESTES ----------------------------------------------------------
//        rede.grauAluno("Dobby");
//        rede.grauAluno("Harry Potter");
//        rede.alunoMaisConectado();
//        System.out.println();
        System.out.println("Buscando caminho entre Luna Lovegood e Ron Weasley:");
        rede.buscarCaminho("Luna Lovegood", "Ron Weasley");
//
//        System.out.println("Buscando caminho entre Luna Lovegood e Remus Lupin:");
//        rede.buscarCaminho("Luna Lovegood", "Remus Lupin");

        Aluno test = rede.getListAlunos().get(4);

        ListaEncadeada<Aluno> sugestoes = rede.sugerirAmigo(test.getNome(), 3); //Teste com limite = 3

        if(sugestoes.isEmpty()){
            System.out.println("Nenhuma sugestão encontrada para " + test.getNome() + "!");
        } else{
            System.out.println("Sugestões de amigos para " + test.getNome() + ": ");{
                for(Aluno sugerido : sugestoes){
                    System.out.println(" -> " + sugerido.getNome());
                }
            }
        }
        System.out.println("=======================================================");
        //Teste Pares de alunos com mais disciplinas
        rede.mostrarParAlunos();


        ListaEncadeada<Aluno> listaDeAlunos = rede.getListAlunos();
        ListaEncadeada<ListaEncadeada<Aluno>> comunidades = rede.detectarComunidades(listaDeAlunos);

        for (int i = 0; i < comunidades.getTamanho(); i++) {
            System.out.println("Comunidade " + (i + 1) + ":");
            for (Aluno a : comunidades.get(i)) {
                System.out.println("  - " + a.getNome());
            }
        }


    }
}