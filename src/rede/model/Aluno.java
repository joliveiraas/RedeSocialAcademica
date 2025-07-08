package rede.model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    public Aresta buscaAresta(Aluno amigo){
        for(int i = 0; i < getListaAresta().size(); i++){
            if(amigo == getListaAresta().get(i).getAluno1() || amigo == getListaAresta().get(i).getAluno2()){
                return getListaAresta().get(i);
            }
        }
        return null;
    }

    public void verAmigos(){
        for(Aresta a: getListaAresta()){
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

