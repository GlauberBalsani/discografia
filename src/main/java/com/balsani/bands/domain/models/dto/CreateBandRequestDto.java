package com.balsani.bands.domain.models.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record CreateBandRequestDto(
        @NotBlank
        String bandName,
        @NotBlank
        String description,
        @NotBlank
        Date formationYear
) {
}
