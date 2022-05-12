package com.ae.ae_Backend.repository;

import com.ae.ae_Backend.domain.MmseList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MmseListRepository {

    private EntityManager em;

    public MmseList findOne(Long id) {
        return em.find(MmseList.class, id);
    }

    public List<MmseList> findAll() {
        return em.createQuery("select ml from mmse_list ml", MmseList.class).getResultList();
    }
}