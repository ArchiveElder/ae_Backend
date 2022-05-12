package com.ae.ae_Backend.api;

import com.ae.ae_Backend.domain.MmseList;
import com.ae.ae_Backend.service.MmseListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MmseListApiController {
    private final MmseListService mmseListService;

    @GetMapping("/api/v1/mmseList/{id}")
    public MmseList getMmseList(@PathVariable("id") Long id) {

        MmseList findMmseList = mmseListService.findOne(id);
        return findMmseList;

        //예외처리 구문 추가 필요
    }
}