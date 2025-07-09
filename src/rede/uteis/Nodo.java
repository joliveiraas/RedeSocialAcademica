package rede.uteis;

public class Nodo<T>{
    int val;
    T obj;
    Nodo<T> prox;
    Nodo<T> ant; //para lista dupla

    public Nodo(int novoVal){
        this.val = novoVal;
        this.prox = null;
        this.ant = null;
    }
    public Nodo(T obj){
        this.obj = obj;
    }

    public int getVal(){
        return this.val;
    }
    public void setVal(int val){
        this.val = val;
    }

    public Nodo<T> getProx(){
        return this.prox;
    }
    public void setProx(Nodo<T> prox){
        this.prox = prox;
    }

    public Nodo<T> getAnt() {
        return ant;
    }

    public void setAnt(Nodo<T> ant) {
        this.ant = ant;
    }
}