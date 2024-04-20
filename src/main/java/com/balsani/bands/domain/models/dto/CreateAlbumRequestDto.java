package com.balsani.bands.domain.models.dto;

import com.balsani.bands.domain.models.Album;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateAlbumRequestDto(
        @NotNull
        String title,
        @NotNull
        String description,
        @NotNull
            LocalDate dateOfRelease
) {
    public static CreateAlbumRequestDto toModel(Album album) {
        return new CreateAlbumRequestDto(
                album.getTitle(),
                album.getDescription(),
                album.getDateOfRelease());
    }
}
