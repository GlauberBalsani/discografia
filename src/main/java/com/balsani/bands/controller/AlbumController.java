package com.balsani.bands.controller;

import com.balsani.bands.domain.models.Album;
import com.balsani.bands.domain.repository.AlbumRepository;
import com.balsani.bands.domain.services.AlbumService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/v1/album")
public class AlbumController {
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/{albumId}")
    public ResponseEntity<Optional<Album>> findAlbumById(@PathVariable("albumId") String albumId) {
        var album = albumService.getById(albumId);

        return ResponseEntity.ok(album);
    }
}
