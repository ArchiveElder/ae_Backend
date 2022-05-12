package com.ae.ae_Backend.repository;

import com.ae.ae_Backend.domain.Userdata;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserdataRepository {

    private EntityManager em;

    public Userdata findOne(Long id) {
        return em.find(Userdata.class, id);
    }

    public List<Userdata> findAll() {
        return em.createQuery("select u from userdata ud", Userdata.class).getResultList();
    }

}
