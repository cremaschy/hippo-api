package com.backend.hippo_api.infrastructure.entity;

import com.backend.hippo_api.infrastructure.enums.StatusTarefaEnum;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tarefas")
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_tarefa", nullable = false)
    private String nomeTarefa;
    @Column(name = "descricacao", nullable = false)
    private String descricao;
    @Column(name = "status", nullable = false, length = 9)
    private StatusTarefaEnum statusTarefa;
    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao;
    @Column(name = "data_evento", nullable = false)
    private LocalDateTime dataEvento;
}
