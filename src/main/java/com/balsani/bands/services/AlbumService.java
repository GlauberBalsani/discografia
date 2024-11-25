package com.balsani.bands.services;

import com.balsani.bands.domain.models.Album;
import com.balsani.bands.repository.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AlbumService {
    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public Optional<Album> getById(String bandId) {

        return albumRepository.findById(UUID.fromString(bandId));

    }


}
