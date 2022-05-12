package com.ae.ae_Backend.repository;

        import com.ae.ae_Backend.domain.MmseAns;
        import lombok.RequiredArgsConstructor;
        import org.springframework.stereotype.Repository;

        import javax.persistence.EntityManager;
        import java.util.List;

@Repository
@RequiredArgsConstructor
public class MmseAnsRepository {
    private EntityManager em;

    public void save(MmseAns mmseAns) {
        em.persist(mmseAns);
    }

    public MmseAns findOne(Long id) {
        return em.find(MmseAns.class, id);
    }

    public List<MmseAns> findAll() {
        return em.createQuery("select ma from mmse_ans ma", MmseAns.class).getResultList();
    }
}