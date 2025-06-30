package rede.model;
import java.util.List;

public class Aluno {
    private String nome;
    private String matricula;
    private List<String> listaDisciplinas;

    public Aluno(String nome, String matricula, List<String> listaDisciplinas){
        this.nome = nome;
        this.matricula = matricula;
        this.listaDisciplinas = listaDisciplinas;
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

    public List<String> getListaDisciplinas() {
        return listaDisciplinas;
    }

    public void setListaDisciplinas(List<String> listaDisciplinas) {
        this.listaDisciplinas = listaDisciplinas;
    }
}

