package rede.model;
import java.util.ArrayList;

public class Aluno {
    private String nome;
    private String matricula;
    private ArrayList<Disciplina> listaDisciplinas;
    private ArrayList<Aresta> listaAresta;

    public Aluno(String nome, String matricula){
        this.nome = nome;
        this.matricula = matricula;
        this.listaDisciplinas = new ArrayList<>();
        this.setListaAresta(new ArrayList<>());
    }

    public void addAresta(Aresta aresta){
        getListaAresta().add(aresta);
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

    public ArrayList<Disciplina> getListaDisciplinas() {
        return listaDisciplinas;
    }

    public void setListaDisciplinas(ArrayList<Disciplina> listaDisciplinas) {
        this.listaDisciplinas = listaDisciplinas;
    }

    @Override
    public String toString() {
        return getNome() + ", " + getMatricula();
    }

    public ArrayList<Aresta> getListaAresta() {
        return listaAresta;
    }

    public void setListaAresta(ArrayList<Aresta> listaAresta) {
        this.listaAresta = listaAresta;
    }
}

