package com.example.apitarefas.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tarefas")
public class Tarefa implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "nome", nullable = false)
  private String nome;
  @Column(name = "etapa", nullable = false)
  private String etapa;

  public Tarefa() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEtapa() {
    return etapa;
  }

  public void setEtapa(String etapa) {
    this.etapa = etapa;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Tarefa tarefa = (Tarefa) o;
    return Objects.equals(id, tarefa.id) && Objects.equals(nome, tarefa.nome) && Objects.equals(etapa, tarefa.etapa);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, etapa);
  }
}
