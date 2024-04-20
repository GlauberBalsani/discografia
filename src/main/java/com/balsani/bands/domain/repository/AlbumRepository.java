package com.balsani.bands.domain.repository;

import com.balsani.bands.domain.models.Album;
import com.balsani.bands.domain.models.dto.AlbumResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface AlbumRepository extends JpaRepository<Album, UUID> {


}
