package com.backend.hippo_api.infrastructure.repository;

import com.backend.hippo_api.infrastructure.entity.Tarefa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
