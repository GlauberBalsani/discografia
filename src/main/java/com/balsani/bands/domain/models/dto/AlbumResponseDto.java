package com.balsani.bands.domain.models.dto;

import com.balsani.bands.domain.models.Album;

import java.time.LocalDate;

public record AlbumResponseDto(
        String title,
        String description,
        LocalDate dateOfRelease
) {

    public static AlbumResponseDto toDto(Album album) {
        return new AlbumResponseDto(
                album.getTitle(),
                album.getDescription(),
                album.getDateOfRelease()
        );
    }
}
