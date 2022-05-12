package com.ae.ae_Backend.service;

import com.ae.ae_Backend.domain.MmseAns;
import com.ae.ae_Backend.domain.MmseList;
import com.ae.ae_Backend.domain.User;
import com.ae.ae_Backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ae.ae_Backend.repository.*;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MmseAnsService {

    private final MmseAnsRepository mmseAnsRepository;
    private final UserRepository userRepository;
    private final MmseListRepository mmseListRepository;

    public List<MmseAns> findmmseAnsDatas() {
        return mmseAnsRepository.findAll();
    }

    public MmseAns findOne(Long mmse_ans_id) {
        return mmseAnsRepository.findOne(mmse_ans_id);
    }

    @Transactional
    public Long mmseAns(Long userId, Long mmseListId, String answer) {
        User user = userRepository.findOne(userId);
        MmseList mmseList = mmseListRepository.findOne(mmseListId);

        MmseAns mmseAnswer = MmseAns.createMmseAnswer(user, mmseList, answer);

        mmseAnsRepository.save(mmseAnswer);
        return mmseAnswer.getMmse_ans_id();
    }
}