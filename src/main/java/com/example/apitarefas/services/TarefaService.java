package com.example.apitarefas.services;

import com.example.apitarefas.models.Tarefa;
import com.example.apitarefas.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TarefaService {

  @Autowired
  private TarefaRepository tarefaRepository;

  public List<Tarefa> buscaTarefas() {
    return tarefaRepository.findAll();
  }

  public Tarefa criarTarefa(Tarefa tarefa) {
    return tarefaRepository.save(tarefa);
  }

  public Tarefa atualizaTarefa(Tarefa tarefa, Long id) {
//    Tarefa entity = tarefaRepository.findById(id).orElseThrow();
//    tarefa.setId(id);
    if(!Objects.equals(tarefa.getId(), id)) {
      throw new RuntimeException("id do path param diferente do payload");
    } else {
      return tarefaRepository.save(tarefa);
    }
  }

  public void deletar(Long id) {
    tarefaRepository.deleteById(id);
  }
}
