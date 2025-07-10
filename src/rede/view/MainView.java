package rede.view;

import rede.controller.Grafo;
import rede.model.Aluno;
import rede.model.Disciplina;
import rede.uteis.ListaEncadeada;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class MainView extends JFrame{
    private Grafo grafo;
    public MainView(Grafo grafo) {
        this.grafo = grafo;
        setContentPane(tabbedPane1);
        setTitle("Menu Rede Social Academica");
        setSize(1366, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        inicializarCursos();
        painelDisciplinas.setLayout(new BoxLayout(painelDisciplinas, BoxLayout.Y_AXIS));

        comboCursos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cursoSelecionado = (String) comboCursos.getSelectedItem();
                atualizarPainelDisciplinas(cursoSelecionado);
            }
        });
        ADICIONARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String matricula = matriculaTextField.getText().trim();

                if (matricula.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Digite a matrícula!");
                    return;
                }
                Aluno aluno = grafo.buscarAlunoMatricula(matricula);
                if(aluno == null){
                    JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
                    return;
                }

                ListaEncadeada<Disciplina> disciplinasSelecionadas = getDisciplinasSelecionadas();

                for(int i = 0; i < disciplinasSelecionadas.getTamanho(); i++){
                    grafo.addDisciplina(matricula, disciplinasSelecionadas.get(i).getNome(), disciplinasSelecionadas.get(i).getCodigo());
                }
                painelDisciplinas.removeAll();
                JOptionPane.showMessageDialog(null, "Disciplinas atribuídas com sucesso para " + aluno.getNome());
            }
        });
        GrafoViewButton.addActionListener(e -> RedeView.showGraph(grafo));

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = NomeAlunoTextField.getText().trim();
                String matricula = MatriculaAlunoTextField.getText().trim();

                if(nome.isEmpty() || matricula.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Digite o nome e matricula!");
                    return;
                }
                Aluno aluno = grafo.buscarAlunoMatricula(matricula);

                if(aluno == null){
                    grafo.addAluno(nome,matricula);
                    JOptionPane.showMessageDialog(null, "Aluno adicionado com sucesso!");
                } else{
                    JOptionPane.showMessageDialog(null, "Já existe um aluno com essa matricula!");
                    return;
                }

                NomeAlunoTextField.setText("");
                MatriculaAlunoTextField.setText("");
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = buscaNome.getText().trim();
                String matricula = buscaMatricula.getText().trim();

                if(!nome.isEmpty() && !matricula.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Preencha apenas um dos campos para busca (nome ou matricula)");
                }
                if(nome.isEmpty() && matricula.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Preencha um dos campos para busca (nome ou matricula)");
                }

                Aluno alunoEncontrado = null;
                if(!nome.isEmpty()){
                     alunoEncontrado = grafo.buscarAlunoNome(nome);
                } else{
                    alunoEncontrado = grafo.buscarAlunoMatricula(matricula);
                }

                if(alunoEncontrado == null){
                    JOptionPane.showMessageDialog(null, "Aluno não encontrado!!!");
                } else{
                    JOptionPane.showMessageDialog(null, "Aluno encontrado! Nome: " + alunoEncontrado.getNome() + " Matricula: " + alunoEncontrado.getMatricula());
                }

                buscaNome.setText("");
                buscaMatricula.setText("");
            }
        });

        mostrarGrauButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextRelatorio.setEditable(false);
                TextRelatorio.append("\nGrau de todos os alunos: \n" );
                for(int i = 0; i < grafo.getListAlunos().getTamanho(); i++){
                    Aluno aluno = grafo.getListAlunos().get(i);
                    TextRelatorio.append("Aluno: "+ aluno.getNome() +", Grau: " + grafo.grauAluno(aluno.getNome()) + "\n");
                }
            }
        });
        mostrarAlunoMaisConectadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextRelatorio.setEditable(false);
                TextRelatorio.append("\nAlunos mais conectado: \n" );
                ListaEncadeada<Aluno> lista= grafo.alunoMaisConectado();

                for(int i = 0; i < lista.getTamanho(); i++){
                    TextRelatorio.append("Aluno: " + lista.get(i).getNome() + ", maior grau: " + grafo.grauAluno(lista.get(i).getNome()) + "\n");
                }

            }
        });
        mostrarParesDeAlunosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextRelatorio.setEditable(false);
                TextRelatorio.append("\nPar de alunos com maior número de disciplinas em comum: \n" );
                TextRelatorio.append(grafo.mostrarParAlunos());
            }
        });
        clearButton.addActionListener(e -> TextRelatorio.setText(" "));

        sugerirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaSugestao.setText("");
                textAreaSugestao.setEditable(false);
                String nome = NomeSugestao.getText().trim();

                String limite_str = (String) comboBoxLimite.getSelectedItem();
                int limite = Integer.parseInt(limite_str);

                if(nome.isEmpty() || limite_str.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Digite o nome e o limite!!");
                    return;
                }
                Aluno aluno = grafo.buscarAlunoNome(nome);
                if(aluno == null){
                    JOptionPane.showMessageDialog(null, "Aluno não está na rede!!");
                } else{
                    ListaEncadeada<Aluno> listaSugestao = grafo.sugerirAmigo(aluno.getNome(), limite);
                    if(listaSugestao.isEmpty()){
                        textAreaSugestao.append("Nenhuma sugestão encontrada para " + aluno.getNome() + "!");
                    } else{
                        textAreaSugestao.append("Sugestões de amigos para " + aluno.getNome() + ": \n" );{
                            for(Aluno sugerido : listaSugestao){
                                textAreaSugestao.append(" -> " + sugerido.getNome() + "\n");
                            }
                        }
                    }

                }
                NomeSugestao.setText("");
            }
        });
        comboBoxLimite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selecionado = (String) comboBoxLimite.getSelectedItem();
                textFieldOutros.setVisible("Outros".equals(selecionado));
            }
        });
    }

    private void atualizarPainelDisciplinas(String cursoSelecionado) {
        painelDisciplinas.removeAll(); // Limpa o que já tinha

        Disciplina[] disciplinas = disciplinasPorCurso.getOrDefault(cursoSelecionado, new Disciplina[0]);

        for (Disciplina d : disciplinas) {
            JCheckBox checkBox = new JCheckBox(d.getNome());
            checkBox.putClientProperty("disciplina", d); // Guarda a disciplina original
            painelDisciplinas.add(checkBox);
        }

        painelDisciplinas.revalidate();
        painelDisciplinas.repaint();
    }

    private ListaEncadeada<Disciplina> getDisciplinasSelecionadas() {
        ListaEncadeada<Disciplina> selecionadas = new ListaEncadeada<Disciplina>();
        for (Component c : painelDisciplinas.getComponents()) {
            if (c instanceof JCheckBox checkBox && checkBox.isSelected()) {
                Disciplina d = (Disciplina) checkBox.getClientProperty("disciplina");
                selecionadas.adiciona(d);
            }
        }
        return selecionadas;
    }


    private JPanel btnCadastrarAluno;
    private JTabbedPane tabbedPane1;
    private JPanel JLabel;
    private JTextField NomeAlunoTextField;
    private JButton GrafoViewButton;
    private JComboBox comboCursos;
    private JTextField matriculaTextField;
    private JButton ADICIONARButton;
    private JPanel painelDisciplinas;
    private JButton cadastrarButton;
    private JTextField MatriculaAlunoTextField;
    private JButton buscarButton;
    private JTextField buscaNome;
    private JTextField buscaMatricula;
    private JPanel Relatorio;
    private JButton mostrarGrauButton;
    private JButton mostrarAlunoMaisConectadoButton;
    private JButton mostrarParesDeAlunosButton;
    private JTextArea TextRelatorio;
    private JButton clearButton;
    private JTextField textOrigem;
    private JTextField textDestino;
    private JButton procurarButton;
    private JTextField NomeSugestao;
    private JComboBox comboBoxLimite;
    private JButton sugerirButton;
    private JTextArea textArea1;
    private JTextArea textAreaSugestao;
    private JTextField textFieldOutros;


    private Map<String, Disciplina[]> disciplinasPorCurso = new HashMap<>();

    private void inicializarCursos() {
        disciplinasPorCurso.put("BCET", Disciplina.BCET);
        disciplinasPorCurso.put("COMPUTACAO", Disciplina.COMPUTACAO);
        disciplinasPorCurso.put("ELETRICA", Disciplina.ELETRICA);
        disciplinasPorCurso.put("CIVIL", Disciplina.CIVIL);
        disciplinasPorCurso.put("MECANICA", Disciplina.MECANICA);

        // Adiciona os nomes ao combo box:
        for (String nomeCurso : disciplinasPorCurso.keySet()) {
            comboCursos.addItem(nomeCurso);
        }
    }

}
