package com.balsani.bands.domain.services;


import com.balsani.bands.domain.models.dto.CreateBandRequestDto;
import com.balsani.bands.domain.repository.BandRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BandService {
    private final BandRepository bandRepository;

    public BandService(BandRepository bandRepository) {
        this.bandRepository = bandRepository;
    }

    public CreateBandRequestDto createBand(CreateBandRequestDto createBandRequestDto) {
        
    }
}
