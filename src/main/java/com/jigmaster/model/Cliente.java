package com.jigmaster.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

@Table(name= "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;
    @Column(name= "nome",nullable = false,length = 50)
    private String nome;
    @Column(name= "email",length = 100)
    private String email;
    @Column(name= "telefone", nullable = false,length = 13)
    private String telefone;
    @Column(name = "data_cadastro", nullable = false, updatable = false)
    private LocalDateTime dataCadastro;
    @Column(name = "ativo", nullable = false)
    private Boolean ativo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id", nullable = true)
    private Endereco endereco;

    @PrePersist
    protected void onCreate() {
        this.dataCadastro = LocalDateTime.now();
        if (this.ativo == null) {
            this.ativo = true;
        }
    }
}
