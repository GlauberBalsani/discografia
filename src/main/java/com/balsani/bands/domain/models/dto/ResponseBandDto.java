package com.balsani.bands.domain.models.dto;

import java.time.LocalDate;

public record ResponseBandDto(
        String bandName,
        String description,
        LocalDate formationYear) {
}
