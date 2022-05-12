package com.ae.ae_Backend.service;

import com.ae.ae_Backend.domain.Userdata;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ae.ae_Backend.repository.UserdataRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserdataService {
    private final UserdataRepository userDataRepository;

    public List<Userdata> findUserDatas() {
        return userDataRepository.findAll();
    }

    public Userdata findOne(Long user_data_id) {
        return userDataRepository.findOne(user_data_id);
    }
}
