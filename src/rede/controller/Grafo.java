package rede.controller;
import rede.model.Aluno;
import rede.model.Aresta;
import rede.model.Disciplina;
import rede.uteis.ListaEncadeada;

import java.util.*;


public class Grafo {
    private ListaEncadeada<Aluno> listAlunos;
    private int[][] matrizAdj;

    public Grafo() {
        this.setListAlunos(new ListaEncadeada<>());
        this.matrizAdj = new int[0][0];
    }

    public void addAluno(String nome, String matricula){
        Aluno novoAluno = new Aluno(nome, matricula);
        getListAlunos().adiciona(novoAluno);
        redimensionarMatriz();
    }

    public void addDisciplina(String matricula, String nomeDisciplina, String codigo) {
        Disciplina novaDisciplina = new Disciplina(nomeDisciplina, codigo);
        for (Aluno a : getListAlunos()) {
            if (a.getMatricula().equals(matricula)) {
                a.getListaDisciplinas().adiciona(novaDisciplina);
            }
        }
    }

    public Aluno buscarAlunoMatricula(String matricula) {
        for (Aluno a : getListAlunos()) {
            if (a.getMatricula().equals(matricula)) {
                return a;
            }
        }
        System.out.println("Aluno não encontrado");
        return null;
    }

    public Aluno buscarAlunoNome(String nome) {
        for (Aluno a : getListAlunos()) {
            if (a.getNome().equalsIgnoreCase(nome)) {
                return a;
            }
        }
        System.out.println("Aluno não encontrado");
        return null;
    }

