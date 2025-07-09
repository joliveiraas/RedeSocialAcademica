package rede.uteis;

public class Nodo{
    int val;
    Object obj;
    Nodo prox;
    Nodo ant; //para lista dupla

    public Nodo(int novoVal){
        this.val = novoVal;
        this.prox = null;
        this.ant = null;
    }
    public Nodo(Object obj){
        this.obj = obj;
    }

    public int getVal(){
        return this.val;
    }
    public void setVal(int val){
        this.val = val;
    }

    public Nodo getProx(){
        return this.prox;
    }
    public void setProx(Nodo prox){
        this.prox = prox;
    }

    public Nodo getAnt() {
        return ant;
    }

    public void setAnt(Nodo ant) {
        this.ant = ant;
    }
}