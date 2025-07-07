package rede.model;

public class Disciplina {
    // atributos: nome, codigo

    private String nome;
    private String codigo;
    private String curso;

    public static final String[] CURSOS = {
            "BCET", "MECANICA", "CIVIL", "ELETRICA", "COMPUTACAO"
    };

    public static final Disciplina[] BCET = {
            new Disciplina("Metodologia da Pesquisa", "CCA283", "BCET"),
            new Disciplina("Ética e Sustentabilidade", "CCA310", "BCET"),
            new Disciplina("Fundamentos da Filosofia", "CCA235", "BCET"),
            new Disciplina("Cálculo Diferencial e Integral I", "CET146", "BCET"),
            new Disciplina("Cálculo Diferencial e Integral II", "CET147", "BCET"),
            new Disciplina("Cálculo Diferencial e Integral III", "CET148", "BCET"),
            new Disciplina("Cálculo Diferencial e Integral IV", "CET149", "BCET"),
            new Disciplina("Física Geral e Experimental I", "CET095", "BCET"),
            new Disciplina("Física Geral e Experimental II", "CET099", "BCET"),
            new Disciplina("Física Geral e Experimental III", "CET103", "BCET"),
            new Disciplina("Física Geral e Experimental IV", "CET106", "BCET"),
            new Disciplina("Geometria Analítica", "CET061", "BCET"),
            new Disciplina("Processamento de Dados I", "CET150", "BCET"),
            new Disciplina("Processamento de Dados II", "CET151", "BCET"),
            new Disciplina("Química Geral", "CET066", "BCET"),
            new Disciplina("Álgebra Linear", "CET065", "BCET"),
            new Disciplina("Métodos Estatísticos", "CET060", "BCET"),
            new Disciplina("Cálculo Numérico I", "CET059", "BCET"),
            new Disciplina("Desenho Técnico I", "CET025", "BCET")
    };

    public static final Disciplina[] MECANICA = {
            new Disciplina("Desenho Específico: Mecânica", "CET239", "MECANICA"),
            new Disciplina("Ciência e Tecnologia dos Materiais", "CET241", "MECANICA"),
            new Disciplina("Eletromagnetismo I", "CET169", "MECANICA"),
            new Disciplina("Metrologia", "CET242", "MECANICA"),
            new Disciplina("Fabricação Mecânica", "CET246", "MECANICA"),
            new Disciplina("Higiene e Segurança no Trabalho", "CET075", "MECANICA"),
            new Disciplina("Trabalho de Conclusão de Curso", "CET161", "MECANICA"),
            new Disciplina("Dinâmica dos Sólidos", "CET166", "MECANICA"),
            new Disciplina("Transferência de Calor e Massa", "CET171", "MECANICA"),
            new Disciplina("Mecanismos e Dinâmica das Máquinas", "CET255", "MECANICA"),
            new Disciplina("Instrumentação", "CET245", "MECANICA"),
            new Disciplina("Sistemas Térmicos I", "CET257", "MECANICA"),
            new Disciplina("Sistemas Térmicos II", "CET258", "MECANICA"),
            new Disciplina("Estágio Supervisionado em Eng. Mec", "CET251", "MECANICA"),
            new Disciplina("Projeto de Trabalho de Conclusão de Curso em Engenharia Mecânica", "CET256", "MECANICA")
    };

    public static final Disciplina[] CIVIL = {
            new Disciplina("Desenho Arquitetônico", "CET285", "CIVIL"),
            new Disciplina("Topografia e Geodésia", "CET105", "CIVIL"),
            new Disciplina("Hidráulica I", "CET107", "CIVIL"),
            new Disciplina("Materiais de Construção I", "CET506", "CIVIL"),
            new Disciplina("Hidrologia e Climatologia", "CET110", "CIVIL"),
            new Disciplina("Teoria das Estruturas", "CET109", "CIVIL"),
            new Disciplina("Estruturas de Concreto Armado", "CET113", "CIVIL"),
            new Disciplina("Saneamento Ambiental", "CET050", "CIVIL"),
            new Disciplina("Construção Civil I", "CET047", "CIVIL"),
            new Disciplina("Mecânica dos Solos II", "CET116", "CIVIL"),
            new Disciplina("Estradas I", "CET288", "CIVIL"),
            new Disciplina("Materiais de Construção II", "CET237", "CIVIL"),
            new Disciplina("Estrutura de concreto Armado II", "CET289", "CIVIL"),
            new Disciplina("Instalações Hidráulicas, Sanitárias e Prediais", "CET040", "CIVIL"),
            new Disciplina("Construção Civil II Profissionalizante", "CET076", "CIVIL"),
            new Disciplina("Fundações", "CET290", "CIVIL"),
            new Disciplina("Estradas II", "CET291", "CIVIL"),
            new Disciplina("Estruturas de Aço", "CET292", "CIVIL"),
            new Disciplina("Projeto de Instalações Elétricas", "CET293", "CIVIL"),
            new Disciplina("Planejamento e Controle da Produção", "CET664", "CIVIL"),
            new Disciplina("Engenharia de Transportes e Tráfegos", "CET294", "CIVIL"),
            new Disciplina("Legislação para Engenharia Civil", "CET295", "CIVIL"),
            new Disciplina("Estágio Supervisionado em Engenharia", "CET296", "CIVIL"),
            new Disciplina("Trabalho de Conclusão de Curso II", "CET297", "CIVIL")
    };

