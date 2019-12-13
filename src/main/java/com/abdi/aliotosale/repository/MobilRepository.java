package com.abdi.aliotosale.repository;

import com.abdi.aliotosale.models.Mobil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobilRepository extends JpaRepository<Mobil, Long> {

}
