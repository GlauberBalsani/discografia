package com.balsani.bands.domain.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;
@Entity
@Table(name = "tb_record")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID recordId;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "date_of_release")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfRelease;

    public Record() {
    }

    public Record(String title, String description, LocalDate dateOfRelease) {
        this.title = title;
        this.description = description;
        this.dateOfRelease = dateOfRelease;
    }

    public UUID getRecordId() {
        return recordId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(LocalDate dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }
}
