package com.balsani.bands.domain.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tb_bands")
public class Band {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID bandId;
    @Column(name = "band_name")
    private String bandName;
    @Column(name = "descripton")
    private String description;
    @Column(name = "formation_year")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date formationYear;

    public Band() {
    }

    public Band(String bandName, String description, Date formationYear) {
        this.bandName = bandName;
        this.description = description;
        this.formationYear = formationYear;
    }

    public UUID getBandId() {
        return bandId;
    }


    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getFormationYear() {
        return formationYear;
    }

    public void setFormationYear(Date formationYear) {
        this.formationYear = formationYear;
    }
}
