package com.example.apitarefas.controllers;

import com.example.apitarefas.models.Tarefa;
import com.example.apitarefas.services.TarefaService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

  @Autowired
  private TarefaService tarefaService;

//  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping(
    produces = {MediaType.APPLICATION_JSON_VALUE }
  )
  public List<Tarefa> buscaTarefa() {
    return tarefaService.buscaTarefas();
  }

  @PostMapping(
    consumes = { MediaType.APPLICATION_JSON_VALUE },
    produces = { MediaType.APPLICATION_JSON_VALUE }
  )
  public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
    return tarefaService.criarTarefa(tarefa);
  }

  @PutMapping(
    path = "/{id}",
    consumes = { MediaType.APPLICATION_JSON_VALUE },
    produces = { MediaType.APPLICATION_JSON_VALUE }
  )
  public Tarefa atualizaTarefa(@RequestBody Tarefa tarefa, @PathVariable(value = "id") Long id) {
    return tarefaService.atualizaTarefa(tarefa, id);
  }

  @DeleteMapping(
    path = "/{id}"
  )
  public ResponseEntity<?> deletar(@PathVariable(value = "id") Long id) {
    tarefaService.deletar(id);
    return ResponseEntity.noContent().build();
  }
}
