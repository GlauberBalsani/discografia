package com.balsani.bands.domain.models.dto;

import com.balsani.bands.domain.models.Album;

import java.time.LocalDate;
import java.util.UUID;

public record AlbumResponseDto(
        UUID recordId,
        String title,
        String description,
        LocalDate dateOfRelease
) {

    public static AlbumResponseDto toDto(Album album) {
        return new AlbumResponseDto(
                album.getRecordId(),
                album.getTitle(),
                album.getDescription(),
                album.getDateOfRelease()
        );
    }
}
