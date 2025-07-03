package rede.model;
import java.util.ArrayList;

public class Aluno {
    private String nome;
    private String matricula;
    private ArrayList<Disciplina> listaDisciplinas;

    public Aluno(String nome, String matricula){
        this.nome = nome;
        this.matricula = matricula;
        this.listaDisciplinas = new ArrayList<>();
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
}

