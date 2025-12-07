package com.jigmaster.web.dto;

import com.jigmaster.enums.Gramatura;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class JigRequestDto {
    @NotBlank(message = "Modelo é obrigatório")
    private String modelo;
    private String corCabeca;
    @NotBlank(message = "Cor do pelo é obrigatória")
    private String corPelo;
    @NotNull(message = "Gramatura é obrigatória")
    private Gramatura gramatura;



}
