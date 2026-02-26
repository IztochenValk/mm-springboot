package com.adrar.cdafad.dto;

public record GameDTO(
        String title,
        String description,
        Integer publishYear,
        String manufacturerName,
        String console
) {}