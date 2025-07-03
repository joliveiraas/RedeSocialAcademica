package rede.model;

public class Disciplina {
    // atributos: nome, codigo

    private String nome;
    private String codigo;

    public Disciplina(String nome, String codigo){
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return getCodigo() + ": " + getNome();
    }

    public static Disciplina[] getTodasDisciplinas() {
        return new Disciplina[] {
                new Disciplina("Metodologia da Pesquisa", "CCA283"),
                new Disciplina("Ética e Sustentabilidade", "CCA310"),
                new Disciplina("Fundamentos da Filosofia", "CCA235"),
                new Disciplina("Cálculo Diferencial e Integral I", "CET146"),
                new Disciplina("Cálculo Diferencial e Integral II", "CET147"),
                new Disciplina("Cálculo Diferencial e Integral III", "CET148"),
                new Disciplina("Cálculo Diferencial e Integral IV", "CET149"),
                new Disciplina("Física Geral e Experimental I", "CET095"),
                new Disciplina("Física Geral e Experimental II", "CET099"),
                new Disciplina("Física Geral e Experimental III", "CET103"),
                new Disciplina("Física Geral e Experimental IV", "CET106"),
                new Disciplina("Geometria Analítica", "CET061"),
                new Disciplina("Processamento de Dados I", "CET150"),
                new Disciplina("Processamento de Dados II", "CET151"),
                new Disciplina("Química Geral", "CET066"),
                new Disciplina("Álgebra Linear", "CET065"),
                new Disciplina("Métodos Estatísticos", "CET060"),
                new Disciplina("Cálculo Numérico I", "CET059"),
                new Disciplina("Desenho Técnico I", "CET025"),
                new Disciplina("Mecânica dos Sólidos I", "CET100"),
                new Disciplina("Mecânica dos Sólidos II", "CET104"),
                new Disciplina("Fenômenos de Transporte", "CET103"),
                new Disciplina("Dinâmica dos Sólidos", "CET166"),
                new Disciplina("Eletricidade", "CET166"),
                new Disciplina("Termodinâmica", "CET168"),
                new Disciplina("Eletromagnetismo I", "CET169"),
                new Disciplina("Transferência de Calor e Massa", "CET171"),
                new Disciplina("TCC", "CET161"),
                new Disciplina("Princípios de Orientação a Objetos", "CET236"),
                new Disciplina("Estruturas de Dados", "CET224"),
                new Disciplina("Circuitos Digitais I", "CET225"),
                new Disciplina("Sinais e Sistemas", "CET509"),
                new Disciplina("Circuitos Digitais II", "CET231"),
                new Disciplina("Matemática Discreta", "CET508"),
                new Disciplina("Circuitos Elétricos I", "CET226"),
                new Disciplina("Organização e Arquitetura de Computadores I", "CET235"),
                new Disciplina("Engenharia de Software I", "CET512"),
                new Disciplina("Análise de Sistemas", "CET513"),
                new Disciplina("Banco de Dados I", "CET514"),
                new Disciplina("Eletrônica Analógica I", "CET515"),
                new Disciplina("Empreendedorismo", "CET516"),
                new Disciplina("Sistemas Operacionais", "CET517"),
                new Disciplina("Linguagens Formais e Autômatos", "CET518"),
                new Disciplina("Lógica para Computação", "CET519"),
                new Disciplina("Sistemas de Controle", "CET520"),
                new Disciplina("Instrumentação Eletrônica", "CET521"),
                new Disciplina("Teoria da Computação", "CET522"),
                new Disciplina("Sistemas Distribuídos", "CET547"),
                new Disciplina("Sistemas de Tempo Real", "CET524"),
                new Disciplina("Compiladores", "CET525"),
                new Disciplina("Inteligência Artificial", "CET159"),
                new Disciplina("Redes de Computadores I", "CET526"),
                new Disciplina("Sistemas Microcontrolados", "CET527"),
                new Disciplina("Sistemas Embarcados", "CET528"),
                new Disciplina("Aspectos Legais para Computação", "CET529"),
                new Disciplina("Projeto de TCC", "CET530"),
                new Disciplina("Interação Humano-Computador", "CET531"),
                new Disciplina("TCC de Engenharia de Computação", "CET532"),
                new Disciplina("Estágio", "CETXXX")
        };
    }

}

