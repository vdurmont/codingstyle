package org.codingstyle.api.mapper;

import org.codingstyle.api.dto.IndentationDTO;
import org.codingstyle.core.model.Indentation;
import org.springframework.stereotype.Service;

@Service
public class IndentationMapper {
    public IndentationDTO generate(Indentation indentation) {
        IndentationDTO dto = new IndentationDTO();
        dto.setIndentSize(indentation.getIndentSize());
        return dto;
    }
}
