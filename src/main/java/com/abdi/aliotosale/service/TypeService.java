package com.abdi.aliotosale.service;


import com.abdi.aliotosale.exception.ResourceNotFoundException;
import com.abdi.aliotosale.models.Mobil;
import com.abdi.aliotosale.models.Type;
import com.abdi.aliotosale.repository.TypeRepository;
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
public class TypeService {
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private EntityManager entityManager;

    public List<Type> getAllType() {
        return typeRepository.findAll();
    }

    public Type getTypeById(Long id) {
        return typeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Type", "ID", id)
        );
    }

    public Type findFirstByTypeNama(String nama) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Type> criteriaQuery = criteriaBuilder.createQuery(Type.class);
        Root<Type> typeRoot = criteriaQuery.from(Type.class);

        Predicate predicateTypeNama = criteriaBuilder.equal(typeRoot.get("nama"), nama);
        criteriaQuery.where(predicateTypeNama);

        TypedQuery<Type> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getSingleResult();
    }

    public Type updateTypeById(Long id, Type type) {
        Type udpatedType = typeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Type", "ID", id)
        );

        udpatedType.setNama(type.getNama());
        return typeRepository.save(udpatedType);
    }

    public Boolean deleteTypeById(Long id) {
        typeRepository.deleteById(id);
        return typeRepository.findById(id).isEmpty();
    }
}
