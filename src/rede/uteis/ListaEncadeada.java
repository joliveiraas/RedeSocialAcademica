package rede.uteis;

public class ListaEncadeada {
    Nodo primeiro = null;
    Nodo ultimo = null;
    int tamanho = 0;

    public ListaEncadeada() {
    }

    public Nodo getPrimeiro() {
        return this.primeiro;
    }

    public void setPrimeiro(Nodo primeiro) {
        this.primeiro = primeiro;
    }

    public Nodo getUltimo() {
        return this.ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }


    public void adiciona(Object valor) {
        Nodo novo = new Nodo(valor);
        if (this.primeiro == null) {
            this.primeiro = novo;
        } else {
            Nodo atual;
            for (atual = this.primeiro; atual.prox != null; atual = atual.prox) {
            }

            atual.prox = novo;
        }

    }

    public void imprime() {
        for (Nodo atual = this.primeiro; atual != null; atual = atual.prox) {
            System.out.println(atual.obj);
        }

    }

    public boolean contem(Object valor) {
        for(Nodo atual = this.primeiro; atual != null; atual = atual.prox) {
            if (atual.obj == valor) {
                return true;
            }
        }

        return false;
    }


}

