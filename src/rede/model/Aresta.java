package rede.model;

public class Aresta {
    private Aluno origem;
    private Aluno destino;
    private int peso; // número de disciplinas em comum

    public Aresta(Aluno origem, Aluno destino, int peso){
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }

    public Aluno getOrigem() {
        return origem;
    }

    public void setOrigem(Aluno origem) {
        this.origem = origem;
    }

    public Aluno getDestino() {
        return destino;
    }

    public void setDestino(Aluno destino) {
        this.destino = destino;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return origem.getNome() + " <-> " + destino.getNome() + " (" + peso + ")";
    }


}
