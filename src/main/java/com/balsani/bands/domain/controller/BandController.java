package com.balsani.bands.domain.controller;

import com.balsani.bands.domain.models.Band;
import com.balsani.bands.domain.models.dto.CreateBandRequestDto;
import com.balsani.bands.domain.services.BandService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

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
}
