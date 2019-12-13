package com.abdi.aliotosale.service;


import com.abdi.aliotosale.models.Mobil;
import com.abdi.aliotosale.repository.MobilRepository;
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
public class MobilService {
    @Autowired
    private MobilRepository mobilRepository;

    private EntityManager entityManager;

    public List<Mobil> getAllMobil() {
        return mobilRepository.findAll();
    }

    public Mobil getMobilById(Long id) {
        return mobilRepository.getOne(id);
    }

    public List<Mobil> getMobilByMerkId(Long merkId){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Mobil> criteriaQuery = criteriaBuilder.createQuery(Mobil.class);

        Root<Mobil> mobilRoot = criteriaQuery.from(Mobil.class);
        Predicate predicateMerkId = criteriaBuilder.equal(mobilRoot.get("merkId"), merkId);
        criteriaQuery.where(predicateMerkId);

        TypedQuery<Mobil> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }



}
