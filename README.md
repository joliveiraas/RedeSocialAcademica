# 📚 Grafonória: Rede Social Acadêmica com Grafos

<img width="1343" height="755" alt="image" src="https://github.com/user-attachments/assets/462e68f1-8a0c-4e01-97d5-a0f21e6b4bd1" />

Este é um projeto de Estrutura de Dados feito em Java utilizando **grafos** para modelar uma rede social entre alunos. Desenvolvido em grupo como parte da disciplina.

Como extra, o projeto foi construido unindo o universo de *Harry Potter* e cursos de engenharia: os personagems da saga foram utilizados para representar os alunos (vértices) e seus relacionamentos (arestas) são moldados com base na quantidade de disciplinas que compartilham entre si. As disciplinas disponíveis para cada aluno fazem parte do currículo de componentes profissionalizantes dos cursos de Engenharia da Computação, Engenharia Elétrica, Engenharia Mecânica e Engenharia Civil da Universidade Federal do Recôncavo da Bahia (UFRB), desse modo, existem 4 comunidades principais dentro da rede que um aluno pode fazer parte. 

## 👩‍💻 Integrantes
- Joana Oliveira Silva
- João Pedro Santiago
- Nataly Barbosa Pereira

## 🎯 Objetivo

Modelar uma rede onde **cada aluno é um vértice** e as **arestas representam amizades**, com peso igual ao número de disciplinas cursadas em comum.

## 🧱 Estrutura do Projeto

- `Aluno.java`: classe com nome, matrícula, disciplinas e lista de arestas (amizades)
- `Disciplina.java`: classe com nome e código da disciplina
- `Aresta.java`: modela a amizade entre dois alunos com peso (quantidade de disciplinas em comum entre dois alunos)
- `Grafo.java`: estrutura que organiza os dados e gera a rede

## ✅ Funcionalidades

- Adicionar alunos e disciplinas
- Construir rede com base nas disciplinas em comum, utilizando matriz de adjacência 
- Listar e sugerir amizades
- Buscar caminhos entre alunos
- Identificar comunidades
- Relatórios: aluno mais conectado, grau de conexões de aluno e par de aluno com maior afinidade.
- Interface gráfica para interação
- Visualização da rede 
