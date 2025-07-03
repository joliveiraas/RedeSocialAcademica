package rede.model;

public class Aresta {
    // atributos: aluno1, aluno2, peso

    private Aluno aluno1;
    private Aluno aluno2;
    private int peso;

    public Aresta(Aluno aluno1, Aluno aluno2, int peso) {
        this.aluno1 = aluno1;
        this.aluno2 = aluno2;
        this.peso = peso;
    }

    public Aluno getAluno1() {
        return aluno1;
    }

    public void setAluno1(Aluno aluno1) {
        this.aluno1 = aluno1;
    }

    public Aluno getAluno2() {
        return aluno2;
    }

    public void setAluno2(Aluno aluno2) {
        this.aluno2 = aluno2;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
