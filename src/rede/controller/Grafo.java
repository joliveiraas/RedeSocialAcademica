package rede.controller;
import rede.model.Aluno;
import rede.model.Aresta;
import rede.model.Disciplina;

import java.util.ArrayList;


public class Grafo {
    // operações:
    //, 5. maisConectado(Nataly), 6.sugerirAmigos(JP), 7.grauAluno(Nataly)
    // 9. verComunidade(Joana), 10.buscarCaminho(Nataly), 11.parAlunos(JP)

    private ArrayList<Aluno> listaAlunos;
    private int[][] matrizAdj;

    public Grafo() {
        this.listaAlunos = new ArrayList<>();
        this.matrizAdj = new int[0][0];
    }

    public void addAluno(String nome, String matricula){
        Aluno novoAluno = new Aluno(nome, matricula);
        getListaAlunos().add(novoAluno);
        redimensionarMatriz();
    }

    public void addDisciplina(String matricula, String nomeDisciplina, String codigo){
        Disciplina novaDisciplina = new Disciplina(nomeDisciplina, codigo);
        for(Aluno a : getListaAlunos()){
            if(a.getMatricula().equals(matricula)){
                a.getListaDisciplinas().add(novaDisciplina);
            }
        }
    }

    public Aluno buscarAlunoMatricula(String matricula){
        for(Aluno a : getListaAlunos()){
            if(a.getMatricula().equals(matricula)){
                return a;
            }
        } return null;
    }

    public Aluno buscarAlunoNome(String nome){
        for(Aluno a : getListaAlunos()){
            if(a.getNome().equalsIgnoreCase(nome)){
                return a;
            }
        } return null;
    }

    private void redimensionarMatriz(){
        int tamanho = getListaAlunos().size();
        int [][] novaMatriz = new int[tamanho][tamanho];

        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = 0; j < tamanho - 1; j++) {
                novaMatriz[i][j] = getMatrizAdj()[i][j];
            }
        }
        setMatrizAdj(novaMatriz);
    }

    public void criarRede(){ //Deve ser criada a partir de disciplinas iguais logo vai ser automatico

        for(int i = 0; i < getListaAlunos().size(); i++){
            for(int j = i + 1; j < getListaAlunos().size(); j++) {
                Aluno a1 = getListaAlunos().get(i);
                Aluno a2 = getListaAlunos().get(j);
                int peso = contarDisciplinas(a1, a2);
                getMatrizAdj()[i][j] = peso;
                getMatrizAdj()[j][i] = peso; //N direcionado

                // Arestas
                if(peso > 0){
                    Aresta aresta = a1.buscaAresta(a2);

                    // Cria aresta de amizade, se ainda não existe
                    if (aresta == null) {
                        Aresta amizade = new Aresta(a1, a2, peso);
                        a1.addAresta(amizade);
                        a2.addAresta(amizade);
                    }

                    // Se já existe, atualiza peso da amizade
                    else {
                        aresta.setPeso(peso);

                    }
                }

            }

        }
    }

    private int contarDisciplinas(Aluno a1, Aluno a2){
        int contador = 0;

        for(Disciplina d1 : a1.getListaDisciplinas()){
            for(Disciplina d2 : a2.getListaDisciplinas()){
                if(d1.getCodigo().equals(d2.getCodigo())){ //Comparando os códigos...
                    contador++;
                }
            }
        }
        return contador;
    }

    public void imprimirMatriz(){
        System.out.println("Matriz de adjacência");
        System.out.print("     ");
        for (Aluno a: getListaAlunos()){
            System.out.print(a.getNome() + " - ");
        }
        System.out.println();
        for (int i = 0; i < getListaAlunos().size(); i++) {
            System.out.print(getListaAlunos().get(i).getNome() + " | ");
            for(int j = 0; j < getListaAlunos().size(); j++){
                System.out.print(getMatrizAdj()[i][j] + "    ");
            }
            System.out.println();
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
