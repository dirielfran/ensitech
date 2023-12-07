package com.eareiza.ensitech.backend.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResponseCharacterDto {
    private int totalRecords;
    private List<ComicDto> comics;
}
