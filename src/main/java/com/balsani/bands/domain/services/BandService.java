package com.balsani.bands.domain.services;


import com.balsani.bands.domain.models.Band;
import com.balsani.bands.domain.models.dto.CreateBandRequestDto;
import com.balsani.bands.domain.models.dto.ResponseBandDto;
import com.balsani.bands.domain.repository.BandRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

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
                createBandRequestDto.formationYear()
        );

        var bandSaved =bandRepository.save(band);

        return CreateBandRequestDto.toModel(bandSaved);
    }

//    public List<ResponseBandDto> getAll() {
//
//    }
}
