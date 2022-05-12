package com.ae.ae_Backend.service;
import com.ae.ae_Backend.domain.MmseList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ae.ae_Backend.repository.MmseListRepository;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MmseListService {
    private final MmseListRepository mmseListRepository;

    public List<MmseList> findmmseLists() {
        return mmseListRepository.findAll();
    }

    public MmseList findOne(Long mId) {
        return mmseListRepository.findOne(mId);
    }
}