    private void redimensionarMatriz() {
        int tamanho = getListAlunos().getTamanho();
        int[][] novaMatriz = new int[tamanho][tamanho];

        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = 0; j < tamanho - 1; j++) {
                novaMatriz[i][j] = getMatrizAdj()[i][j];
            }
        }
        setMatrizAdj(novaMatriz);
    }

    public void criarRede() { //Deve ser criada a partir de disciplinas iguais logo vai ser automatico

        for (int i = 0; i < getListAlunos().getTamanho(); i++) {
            for (int j = i + 1; j < getListAlunos().getTamanho(); j++) {
                Aluno a1 = getListAlunos().get(i);
                Aluno a2 = getListAlunos().get(j);
                int peso = contarDisciplinas(a1, a2);
                getMatrizAdj()[i][j] = peso;
                getMatrizAdj()[j][i] = peso; //N direcionado
            }
        }
        criarArestas();
    }

    public void criarArestas(){
        int n = getListAlunos().getTamanho();

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int peso = getMatrizAdj()[i][j];
                if(peso > 0 ){

                    Aresta a = getListAlunos().get(i).buscaAresta(getListAlunos().get(j));

                    if(a == null){
                        Aluno origem = getListAlunos().get(i);
                        Aluno destino = getListAlunos().get(j);
                        Aresta a1 = new Aresta(origem, destino, peso);
                        Aresta a2 = new Aresta(destino, origem, peso);
                        origem.addAresta(a1);
                        destino.addAresta(a2);
                    }
                    else{
                        Aresta a1 = getListAlunos().get(i).buscaAresta(getListAlunos().get(j));
                        Aresta a2 = getListAlunos().get(j).buscaAresta(getListAlunos().get(i));
                        a1.setPeso(peso);
                        a2.setPeso(peso);
                    }

                }
            }
        }
    }

    private int contarDisciplinas(Aluno a1, Aluno a2) {
        int contador = 0;

        for (Disciplina d1 : a1.getListaDisciplinas()) {
            for (Disciplina d2 : a2.getListaDisciplinas()) {
                if (d1.getCodigo().equals(d2.getCodigo())) { //Comparando os códigos...
                    contador++;
                }
            }
        }
        return contador;
    }

    public void imprimirMatriz() {
        System.out.println("Matriz de adjacência");
        System.out.print("     ");
        for (Aluno a : getListAlunos()) {
            System.out.print(a.getNome() + " - ");
        }
        System.out.println();
        for (int i = 0; i < getListAlunos().getTamanho(); i++) {
            System.out.print(getListAlunos().get(i).getNome() + " | ");
            for (int j = 0; j < getListAlunos().getTamanho(); j++) {
                System.out.print(getMatrizAdj()[i][j] + "    ");
            }
            System.out.println();
        }
    }

    public int grauAluno(String nome){
        Aluno aluno = buscarAlunoNome(nome);
        int i = listAlunos.indexOf(aluno);
        int grau = 0;

        if(aluno == null){
            return -1;
        }
        for(int j = 0; j < matrizAdj.length; j++){
            if(matrizAdj[i][j]>0){
                grau++;
            }
        }
        System.out.println("Aluno "+ nome + ": " + grau + " conexões");
        return grau;
    }

    public ListaEncadeada<Aluno> alunoMaisConectado(){
        int max = -1;
        ListaEncadeada<Aluno> maisConectado = new ListaEncadeada<>();

        for (Aluno a : listAlunos) {
            int grau = 0;
            int index = listAlunos.indexOf(a);

            for (int j = 0; j < matrizAdj.length; j++) {
                if (matrizAdj[index][j] > 0){
                    grau++;
                }
            }

            if (grau > max) {
                max = grau;
                maisConectado.clear();
                maisConectado.adiciona(a);
            } else if (grau == max) {
                maisConectado.adiciona(a);
            }
        }

        System.out.println("Maior grau: " + max);
        System.out.println("====== Aluno mais conectado ====== ");
        for (Aluno aluno : maisConectado) {
            System.out.println(aluno.getNome());
        }
        return maisConectado;
    }

    // DFS iterativo para buscar caminho entre alunos
    public void buscarCaminho(String nomeOrigem, String nomeDestino) {
        Aluno origem = buscarAlunoNome(nomeOrigem);
        Aluno destino = buscarAlunoNome(nomeDestino);

        if (origem == null || destino == null) {
            System.out.println("Origem ou destino não encontrados.");
            return;
        }

        ListaEncadeada<Aluno> visitados = new ListaEncadeada<>();
        ListaEncadeada<Aluno> caminho = new ListaEncadeada<>();

        boolean encontrado = buscarCaminhoRec(origem, destino, visitados, caminho);

        if (encontrado) {
            System.out.println("Caminho encontrado:");
            for (int i = 0; i < caminho.getTamanho(); i++) {
                System.out.print(caminho.get(i).getNome());
                if (i < caminho.getTamanho() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        } else {
            System.out.println("Nenhum caminho encontrado entre " + nomeOrigem + " e " + nomeDestino);
        }
    }

    private boolean buscarCaminhoRec(Aluno atual, Aluno destino, ListaEncadeada<Aluno> visitados, ListaEncadeada<Aluno> caminho) {
        visitados.adiciona(atual);
        caminho.adiciona(atual);

        if (atual.equals(destino)) {
            return true;
        }

        for (Aresta a : atual.getListaArestas()) {
            Aluno vizinho = a.getAluno2();
            if (!visitados.contem(vizinho)) {
                boolean encontrado = buscarCaminhoRec(vizinho, destino, visitados, caminho);
                if (encontrado) {
                    return true;
                }
            }
        }
        caminho.removeUltimo();
        return false;
    }

    public ListaEncadeada<Aluno>sugerirAmigo(String nome, int limite){
        ListaEncadeada<Aluno> sugestoes = new ListaEncadeada<>();
        ListaEncadeada<Aluno> jaSugeridos = new ListaEncadeada<>();

        Aluno aluno = buscarAlunoNome(nome);
        if(aluno != null){ //Existe esse aluno
            ListaEncadeada<Aresta> melhoresAmigos = alunoMaiorPeso(aluno); //Lista de Melhores amigos, pode ser que tenha dois com o mesmo peso

            for(Aresta aresta1: melhoresAmigos){
                Aluno melhorAmigo = aresta1.getAluno2();
                ListaEncadeada<Aresta> amigoDoAmigo = melhorAmigo.getListaArestas();
                for(Aresta aresta2: amigoDoAmigo){
                    Aluno candidato = aresta2.getAluno2();
                    if(!candidato.equals(aluno) && !estaConectado(aluno, candidato) && !jaSugeridos.contem(candidato)){
                        sugestoes.adiciona(candidato);
                        jaSugeridos.addIfNotExists(candidato);

                        if(sugestoes.getTamanho() == limite){
                            return sugestoes;
                        }
                    }
                }
            }
        }
        return sugestoes;
    }

    public ListaEncadeada<Aresta> alunoMaiorPeso(Aluno aluno){
        ListaEncadeada<Aresta> arestas = aluno.getListaArestas();
        ListaEncadeada<Aresta> maiores = new ListaEncadeada<>();

        if(arestas.isEmpty()){
            return null;
        }

        int maiorPeso = -1;
        for(Aresta a: arestas){

            if(a.getPeso() > maiorPeso){
                maiorPeso = a.getPeso();
                maiores.clear();
                maiores.adiciona(a);
            } else if(a.getPeso() == maiorPeso){
                maiores.adiciona(a);
            }
        }
        return maiores;
    }

    private boolean estaConectado(Aluno aluno1, Aluno aluno2){
        for(Aresta a: aluno1.getListaArestas()){
            if(a.getAluno2().equals(aluno2)){
                return true;
            }
        }
        return false;
    }

    public void mostrarParAlunos(){

        ListaEncadeada<String> pares = new ListaEncadeada<>();
        int maiorPeso = -1;

        for (int i = 0; i < getListAlunos().getTamanho(); i++) {
            for (int j = i + 1; j < getListAlunos().getTamanho(); j++) {
                int peso = getMatrizAdj()[i][j];

                if(peso > maiorPeso){
                    maiorPeso = peso;
                    pares.clear();
                    pares.adiciona(getListAlunos().get(i).getNome() + " <-> " + getListAlunos().get(j).getNome());
                } else if(peso == maiorPeso){
                    pares.adiciona(getListAlunos().get(i).getNome() + " <-> " + getListAlunos().get(j).getNome());
                }
            }
        }

        if(pares.isEmpty()){
            System.out.println("Nenhum par encontrado!");
        } else {
            System.out.println("Maior número de disciplinas com pares: " + maiorPeso);
            System.out.println("Pares com essa quantidade de disciplinas: ");
            for(String s : pares){
                System.out.println("-> " + s);
            }
        }
    }

    public ListaEncadeada<ListaEncadeada<Aluno>> detectarComunidades(ListaEncadeada<Aluno> alunos) {
        ListaEncadeada<ListaEncadeada<Aluno>> comunidades = new ListaEncadeada<>();
        boolean[] visitado = new boolean[alunos.getTamanho()];

        for (int i = 0; i < alunos.getTamanho(); i++) {
            if (visitado[i]) continue;

            Aluno a1 = alunos.get(i);
            ListaEncadeada<Aluno> comunidade = new ListaEncadeada<>();
            comunidade.adiciona(a1);
            visitado[i] = true;

            for (int j = i + 1; j < alunos.getTamanho(); j++) {
                if (visitado[j]) continue;

                Aluno a2 = alunos.get(j);
                int disciplinasEmComum = contarDisciplinas(a1, a2);

                if (disciplinasEmComum >= 6) {
                    comunidade.adiciona(a2);
                    visitado[j] = true;
                }
            }

            // Só adiciona se tiver pelo menos 2 membros
            if (comunidade.getTamanho() >= 2) {
                comunidades.adiciona(comunidade);
            }
        }

        return comunidades;
    }

    public int[][] getMatrizAdj() {
        return matrizAdj;
    }

    public void setMatrizAdj(int[][] matrizAdj) {
        this.matrizAdj = matrizAdj;
    }

    public ListaEncadeada<Aluno> getListAlunos() {
        return listAlunos;
    }

    public void setListAlunos(ListaEncadeada<Aluno> listAlunos) {
        this.listAlunos = listAlunos;
    }
}
