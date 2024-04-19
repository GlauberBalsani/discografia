package com.balsani.bands.domain.models.dto;

import java.time.LocalDate;

public record RecordResponseDto(
        String title,
        String description,
        LocalDate dateOfRelease
) {
}
