package com.ae.ae_Backend.api;

import com.ae.ae_Backend.domain.MmseAns;
import com.ae.ae_Backend.service.MmseAnsService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MmseAnsApiController {
    private final MmseAnsService mmseAnsService;

    @GetMapping("/api/v1/mmseAns/{id}")
    public MmseAns getMmseAnswer(@PathVariable("id") Long id) {

        MmseAns findMmseAnswer = mmseAnsService.findOne(id);
        return findMmseAnswer;

        //예외처리 구문 추가 필요
    }

    @PostMapping("/api/v1/mmseans")
    //public CreateMAResponse saveMA(@RequestBody @Value mmseAns mmseAns) {
    public CreateMAnsResponse saveMA(@PathVariable("userId")Long userId, @PathVariable("mmseListId") Long mlId, @PathVariable("answer") String answer) {
        Long id = mmseAnsService.mmseAns(userId, mlId, answer);

        return new CreateMAnsResponse(id);

    }
    @Data
    static class CreateMAnsResponse{
        private Long id;
        public CreateMAnsResponse(Long id) {
            this.id = id;
        }
    }
}