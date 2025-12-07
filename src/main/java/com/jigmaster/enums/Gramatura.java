package com.jigmaster.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
@AllArgsConstructor
@Getter
public enum Gramatura {
    SETE_GRAMAS(7,new BigDecimal("10.00")),
    DEZ_GRAMAS(10, new BigDecimal("10.00")),
    QUINZE_GRAMAS(15, new BigDecimal("12.00"));
    private final Integer valor;
    private final BigDecimal preco;

    // Método útil para buscar por valor
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
