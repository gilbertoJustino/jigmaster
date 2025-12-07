package com.jigmaster.web.mapper;

import com.jigmaster.model.Jig;
import com.jigmaster.web.dto.JigRequestDto;
import com.jigmaster.web.dto.JigResponseDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
//garante que essa classe não sera instanciada
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JigMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static Jig toJig(JigRequestDto jigRequestDto) {
        return modelMapper.map(jigRequestDto, Jig.class);
    }
    public static JigResponseDto toDto(Jig jig) {
        return modelMapper.map(jig, JigResponseDto.class);
    }
}
