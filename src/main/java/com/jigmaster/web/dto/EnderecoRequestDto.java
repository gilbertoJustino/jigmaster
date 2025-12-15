package com.jigmaster.web.dto;

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
public class EnderecoRequestDto {

    @NotBlank(message = "A Rua é obrigatória")
    @Size(min = 15, max = 100)
    private String rua;

    // Bairro é opcional (nullable = true no Model), então não precisa de @NotBlank aqui
    private String bairro;

    @NotBlank(message = "O Número é obrigatório")
    private String numero;

    @NotBlank(message = "A Cidade é obrigatória")
    @Size(min = 8, max = 50)
    private String cidade;
}
