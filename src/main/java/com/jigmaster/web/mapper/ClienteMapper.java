package com.jigmaster.web.mapper;

import com.jigmaster.model.Cliente;
import com.jigmaster.model.Endereco;
import com.jigmaster.web.dto.ClienteRequestDto;
import com.jigmaster.web.dto.ClienteResponseDto;
import com.jigmaster.web.dto.EnderecoRequestDto;
import com.jigmaster.web.dto.EnderecoResponseDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClienteMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    // Converter ClienteRequestDto → Cliente
    public static Cliente toCliente(ClienteRequestDto dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefone(dto.getTelefone());

        // Mapear endereço SE existir
        if (dto.getEndereco() != null) {
            Endereco endereco = toEndereco(dto.getEndereco());
            cliente.setEndereco(endereco);
        }

        return cliente;
    }

    // Converter Cliente → ClienteResponseDto
    public static ClienteResponseDto toDto(Cliente cliente) {
        ClienteResponseDto dto = new ClienteResponseDto();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setEmail(cliente.getEmail());
        dto.setTelefone(cliente.getTelefone());
        dto.setDataCadastro(cliente.getDataCadastro());
        dto.setAtivo(cliente.getAtivo());

        // Mapear endereço SE existir
        if (cliente.getEndereco() != null) {
            EnderecoResponseDto enderecoDto = toEnderecoDto(cliente.getEndereco());
            dto.setEndereco(enderecoDto);
        }

        return dto;
    }

    //  MÉTODOS AUXILIARES PRIVADOS

    private static Endereco toEndereco(EnderecoRequestDto dto) {
        Endereco endereco = new Endereco();
        endereco.setRua(dto.getRua());
        endereco.setBairro(dto.getBairro());
        endereco.setNumero(dto.getNumero());
        endereco.setCidade(dto.getCidade());
        return endereco;
    }

    private static EnderecoResponseDto toEnderecoDto(Endereco endereco) {
        EnderecoResponseDto dto = new EnderecoResponseDto();
        dto.setId(endereco.getId());
        dto.setRua(endereco.getRua());
        dto.setBairro(endereco.getBairro());
        dto.setNumero(endereco.getNumero());
        dto.setCidade(endereco.getCidade());
        return dto;
    }
}

