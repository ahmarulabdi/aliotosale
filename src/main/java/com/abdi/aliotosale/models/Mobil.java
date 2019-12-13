package com.abdi.aliotosale.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Year;
import java.util.Date;

@Entity
@Table(name = "mobil")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {
        "createdAt",
        "updatedAt"
}, allowGetters = true
)
public class Mobil implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long nomorKerangka;
    @NotBlank
    private String seriWilayah;
    @NotNull
    private Long nomor;
    @NotBlank
    private String seri;
    @NotNull
    private Long merkId;
    @NotNull
    private Long typeId;
    @NotBlank
    private String tahun;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNomorKerangka() {
        return nomorKerangka;
    }

    public void setNomorKerangka(Long nomorKerangka) {
        this.nomorKerangka = nomorKerangka;
    }

    public String getSeriWilayah() {
        return seriWilayah;
    }

    public void setSeriWilayah(String seriWilayah) {
        this.seriWilayah = seriWilayah;
    }

    public Long getNomor() {
        return nomor;
    }

    public void setNomor(Long nomor) {
        this.nomor = nomor;
    }

    public String getSeri() {
        return seri;
    }

    public void setSeri(String seri) {
        this.seri = seri;
    }

    public Long getMerkId() {
        return merkId;
    }

    public void setMerkId(Long merkId) {
        this.merkId = merkId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Mobil{" +
                "id=" + id +
                "nomorKerangka=" + nomorKerangka +
                "seriWilayah=" + seriWilayah +
                "nomor=" + nomor +
                "seri=" + seri +
                "merkId=" + merkId +
                "typeId=" + typeId +
                "tahun=" + tahun +
                "createdAt=" + createdAt +
                "updatedAt=" + updatedAt +
                "}";
    }
}
