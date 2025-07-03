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
            for(int j = i + 1; j < getListaAlunos().size(); j++){
                Aluno a1 = getListaAlunos().get(i);
                Aluno a2 = getListaAlunos().get(j);
                int peso = contarDisciplinas(a1, a2);
                getMatrizAdj()[i][j] = peso;
                getMatrizAdj()[j][i] = peso; //N direcionado
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

    /*public void imprimirRede() {
        Graph g = new Graph("Rede Social Acadêmica");

        // Adiciona os nós
        ArrayList<Node> nos = new ArrayList<>();
        for (Aluno aluno : listaAlunos) {
            Node n = new Node(aluno.getNome());
            g.addNode(n);
            nos.add(n);
        }

        // Cria as conexões
        for (int i = 0; i < listaAlunos.size(); i++) {
            for (int j = i + 1; j < listaAlunos.size(); j++) {
                if (matrizAdj[i][j] > 0) {
                    g.addEdge(nos.get(i), nos.get(j), String.valueOf(matrizAdj[i][j]));
                }
            }
        }

        g.display();
    }*/

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
