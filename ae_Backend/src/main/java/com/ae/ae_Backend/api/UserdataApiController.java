package com.ae.ae_Backend.api;

import com.ae.ae_Backend.domain.Userdata;
import com.ae.ae_Backend.service.UserdataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserdataApiController {
    private final UserdataService userdataService;

    @GetMapping("/api/v1/userdata/{id}")
    public Userdata getUserData(@PathVariable("id") Long id) {
        Userdata findUserdata = userdataService.findOne(id);
        return findUserdata;

        //예외처리 구문 추가 필요

    }

    @GetMapping("/api/v1/userdatas")
    public List<Userdata> userDatas() {
        return userdataService.findUserDatas();
    }
}