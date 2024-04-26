package com.balsani.bands.controller;

import com.balsani.bands.domain.models.Band;
import com.balsani.bands.domain.models.dto.CreateBandRequestDto;
import com.balsani.bands.domain.models.dto.CreateAlbumRequestDto;
import com.balsani.bands.domain.models.dto.ResponseBandDto;
import com.balsani.bands.domain.services.BandService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/bands")
public class BandController {

    private final BandService bandService;

    public BandController(BandService bandService) {
        this.bandService = bandService;
    }

    @PostMapping
    public ResponseEntity<CreateBandRequestDto> create(@RequestBody @Valid CreateBandRequestDto createBandRequestDto) {
        CreateBandRequestDto createBand = bandService.createBand(createBandRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(createBand);

    }

    @GetMapping
    public ResponseEntity<List<ResponseBandDto>> listAll(@PageableDefault(size = 10, sort = {"bandName"})Pageable pageable) {
        List<ResponseBandDto> bands = bandService.getAll();

        return ResponseEntity.ok(bands);
    }

    @GetMapping("/{bandId}")
    public ResponseEntity<Optional<Band>> findById(@PathVariable("bandId") String bandId) {
        var band = bandService.getById(bandId);

        return ResponseEntity.ok(band);
    }

    @PutMapping("/{bandId}")
    public ResponseEntity<CreateBandRequestDto> update(
            @PathVariable ("bandId") String bandId, @RequestBody @Valid CreateBandRequestDto createBandRequestDto) {
        bandService.updateBand(bandId, createBandRequestDto);
        return ResponseEntity.ok().body(createBandRequestDto);
    }

    @DeleteMapping("/{bandId}")
    public ResponseEntity<Void> delete(@PathVariable String bandId) {
        bandService.deleteBand(bandId);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("{bandId}/album")
    public ResponseEntity<CreateAlbumRequestDto> createAlbum(
            @PathVariable("bandId") String bandId,
            @RequestBody @Valid CreateAlbumRequestDto createAlbumRequestDto) {
        CreateAlbumRequestDto record = bandService.createAlbum(bandId, createAlbumRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(record);
    }
}
