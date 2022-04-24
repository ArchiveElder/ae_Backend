package repository;

import domain.StoryCard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class StoryCardRepository {
    private final EntityManager em;
    public void save(StoryCard card) { em.persist(card); }
    public List<StoryCard> findAll() {
        return em.createQuery("select sc from StoryCard sc", StoryCard.class).getResultList();
    }
    public StoryCard findOne(Long id) { return em.find(StoryCard.class, id); }
}
