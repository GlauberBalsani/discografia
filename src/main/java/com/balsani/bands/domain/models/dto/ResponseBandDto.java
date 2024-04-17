package com.balsani.bands.domain.models.dto;

import java.time.LocalDate;
import java.util.UUID;

public record ResponseBandDto(
        UUID bandId,
        String bandName,
        String description,
        LocalDate formationYear
) {
}
