package com.jigmaster.model;

import com.jigmaster.enums.Gramatura;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "jigs")
@Builder
public class Jig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;
    @Column(name= "modelo",nullable = false, length = 50)
    @NotBlank(message = "Modelo é obrigatório")
    private String modelo;
    @Column(name= "cor_cabeca", length = 30)
    private String corCabeca;
    @Column(name= "cor_pelo", nullable = false, length = 30)
    @NotBlank(message = "Cor do pelo é obrigatória")
    private String corPelo;
    @Column(nullable = false)
    @NotNull
    @Enumerated(EnumType.STRING)
    private Gramatura gramatura;
    @Column(name= "data_cadastro", nullable = false, updatable = false)
    private LocalDateTime dataCadastro;
    @Column(nullable = false)
    private Boolean ativo = true;

    //metodo para pega ro preço da gramatura
    public BigDecimal getPreco() {
        return gramatura != null ? gramatura.getPreco() : BigDecimal.ZERO;
    }

    //define a data de cadastro automaticamente
    @PrePersist
    protected void onCreate() {
        this.dataCadastro = LocalDateTime.now();
        if (this.ativo == null) {
            this.ativo = true;
        }
    }

    @Override
    public String toString() {
        return "Jig{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", gramatura=" + gramatura +
                ", preco=" + getPreco() +
                ", ativo=" + ativo +
                '}';
    }

}
