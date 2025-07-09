package rede.model;
import rede.uteis.ListaEncadeada;

public class Aluno {
    private String nome;
    private String matricula;
    private ListaEncadeada<Disciplina> listaDisciplinas;
    private ListaEncadeada<Aresta> listaArestas;

    public Aluno(String nome, String matricula){
        this.nome = nome;
        this.matricula = matricula;
        this.setListaDisciplinas(new ListaEncadeada<>());
        this.setListaArestas(new ListaEncadeada<>());
    }

    public void addAresta(Aresta aresta){
        getListaArestas().adiciona(aresta);
    }

    public Aresta buscaAresta(Aluno amigo){
        for(int i = 0; i < getListaArestas().getTamanho(); i++){
            if(amigo == getListaArestas().get(i).getAluno1() || amigo == getListaArestas().get(i).getAluno2()){
                return getListaArestas().get(i);
            }
        }
        return null;
    }

    public void verAmigos(){
        for(Aresta a: getListaArestas()){
            if(a.getAluno2().getMatricula() != matricula){
                System.out.println(a.getAluno2());
            }
            else{
                System.out.println(a.getAluno1());
            }
        }
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return getNome() + ", " + getMatricula();
    }


    public ListaEncadeada<Disciplina> getListaDisciplinas() {
        return listaDisciplinas;
    }

    public void setListaDisciplinas(ListaEncadeada<Disciplina> listaDisciplinas) {
        this.listaDisciplinas = listaDisciplinas;
    }

    public ListaEncadeada<Aresta> getListaArestas() {
        return listaArestas;
    }

    public void setListaArestas(ListaEncadeada<Aresta> listaArestas) {
        this.listaArestas = listaArestas;
    }
}

