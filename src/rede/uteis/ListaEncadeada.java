package rede.uteis;
import java.util.Iterator;


public class ListaEncadeada<T> implements Iterable<T>{
    Nodo<T> primeiro = null;
    Nodo<T> ultimo = null;
    int tamanho = 0;

    public ListaEncadeada() {
    }

    public Nodo<T> getPrimeiro() {
        return this.primeiro;
    }

    public void setPrimeiro(Nodo<T> primeiro) {
        this.primeiro = primeiro;
    }

    public Nodo<T> getUltimo() {
        return this.ultimo;
    }

    public void setUltimo(Nodo<T> ultimo) {
        this.ultimo = ultimo;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }


    public void adiciona(T valor) {
        Nodo<T> novo = new Nodo<>(valor);
        if (getPrimeiro() == null) {
            this.primeiro = novo;
            this.ultimo = novo;
        } else {
            novo.prox = null;
            ultimo.prox = novo;
            novo.ant = ultimo;
            ultimo = novo;
        }
        setTamanho(getTamanho() + 1);
    }

    public void adiciona(int index, T valor) {
        if (index < 0 || index > getTamanho()) {
            throw new IndexOutOfBoundsException("Índice inválido: " + index);
        }

        Nodo<T> novo = new Nodo<>(valor);

        if (index == 0) { // Inserção no início
            novo.prox = primeiro;
            if (primeiro != null) {
                primeiro.ant = novo;
            }
            primeiro = novo;
            if (tamanho == 0) {
                ultimo = novo;
            }
        } else if (index == tamanho) { // Inserção no fim
            ultimo.prox = novo;
            novo.ant = ultimo;
            ultimo = novo;
        } else { // Inserção no meio
            Nodo<T> atual = primeiro;
            for (int i = 0; i < index; i++) {
                atual = atual.prox;
            }
            Nodo<T> anterior = atual.ant;
            anterior.prox = novo;
            novo.ant = anterior;
            novo.prox = atual;
            atual.ant = novo;
        }

        setTamanho(getTamanho() + 1);
    }

    public void clear(){
        this.primeiro = null;
        this.ultimo = null;
        setTamanho(0);
    }

    public void imprime() {
        Nodo<T> atual = primeiro;
        while (atual != null){
            System.out.println(atual.obj);
            atual = atual.prox;
        }

    }

    public boolean contem(T valor) {
        Nodo<T> atual = getPrimeiro();
        while (atual != null){
            if(atual.obj.equals(valor)){
                return true;
            }
            atual = atual.prox;
        }

        return false;
    }

    public void removeUltimo() {
        if (ultimo == null) {
            return;
        }

        if (primeiro == ultimo) {
            primeiro = null;
            ultimo = null;
        } else {
            ultimo = ultimo.ant;
            ultimo.prox = null;
        }
        tamanho--;
    }


    public T get(int index) {
        if (index < 0 || index >= tamanho) {
            throw new IndexOutOfBoundsException("Índice fora dos limites: " + index);
        }

        Nodo<T> atual;

        // Otimiza o caminho: se estiver mais perto do início ou do fim tipo busca binaria
        if (index < tamanho / 2) {
            atual = primeiro;
            for (int i = 0; i < index; i++) {
                atual = atual.prox;
            }
        } else {
            atual = ultimo;
            for (int i = tamanho - 1; i > index; i--) {
                atual = atual.ant;
            }
        }

        return atual.obj;
    }

    public boolean isEmpty() {
        return getTamanho() == 0;
    }

    public void addIfNotExists(T elemento) {
        if (contem(elemento)) {
            return; // não adiciona duplicado
        }
        adiciona(elemento); // usa o método normal de adicionar
    }

    public int indexOf(T elemento) {
        Nodo<T> atual = primeiro;
        int indice = 0;

        while (atual != null) {
            if (atual.obj.equals(elemento)) {
                return indice;
            }
            atual = atual.prox;
            indice++;
        }

        return -1; // não encontrado
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Nodo<T> atual = primeiro;

            @Override
            public boolean hasNext() {
                return atual != null;
            }

            @Override
            public T next() {
                T obj = atual.obj;
                atual = atual.prox;
                return obj;
            }
        };
    }


}

