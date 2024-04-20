package com.balsani.bands.domain.services;

import com.balsani.bands.domain.repository.AlbumRepository;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {
    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }


}
