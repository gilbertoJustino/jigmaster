package com.jigmaster.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

@Table(name= "enderecos")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "bairro",nullable = true,length = 50)
    private String bairro;
    @Column(name= "cidade",nullable = true,length = 50)
    private String cidade;
    @Column(name= "rua",nullable = true,length = 100)
    private String rua;
    @Column(name= "numero",nullable = true, length = 10)
    private String numero;
    @OneToMany(mappedBy = "endereco")
    private List<Cliente> clientes = new ArrayList<>();

}
