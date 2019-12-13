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
import java.util.stream.Collectors;

@Service
public class MobilService {
    @Autowired
    private MobilRepository mobilRepository;
    @Autowired
    private EntityManager entityManager;

    public List<Mobil> getAllMobil() {
        return mobilRepository.findAll();
    }

    public Mobil getMobilById(Long id) {
        return mobilRepository.getOne(id);
    }

    public List<Mobil> getMobilByMerkId(Long merkId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Mobil> criteriaQuery = criteriaBuilder.createQuery(Mobil.class);
        Root<Mobil> mobilRoot = criteriaQuery.from(Mobil.class);

        Predicate predicateMerkId = criteriaBuilder.equal(mobilRoot.get("merkId"), merkId);
        criteriaQuery.where(predicateMerkId);

        TypedQuery<Mobil> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    public List<Mobil> getMobilByMerkIdTypeId(Long merkId, Long typeId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Mobil> criteriaQuery = criteriaBuilder.createQuery(Mobil.class);
        Root<Mobil> mobilRoot = criteriaQuery.from(Mobil.class);

        Predicate predicateMerkId = criteriaBuilder.equal(mobilRoot.get("merkId"), merkId);
        Predicate predicateTypeId = criteriaBuilder.equal(mobilRoot.get("typeId"), typeId);
        criteriaQuery.where(predicateMerkId, predicateTypeId);

        TypedQuery<Mobil> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    public Mobil addMobilByMerkIdTypeId(Long merkId, Long typeId, Mobil mobil) {
        Mobil newMobil = new Mobil();

        newMobil.setNomorKerangka(mobil.getNomorKerangka());
        newMobil.setSeriWilayah(mobil.getSeriWilayah());
        newMobil.setNomor(mobil.getNomor());
        newMobil.setSeri(mobil.getSeri());
        newMobil.setMerkId(merkId);
        newMobil.setTypeId(typeId);
        newMobil.setTahun(mobil.getTahun());

        return mobilRepository.save(newMobil);
    }

    public List<Mobil> updateMobilByMerkIdTypeId(Long merkId, Long typeId, Mobil mobil) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Mobil> criteriaQuery = criteriaBuilder.createQuery(Mobil.class);
        Root<Mobil> mobilRoot = criteriaQuery.from(Mobil.class);

        Predicate predicateMerkId = criteriaBuilder.equal(mobilRoot.get("merkId"), merkId);
        Predicate predicateTypeId = criteriaBuilder.equal(mobilRoot.get("typeId"), typeId);
        criteriaQuery.where(predicateMerkId, predicateTypeId);

        TypedQuery<Mobil> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Mobil> mobils = typedQuery.getResultList();

        for (Mobil m : mobils
        ) {
            m.setNomorKerangka(mobil.getNomorKerangka());
            m.setSeriWilayah(mobil.getSeriWilayah());
            m.setNomor(mobil.getNomor());
            m.setSeri(mobil.getSeri());
            m.setTahun(mobil.getTahun());
        }

        return mobilRepository.saveAll(mobils);
    }


    public Boolean deleteMobilByMerkIdTypeId(Long merkId, Long typeId, Mobil mobil) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Mobil> criteriaQuery = criteriaBuilder.createQuery(Mobil.class);
        Root<Mobil> mobilRoot = criteriaQuery.from(Mobil.class);

        Predicate predicateMerkId = criteriaBuilder.equal(mobilRoot.get("merkId"), merkId);
        Predicate predicateTypeId = criteriaBuilder.equal(mobilRoot.get("typeId"), typeId);
        criteriaQuery.where(predicateMerkId, predicateTypeId);

        TypedQuery<Mobil> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Mobil> mobils = typedQuery.getResultList();

        if(mobils.size() > 0){
            for (Mobil m : mobils
            ) {
                m.setNomorKerangka(mobil.getNomorKerangka());
                m.setSeriWilayah(mobil.getSeriWilayah());
                m.setNomor(mobil.getNomor());
                m.setSeri(mobil.getSeri());
                m.setTahun(mobil.getTahun());
            }

            List<Long> listId = mobils.stream().map(m -> m.getId()).collect(Collectors.toList());

            mobilRepository.deleteAll(mobils);

            return mobilRepository.findAllById(listId).size() == 0;
        }else{
            return false;
        }

    }


}
