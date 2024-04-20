package com.balsani.bands.domain.services;


import com.balsani.bands.domain.models.Band;
import com.balsani.bands.domain.models.dto.CreateBandRequestDto;
import com.balsani.bands.domain.models.dto.ResponseBandDto;
import com.balsani.bands.domain.repository.BandRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class BandService {
    private final BandRepository bandRepository;

    public BandService(BandRepository bandRepository) {
        this.bandRepository = bandRepository;
    }

    public CreateBandRequestDto createBand(CreateBandRequestDto createBandRequestDto) {
        if (bandRepository.existsBandByBandName(createBandRequestDto.bandName())) {
            throw new RuntimeException("Banda já existe");
        }
        var band = new Band(
                createBandRequestDto.bandName(),
                createBandRequestDto.description(),
                createBandRequestDto.formationYear(),
                null
        );

        var bandSaved = bandRepository.save(band);

        return CreateBandRequestDto.toModel(bandSaved);
    }

    public List<ResponseBandDto> getAll() {
        return bandRepository
                .findAll()
                .stream()
                .map(band -> new ResponseBandDto(
                        band.getBandId(),
                        band.getBandName(),
                        band.getDescription(),
                        band.getFormationYear(),
                        new ArrayList<>()))
                .collect(Collectors.toList());


    }

    public Optional<CreateBandRequestDto> updateBand(String bandId, CreateBandRequestDto createBandRequestDto) {
        var id = UUID.fromString(bandId);

        return bandRepository.findById(id).map(band -> {
            band.setBandName(createBandRequestDto.bandName());
            band.setDescription(createBandRequestDto.description());
            band.setFormationYear(createBandRequestDto.formationYear());

            return CreateBandRequestDto.toModel(band);
        });


    }

    public Optional<Band> getById(String bandId) {

        return bandRepository.findById(UUID.fromString(bandId));

    }

    public void deleteBand(String bandId) {
        bandRepository.deleteById(UUID.fromString(bandId));
    }


}
