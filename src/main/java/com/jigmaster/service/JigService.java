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

@RequiredArgsConstructor
@Service
public class JigService {
    private final JigRepository jigRepository;

    @Transactional
    public JigResponseDto criar(JigRequestDto requestDto){
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

}
