package com.jigmaster.web.dto;

import com.jigmaster.enums.Gramatura;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JigResponseDto {
    private Long id;
    private String modelo;
    private String corCabeca;
    private String corPelo;
    private Gramatura gramatura;
    private BigDecimal preco;
    private LocalDateTime dataCadastro;
    private Boolean ativo;

}
