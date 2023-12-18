package com.example.savetodb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "\"APPENDIXA_REQUEST_TEST\"")
public class AppendixaRequestTest {
    @Id
    @Column(name = "arq_id", nullable = false)
    private UUID id;

    @Column(name = "category", length = Integer.MAX_VALUE)
    private String category;

    @Column(name = "subcategory", length = Integer.MAX_VALUE)
    private String subcategory;

    @Column(name = "arq_processing_status", length = Integer.MAX_VALUE)
    private String arqProcessingStatus;

    @Column(name = "arq_start_timestamp")
    private OffsetDateTime arqStartTimestamp;

    @Column(name = "arq_end_timestamp")
    private OffsetDateTime arqEndTimestamp;

    @Column(name = "arq_created_by", length = Integer.MAX_VALUE)
    private String arqCreatedBy;

    @Column(name = "arq_modified_by", length = Integer.MAX_VALUE)
    private String arqModifiedBy;

    @Column(name = "arq_created_timestamp")
    private OffsetDateTime arqCreatedTimestamp;

    @Column(name = "arq_modified_timestamp")
    private OffsetDateTime arqModifiedTimestamp;

    @Column(name = "stn", length = Integer.MAX_VALUE)
    private String stn;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getArqProcessingStatus() {
        return arqProcessingStatus;
    }

    public void setArqProcessingStatus(String arqProcessingStatus) {
        this.arqProcessingStatus = arqProcessingStatus;
    }

    public OffsetDateTime getArqStartTimestamp() {
        return arqStartTimestamp;
    }

    public void setArqStartTimestamp(OffsetDateTime arqStartTimestamp) {
        this.arqStartTimestamp = arqStartTimestamp;
    }

    public OffsetDateTime getArqEndTimestamp() {
        return arqEndTimestamp;
    }

    public void setArqEndTimestamp(OffsetDateTime arqEndTimestamp) {
        this.arqEndTimestamp = arqEndTimestamp;
    }

    public String getArqCreatedBy() {
        return arqCreatedBy;
    }

    public void setArqCreatedBy(String arqCreatedBy) {
        this.arqCreatedBy = arqCreatedBy;
    }

    public String getArqModifiedBy() {
        return arqModifiedBy;
    }

    public void setArqModifiedBy(String arqModifiedBy) {
        this.arqModifiedBy = arqModifiedBy;
    }

    public OffsetDateTime getArqCreatedTimestamp() {
        return arqCreatedTimestamp;
    }

    public void setArqCreatedTimestamp(OffsetDateTime arqCreatedTimestamp) {
        this.arqCreatedTimestamp = arqCreatedTimestamp;
    }

    public OffsetDateTime getArqModifiedTimestamp() {
        return arqModifiedTimestamp;
    }

    public void setArqModifiedTimestamp(OffsetDateTime arqModifiedTimestamp) {
        this.arqModifiedTimestamp = arqModifiedTimestamp;
    }

    public String getStn() {
        return stn;
    }

    public void setStn(String stn) {
        this.stn = stn;
    }

}