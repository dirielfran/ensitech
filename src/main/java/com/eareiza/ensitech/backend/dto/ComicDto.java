package com.eareiza.ensitech.backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ComicDto {
    private Integer id;
    private String name;
    private String description;
}
