package com.abdi.aliotosale.repository;

import com.abdi.aliotosale.models.Merk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MerkRepository extends JpaRepository<Merk, Long> {

}
