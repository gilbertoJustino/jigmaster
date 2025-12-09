package com.jigmaster.service;

import com.jigmaster.exception.ResourceNotFoundException;
import com.jigmaster.model.Jig;
import com.jigmaster.repository.JigRepository;
import com.jigmaster.web.dto.JigRequestDto;
import com.jigmaster.web.dto.JigResponseDto;
import com.jigmaster.web.mapper.JigMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class JigService {
    private final JigRepository jigRepository;

    @Transactional
    public JigResponseDto criar(JigRequestDto requestDto) {
        Jig jig = JigMapper.toJig(requestDto);
        jig = jigRepository.save(jig);
        return JigMapper.toDto(jig);
    }

    @Transactional(readOnly = true)
    public JigResponseDto buscarPorId(Long id) {
        Jig jig = jigRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Jig com ID " + id + " não encontrado."
                ));
        return JigMapper.toDto(jig);
    }

    //busca todos ativos e inativos
    @Transactional(readOnly = true)
    public List<JigResponseDto> buscarTodos() {
        List<Jig> jigs = jigRepository.findAll();
        return jigs.stream().map(JigMapper::toDto).toList();
    }

    // Buscar APENAS ATIVOS (para catálogo de vendas)
    @Transactional(readOnly = true)
    public List<JigResponseDto> buscarAtivos() {
        List<Jig> jigs = jigRepository.findByAtivoTrue();
        return jigs.stream().map(JigMapper::toDto).toList();
    }

    //metodo para desativar
    @Transactional
    public void desativar(Long id) {
        Jig jig = jigRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Jig com ID " + id + " não encontrado"
        ));
        //marca como inativo em vez de deletar
        jig.setAtivo(false);
        jigRepository.save(jig);

    }

    // Método para reativar
    @Transactional
    public JigResponseDto reativar(Long id) {
        Jig jig = jigRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Jig com ID " + id + " não encontrado"
        ));
        jig.setAtivo(true);
        jig = jigRepository.save(jig);
        return JigMapper.toDto(jig);

    }

    @Transactional
    public JigResponseDto atualizar(Long id, JigRequestDto  requestDto) {
        Jig jig = jigRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Jig com ID " + id + " não encontrado"
        ));

        jig.setModelo(requestDto.getModelo());
        jig.setCorCabeca(requestDto.getCorCabeca());
        jig.setGramatura(requestDto.getGramatura());
        jig.setCorPelo(requestDto.getCorPelo());

        jigRepository.save(jig);
        return JigMapper.toDto(jig);
    }

}

