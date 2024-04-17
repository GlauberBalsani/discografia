package com.balsani.bands.domain.models.dto;

import com.balsani.bands.domain.models.Record;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateRecordRequestDto(
        @NotNull
        String title,
        @NotNull
        String description,
        @NotNull
        LocalDate dateOfRelease
) {
    public static CreateBandRequestDto toModel(Record record) {
        return new CreateBandRequestDto(
                record.getTitle(),
                record.getDescription(),
                record.getDateOfRelease());
    }
}
