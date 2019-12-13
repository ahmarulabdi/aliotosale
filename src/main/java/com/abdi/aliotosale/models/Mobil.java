package com.abdi.aliotosale.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.Year;
import java.util.Date;

@Entity
@Table(name = "mobils")
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

    @NotBlank
    private Long nomorKerangka;
    @NotBlank
    private String seriWilayah;
    @NotBlank
    private Integer nomor;
    @NotBlank
    private String seri;
    @NotBlank
    private String merk;
    @NotBlank
    private String tipe;
    @NotBlank
    private Year tahun;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public Mobil(
            @NotBlank Long nomorKerangka,
            @NotBlank String seriWilayah,
            @NotBlank Integer nomor,
            @NotBlank String seri,
            @NotBlank String merk,
            @NotBlank String tipe,
            @NotBlank Year tahun
            ){
        this.nomorKerangka = nomorKerangka;
        this.seriWilayah = seriWilayah;
        this.nomor = nomor;
        this.seri = seri;
        this.merk = merk;
        this.tipe = tipe;
        this.tahun = tahun;
    }

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

    public Integer getNomor() {
        return nomor;
    }

    public void setNomor(Integer nomor) {
        this.nomor = nomor;
    }

    public String getSeri() {
        return seri;
    }

    public void setSeri(String seri) {
        this.seri = seri;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public Year getTahun() {
        return tahun;
    }

    public void setTahun(Year tahun) {
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
                "id="+ id +
                "nomorKerangka="+ nomorKerangka +
                "seriWilayah="+ seriWilayah +
                "nomor="+ nomor +
                "seri="+ seri +
                "merk="+ merk +
                "tipe="+ tipe+
                "tahun="+tahun+
                "}";
    }
}