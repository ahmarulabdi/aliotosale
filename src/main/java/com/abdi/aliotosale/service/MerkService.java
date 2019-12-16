package com.abdi.aliotosale.service;

import com.abdi.aliotosale.exception.ResourceNotFoundException;
import com.abdi.aliotosale.models.Merk;
import com.abdi.aliotosale.models.Type;
import com.abdi.aliotosale.repository.MerkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class MerkService {
    @Autowired
    private MerkRepository merkRepository;

    @Autowired
    private EntityManager entityManager;

    public List<Merk> getAllMerk() {
        return merkRepository.findAll();
    }

    public Merk getMerkById(Long id) {
        return merkRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Merk", "ID", id)
        );
    }

    public Merk findFirstByBrand(String brand) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Merk> criteriaQuery = criteriaBuilder.createQuery(Merk.class);
        Root<Merk> typeRoot = criteriaQuery.from(Merk.class);

        Predicate predicateMerkBrand = criteriaBuilder.equal(typeRoot.get("brand"), brand);
        criteriaQuery.where(predicateMerkBrand);

        TypedQuery<Merk> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getSingleResult();
    }

    public Merk updateMerkById(Long id, Merk merk) {
        Merk updatedMerk = merkRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Merk", "ID", id)
        );

        updatedMerk.setBrand(merk.getBrand());
        return merkRepository.save(updatedMerk);
    }

    public Boolean deleteMerkById(Long id) {
        merkRepository.deleteById(id);
        return merkRepository.findById(id).isEmpty();
    }

}
