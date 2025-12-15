package com.jigmaster.web.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ClienteRequestDto {

    @NotBlank(message = "O Nome é obrigatório")
    @Size(min = 3, max = 50, message = "Nome deve ter entre 3 e 100 caracteres")
    private String nome;
    @Email(message = "Email inválido")
    private String email;
    @NotBlank(message = "Telefone é obrigatório")
    @Size(min = 8, max = 15, message = "Telefone deve ter entre 8 e 15 caracteres")
    private String telefone;
    @Valid
    private EnderecoRequestDto endereco;

}
