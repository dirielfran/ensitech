package com.eareiza.ensitech.backend.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
public class ComicDto {
    private Integer id;
    private String name;
    private String description;
    private Date modified;
    private int comics;
    private int events;
    private int series;
    private int stories;
}
