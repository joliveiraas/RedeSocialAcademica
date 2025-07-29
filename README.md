# 📚 Grafonória: Rede Social Acadêmica com Grafos

Este é um projeto de Estrutura de Dados feito em Java utilizando **grafos** para modelar uma rede social entre alunos. Desenvolvido em grupo como parte da disciplina. 

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
