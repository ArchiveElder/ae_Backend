package com.ae.ae_Backend.service;

import com.ae.ae_Backend.domain.Diary;
import com.ae.ae_Backend.domain.User;
import com.ae.ae_Backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ae.ae_Backend.repository.DiaryRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DiaryService {

    private final DiaryRepository diaryRepository;
    private final UserRepository userRepository;

    //일기 저장
    @Transactional
    public Long saveDiary (Long userId, String image, String source_audio, String text){
        //엔티티 조회
        User user = userRepository.findOne(userId);

        //일기 생성
        Diary diary = Diary.createDiary(user, image, source_audio, text);

        //일기 저장
        diaryRepository.save(diary);
        return diary.getId();
    }

    //단일 일기 조회
    public Diary findOne(Long id){
        return diaryRepository.findOne(id);
    }

    //모든 일기 조회
    public List<Diary> findDiaries() {
        return diaryRepository.findAll();
    }

}

