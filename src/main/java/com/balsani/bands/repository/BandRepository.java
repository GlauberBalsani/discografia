package com.balsani.bands.repository;

import com.balsani.bands.domain.models.Band;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BandRepository extends JpaRepository<Band, UUID> {

    public boolean existsBandByBandName(String bandName);
}
