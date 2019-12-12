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
    private Integer Nomor;
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
}
