package com.balsani.bands.domain.models.dto;

import com.balsani.bands.domain.models.Band;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


public record CreateBandRequestDto(
        @NotBlank
        String bandName,
        @NotBlank
        String description,
        @NotNull
        LocalDate formationYear
) {
        public static CreateBandRequestDto toModel(Band band) {
                return new CreateBandRequestDto(
                        band.getBandName(),
                        band.getDescription(),
                        band.getFormationYear());
        }

}
