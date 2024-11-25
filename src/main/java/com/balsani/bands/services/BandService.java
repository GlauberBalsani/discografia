package com.balsani.bands.services;


import com.balsani.bands.domain.models.Album;
import com.balsani.bands.domain.models.Band;
import com.balsani.bands.domain.models.dto.AlbumResponseDto;
import com.balsani.bands.domain.models.dto.CreateBandRequestDto;
import com.balsani.bands.domain.models.dto.CreateAlbumRequestDto;
import com.balsani.bands.domain.models.dto.ResponseBandDto;
import com.balsani.bands.repository.AlbumRepository;
import com.balsani.bands.repository.BandRepository;
import com.balsani.bands.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional()
public class BandService {
    private final BandRepository bandRepository;
    private final AlbumRepository albumRepository;

    public BandService(BandRepository bandRepository, AlbumRepository albumRepository) {
        this.bandRepository = bandRepository;
        this.albumRepository = albumRepository;
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
                        band.getAlbums().stream()
                                .map(AlbumResponseDto::toDto)
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }




    public void updateBand(String bandId, CreateBandRequestDto createBandRequestDto) {
        var id = UUID.fromString(bandId);

        bandRepository.findById(id).map(band -> {
            band.setBandName(createBandRequestDto.bandName());
            band.setDescription(createBandRequestDto.description());
            band.setFormationYear(createBandRequestDto.formationYear());

            return CreateBandRequestDto.toModel(band);
        });


    }

    public Optional<Band> getById(String bandId) {
        var id = UUID.fromString(bandId);
        var bandExists = bandRepository.existsById(id);
        if (!bandExists) {
            throw new EntityNotFoundException("Banda não encontrada com o ID: " + bandId);

        }
        return bandRepository.findById(UUID.fromString(bandId));

    }

    public void deleteBand(String bandId) {
        bandRepository.deleteById(UUID.fromString(bandId));
    }

    public CreateAlbumRequestDto createAlbum(
            String bandId, CreateAlbumRequestDto createAlbumRequestDto) {
        var band = bandRepository.findById(UUID.fromString(bandId))
                .orElseThrow(() -> new ResourceNotFoundException("Band not found"));

        var album = new Album(
                createAlbumRequestDto.title(),
                createAlbumRequestDto.description(),
                createAlbumRequestDto.dateOfRelease()
        );

        albumRepository.save(album);

        band.getAlbums().add(album);



        return CreateAlbumRequestDto.toModel(album);
    }


}
