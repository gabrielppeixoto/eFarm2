package com.gabrielpeixoto.eFarm.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ProductType {
    MEDICAMENTO("medicamento"), HIGIENE_PESSOAL("higiene pessoal"), EQUIPAMENTOS("Equipamentos");
    private String type;
}
