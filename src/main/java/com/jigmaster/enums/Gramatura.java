package com.jigmaster.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public enum Gramatura {
    SETE(7, new BigDecimal("10.00")),
    DEZ(10, new BigDecimal("10.00")),
    QUINZE(15, new BigDecimal("15.00"));

    private final Integer valor;
    private final BigDecimal preco;

    //  Diz ao Jackson para usar o nome da constante no JSON
    @JsonValue
    public String toJson() {
        return this.name(); // Retorna "SETE", "DEZ", "QUINZE"
    }

    //  Diz ao Jackson como criar o Enum a partir do JSON
    @JsonCreator
    public static Gramatura fromJson(String value) {
        try {
            return Gramatura.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                    "Gramatura inválida: " + value +
                            ". Valores aceitos: SETE, DEZ, QUINZE"
            );
        }
    }

    // Método útil para buscar por valor numérico
    public static Gramatura fromValor(Integer valor) {
        for (Gramatura g : values()) {
            if (g.valor.equals(valor)) {
                return g;
            }
        }
        throw new IllegalArgumentException("Gramatura inválida: " + valor);
    }

    @Override
    public String toString() {
        return valor + "g - R$ " + preco;
    }
}