package com.jigmaster.web.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ClienteRequestDto {

    @NotBlank(message = "O Nome é obrigatório")
    @Size(min = 3, max = 50)
    private String nome;
    @Email(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
            message = "Email inválido")
    private String email;
    @NotBlank(message = "Telefone é obrigatório")
    @Size(min = 8, max = 13)
    private String telefone;
    @Valid
    private EnderecoRequestDto endereco;

}
