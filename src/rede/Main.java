package rede;

import rede.controller.Grafo;
import rede.model.Aluno;
import rede.model.Aresta;
import rede.model.Disciplina;
import rede.view.DrawGraph;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Grafo rede = new Grafo();

        Disciplina[] disciplinas = {
                new Disciplina("Metodologia da Pesquisa", "CCA283"),
                new Disciplina("Ética e Sustentabilidade", "CCA310"),
                new Disciplina("Fundamentos da Filosofia", "CCA235"),
                new Disciplina("Cálculo Diferencial e Integral I", "CET146"),
                new Disciplina("Cálculo Diferencial e Integral II", "CET147"),
                new Disciplina("Cálculo Diferencial e Integral III", "CET148"),
                new Disciplina("Cálculo Diferencial e Integral IV", "CET149"),
                new Disciplina("Física Geral e Experimental I", "CET095"),
                new Disciplina("Física Geral e Experimental II", "CET099"),
                new Disciplina("Física Geral e Experimental III", "CET103"),
                new Disciplina("Física Geral e Experimental IV", "CET106"),
                new Disciplina("Geometria Analítica", "CET061"),
                new Disciplina("Processamento de Dados I", "CET150"),
                new Disciplina("Processamento de Dados II", "CET151"),
                new Disciplina("Química Geral", "CET066"),
                new Disciplina("Álgebra Linear", "CET065"),
                new Disciplina("Métodos Estatísticos", "CET060"),
                new Disciplina("Cálculo Numérico I", "CET059"),
                new Disciplina("Desenho Técnico I", "CET025"),
                new Disciplina("Mecânica dos Sólidos I", "CET100"),
                new Disciplina("Mecânica dos Sólidos II", "CET104"),
                new Disciplina("Fenômenos de Transporte", "CET103"),
                new Disciplina("Dinâmica dos Sólidos", "CET166"),
                new Disciplina("Eletricidade", "CET166"),
                new Disciplina("Termodinâmica", "CET168"),
                new Disciplina("Eletromagnetismo I", "CET169"),
                new Disciplina("Transferência de Calor e Massa", "CET171"),
                new Disciplina("TCC", "CET161"),
                new Disciplina("Princípios de Orientação a Objetos", "CET236"),
                new Disciplina("Estruturas de Dados", "CET224"),
                new Disciplina("Circuitos Digitais I", "CET225"),
                new Disciplina("Sinais e Sistemas", "CET509"),
                new Disciplina("Circuitos Digitais II", "CET231"),
                new Disciplina("Matemática Discreta", "CET508"),
                new Disciplina("Circuitos Elétricos I", "CET226"),
                new Disciplina("Organização e Arquitetura de Computadores I", "CET235"),
                new Disciplina("Engenharia de Software I", "CET512"),
                new Disciplina("Análise de Sistemas", "CET513"),
                new Disciplina("Banco de Dados I", "CET514"),
                new Disciplina("Eletrônica Analógica I", "CET515"),
                new Disciplina("Empreendedorismo", "CET516"),
                new Disciplina("Sistemas Operacionais", "CET517"),
                new Disciplina("Linguagens Formais e Autômatos", "CET518"),
                new Disciplina("Lógica para Computação", "CET519"),
                new Disciplina("Sistemas de Controle", "CET520"),
                new Disciplina("Instrumentação Eletrônica", "CET521"),
                new Disciplina("Teoria da Computação", "CET522"),
                new Disciplina("Sistemas Distribuídos", "CET547"),
                new Disciplina("Sistemas de Tempo Real", "CET524"),
                new Disciplina("Compiladores", "CET525"),
                new Disciplina("Inteligência Artificial", "CET159"),
                new Disciplina("Redes de Computadores I", "CET526"),
                new Disciplina("Sistemas Microcontrolados", "CET527"),
                new Disciplina("Sistemas Embarcados", "CET528"),
                new Disciplina("Aspectos Legais para Computação", "CET529"),
                new Disciplina("Projeto de TCC", "CET530"),
                new Disciplina("Interação Humano-Computador", "CET531"),
                new Disciplina("TCC de Engenharia de Computação", "CET532"),
                new Disciplina("Estágio", "CETXXX")
        };

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

        // Adiciona aluno na rede e atribui 11 disciplinas diferentes a cada um
        for (int i = 0; i < 5; i++) {
            Aluno aluno = alunos[i];
            rede.addAluno(aluno.getNome(), aluno.getMatricula());

            ArrayList<Disciplina> disciplinasAluno = new ArrayList<>(Arrays.asList(
                    disciplinas[(i * 3) % disciplinas.length],
                    disciplinas[(i * 5 + 1) % disciplinas.length],
                    disciplinas[(i * 3 + 2) % disciplinas.length],
                    disciplinas[(i * 1 + 3) % disciplinas.length],
                    disciplinas[(i * 7 + 4) % disciplinas.length],
                    disciplinas[(i * 3 + 5) % disciplinas.length],
                    disciplinas[(i * 5 + 6) % disciplinas.length],
                    disciplinas[(i * 3 + 7) % disciplinas.length],
                    disciplinas[(i * 1 + 8) % disciplinas.length],
                    disciplinas[(i * 3 + 9) % disciplinas.length],
                    disciplinas[(i * 7 + 10) % disciplinas.length]
            ));

            for(int k = 0; k < disciplinasAluno.size(); k++){
                rede.addDisciplina(aluno.getMatricula(), disciplinasAluno.get(k).getNome(), disciplinasAluno.get(k).getCodigo());
            }

        }

        // Verificando alunos e suas disciplinas
        /*for(int i = 0; i < rede.getListaAlunos().size(); i++){
            Aluno aluno = rede.getListaAlunos().get(i);
            System.out.println("========== " + aluno.getNome() + " ==========");
            System.out.println(aluno);
            ArrayList<Disciplina> disciplinasAluno = rede.getListaAlunos().get(i).getListaDisciplinas();

            for(int j = 0; j < disciplinasAluno.size(); j++){
                System.out.println(disciplinasAluno.get(j));
            }
        }*/


        rede.criarRede();
        // Ver aresta de Harry e Hermione
        /*System.out.println("Arestas de Luna Antes ===========");
        Aluno luna = rede.getListaAlunos().get(4);
        for(Aresta a: luna.getListaAresta()){
            System.out.println(a);
        }
        System.out.println("===============================");

        // Add PD II a Luna
        rede.addDisciplina(luna.getMatricula(), disciplinas[13].getNome(), disciplinas[13].getCodigo());
        rede.addDisciplina(luna.getMatricula(), disciplinas[31].getNome(), disciplinas[31].getCodigo());
        rede.criarRede();
        //
        /*int idx = harry.getListaAresta().indexOf(rede.getListaAlunos().get(1));
        System.out.println(harry.getListaAresta().get(idx));
        System.out.println("Arestas de Luna Depois ===========");

        for(Aresta a: luna.getListaAresta()){
            System.out.println(a);
        }
        System.out.println(luna.getListaAresta().size());*/


        //rede.imprimirMatriz();

        DrawGraph.showGraph(rede.getListaAlunos(), rede.getMatrizAdj());


    }
}