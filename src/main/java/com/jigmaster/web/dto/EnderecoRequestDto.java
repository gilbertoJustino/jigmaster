package com.jigmaster.web.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class EnderecoRequestDto {

    @NotBlank(message = "Rua é obrigatória")
    @Size(min = 3, max = 100, message = "Rua deve ter entre 3 e 100 caracteres")
    private String rua;

    @Size(max = 50, message = "Bairro deve ter no máximo 50 caracteres")
    private String bairro;

    @NotBlank(message = "O Número é obrigatório")
    @Size(max = 10, message = "Número deve ter no máximo 10 caracteres")
    private String numero;

    @NotBlank(message = "A Cidade é obrigatória")
    @Size(min = 3, max = 50, message = "Cidade deve ter entre 3 e 50 caracteres")
    private String cidade;
}
