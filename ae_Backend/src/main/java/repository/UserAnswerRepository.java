package repository;

import domain.UserAnswer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserAnswerRepository {
    private final EntityManager em;
    public void save(UserAnswer answer) { em.persist(answer); }
    public List<UserAnswer> findAll() {
        return em.createQuery("select ua from UserAnswer ua", UserAnswer.class).getResultList();
    }
    public UserAnswer findOne(Long id) { return em.find(UserAnswer.class, id); }
}