    public static final Disciplina[] ELETRICA = {
            new Disciplina("Eletrônica Analógica II", "CET729", "ELETRICA"),
            new Disciplina("Sistemas Microcontrolados", "CET527", "ELETRICA"),
            new Disciplina("Materiais Elétricos", "CET234", "ELETRICA"),
            new Disciplina("Geração de Energia Elétrica", "CET719", "ELETRICA"),
            new Disciplina("Instrumentação Eletrônica", "CET521", "ELETRICA"),
            new Disciplina("Automação Industrial", "CET536", "ELETRICA"),
            new Disciplina("Sistemas de Controle", "CET720", "ELETRICA"),
            new Disciplina("Sistemas de Potência I", "CET721", "ELETRICA"),
            new Disciplina("Projeto de Instalações Elétricas", "CET293", "ELETRICA"),
            new Disciplina("Redes Industriais", "CET722", "ELETRICA"),
            new Disciplina("Eletrônica de Potência", "CET723", "ELETRICA"),
            new Disciplina("Princípios de Comunicações", "CET724", "ELETRICA"),
            new Disciplina("Projeto de TCC", "CET725", "ELETRICA"),
            new Disciplina("TCC de Engenharia Elétrica", "CET726", "ELETRICA"),
            new Disciplina("Estágio Supervisionado", "CET727", "ELETRICA")
    };

    public static final Disciplina[] COMPUTACAO = {
            new Disciplina("Eletromagnetismo I", "CET169", "COMPUTACAO"),
            new Disciplina("Transferência de Calor e Massa", "CET171", "COMPUTACAO"),
            new Disciplina("Princípios de Orientação a Objetos", "CET236", "COMPUTACAO"),
            new Disciplina("Estruturas de Dados", "CET224", "COMPUTACAO"),
            new Disciplina("Circuitos Digitais I", "CET225", "COMPUTACAO"),
            new Disciplina("Circuitos Digitais II", "CET231", "COMPUTACAO"),
            new Disciplina("Circuitos Elétricos I", "CET226", "COMPUTACAO"),
            new Disciplina("Organização e Arquitetura de Computadores I", "CET235", "COMPUTACAO"),
            new Disciplina("Engenharia de Software I", "CET512", "COMPUTACAO"),
            new Disciplina("Análise de Sistemas", "CET513", "COMPUTACAO"),
            new Disciplina("Banco de Dados I", "CET514", "COMPUTACAO"),
            new Disciplina("Eletrônica Analógica I", "CET515", "COMPUTACAO"),
            new Disciplina("Empreendedorismo", "CET516", "COMPUTACAO"),
            new Disciplina("Sistemas Operacionais", "CET517", "COMPUTACAO"),
            new Disciplina("Linguagens Formais e Autômatos", "CET518", "COMPUTACAO"),
            new Disciplina("Lógica para Computação", "CET519", "COMPUTACAO"),
            new Disciplina("Sistemas de Controle", "CET520", "COMPUTACAO"),
            new Disciplina("Teoria da Computação", "CET522", "COMPUTACAO"),
            new Disciplina("Sistemas Distribuidos", "CET547", "COMPUTACAO"),
            new Disciplina("Compiladores", "CET525", "COMPUTACAO"),
            new Disciplina("Aspectos Legais para Computação", "CET529", "COMPUTACAO"),
            new Disciplina("Projeto de TCC", "CET530", "COMPUTACAO"),
            new Disciplina("TCC de Engenharia de Computação", "CET532", "COMPUTACAO"),
            new Disciplina("Estágio", "CETXXX", "COMPUTACAO")
    };

    public Disciplina(String nome, String codigo, String curso){
        this.nome = nome;
        this.codigo = codigo;
        this.curso = curso;
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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
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

