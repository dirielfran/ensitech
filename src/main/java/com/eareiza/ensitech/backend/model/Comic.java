package com.eareiza.ensitech.backend.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Comic {
    private Long id;
    private String name;
    private String description;
}
