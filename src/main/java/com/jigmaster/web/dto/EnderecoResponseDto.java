package com.jigmaster.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoResponseDto {

    private Long id;
    private String rua;
    private String bairro;
    private String numero;
    private String cidade;

}