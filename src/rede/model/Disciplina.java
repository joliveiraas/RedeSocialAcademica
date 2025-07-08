package rede.model;

public class Disciplina {
    // atributos: nome, codigo

    private String nome;
    private String codigo;

    public static final Disciplina[] BCET = {
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
            new Disciplina("Desenho Técnico I", "CET025")
    };

    public static final Disciplina[] MECANICA = {
            new Disciplina("Desenho Específico: Mecânica", "CET239"),
            new Disciplina("Ciência e Tecnologia dos Materiais", "CET241"),
            new Disciplina("Eletromagnetismo I", "CET169"),
            new Disciplina("Metrologia", "CET242"),
            new Disciplina("Fabricação Mecânica", "CET246"),
            new Disciplina("Higiene e Segurança no Trabalho", "CET075"),
            new Disciplina("Trabalho de Conclusão de Curso", "CET161"),
            new Disciplina("Dinâmica dos Sólidos", "CET166"),
            new Disciplina("Transferência de Calor e Massa", "CET171"),
            new Disciplina("Mecanismos e Dinâmica das Máquinas", "CET255"),
            new Disciplina("Instrumentação", "CET245"),
            new Disciplina("Sistemas Térmicos I", "CET257"),
            new Disciplina("Sistemas Térmicos II", "CET258"),
            new Disciplina("Estágio Supervisionado em Eng. Mec", "CET251"),
            new Disciplina("Projeto de Trabalho de Conclusão de Curso em Engenharia Mecânica", "CET256")
    };

    public static final Disciplina[] CIVIL = {
            new Disciplina("Desenho Arquitetônico", "CET285"),
            new Disciplina("Topografia e Geodésia", "CET105"),
            new Disciplina("Hidráulica I", "CET107"),
            new Disciplina("Materiais de Construção I", "CET506"),
            new Disciplina("Hidrologia e Climatologia", "CET110"),
            new Disciplina("Teoria das Estruturas", "CET109"),
            new Disciplina("Estruturas de Concreto Armado", "CET113"),
            new Disciplina("Saneamento Ambiental", "CET050"),
            new Disciplina("Construção Civil I", "CET047"),
            new Disciplina("Mecânica dos Solos II", "CET116"),
            new Disciplina("Estradas I", "CET288"),
            new Disciplina("Materiais de Construção II", "CET237"),
            new Disciplina("Estrutura de concreto Armado II", "CET289"),
            new Disciplina("Instalações Hidráulicas, Sanitárias e Prediais", "CET040"),
            new Disciplina("Construção Civil II Profissionalizante", "CET076"),
            new Disciplina("Fundações", "CET290"),
            new Disciplina("Estradas II", "CET291"),
            new Disciplina("Estruturas de Aço", "CET292"),
            new Disciplina("Projeto de Instalações Elétricas", "CET293"),
            new Disciplina("Planejamento e Controle da Produção", "CET664"),
            new Disciplina("Engenharia de Transportes e Tráfegos", "CET294"),
            new Disciplina("Legislação para Engenharia Civil", "CET295"),
            new Disciplina("Estágio Supervisionado em Engenharia", "CET296"),
            new Disciplina("Trabalho de Conclusão de Curso II", "CET297")
    };

    public static final Disciplina[] ELETRICA = {
            new Disciplina("Eletrônica Analógica II", "CET729"),
            new Disciplina("Sistemas Microcontrolados", "CET527"),
            new Disciplina("Materiais Elétricos", "CET234"),
            new Disciplina("Geração de Energia Elétrica", "CET719"),
            new Disciplina("Instrumentação Eletrônica", "CET521"),
            new Disciplina("Automação Industrial", "CET536"),
            new Disciplina("Sistemas de Controle", "CET720"),
            new Disciplina("Sistemas de Potência I", "CET721"),
            new Disciplina("Projeto de Instalações Elétricas", "CET293"),
            new Disciplina("Redes Industriais", "CET722"),
            new Disciplina("Eletrônica de Potência", "CET723"),
            new Disciplina("Princípios de Comunicações", "CET724"),
            new Disciplina("Projeto de TCC", "CET725"),
            new Disciplina("TCC de Engenharia Elétrica", "CET726"),
            new Disciplina("Estágio Supervisionado", "CET727")
    };

    public static final Disciplina[] COMPUTACAO = {
            new Disciplina("Eletromagnetismo I", "CET169"),
            new Disciplina("Transferência de Calor e Massa", "CET171"),
            new Disciplina("Princípios de Orientação a Objetos", "CET236"),
            new Disciplina("Estruturas de Dados", "CET224"),
            new Disciplina("Circuitos Digitais I", "CET225"),
            new Disciplina("Circuitos Digitais II", "CET231"),
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
            new Disciplina("Teoria da Computação", "CET522"),
            new Disciplina("Sistemas Distribuidos", "CET547"),
            new Disciplina("Compiladores", "CET525"),
            new Disciplina("Aspectos Legais para Computação", "CET529"),
            new Disciplina("Projeto de TCC", "CET530"),
            new Disciplina("TCC de Engenharia de Computação", "CET532"),
            new Disciplina("Estágio", "CETXXX")
    };


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

}

