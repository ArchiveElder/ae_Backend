package service;

import domain.StoryCard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.StoryCardRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StoryCardService {
    private final StoryCardRepository storyCardRepository;

    public List<StoryCard> findStoryCards() {
        return storyCardRepository.findAll();
    }

    public StoryCard findOne(Long scId) {
        return storyCardRepository.findOne(scId);
    }
}
