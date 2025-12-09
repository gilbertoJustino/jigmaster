package com.jigmaster.web.controller;

import com.jigmaster.service.JigService;
import com.jigmaster.web.dto.JigRequestDto;
import com.jigmaster.web.dto.JigResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/jigs")
public class JigController {
    private final JigService  jigService;

    @PostMapping
    public ResponseEntity<JigResponseDto> criar(@RequestBody @Valid JigRequestDto requestDto){
        JigResponseDto responseDto = jigService.criar(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<JigResponseDto> getById(@PathVariable Long id){
        JigResponseDto jigResponse = jigService.buscarPorId(id);
        return ResponseEntity.ok(jigResponse);
    }

}
