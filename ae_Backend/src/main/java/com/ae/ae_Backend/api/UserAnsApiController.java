package com.ae.ae_Backend.api;

import com.ae.ae_Backend.domain.UserAns;
import com.ae.ae_Backend.service.UserAnsService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequiredArgsConstructor
public class UserAnsApiController {
    private final UserAnsService userAnswerService;

    // 모든 사용자들의 기억카드 답변 조회
    @GetMapping("/api/userAnswers")
    public Result userAnswers() {
        List<UserAns> findUserAns = userAnswerService.findUserAnswers();
        System.out.println(findUserAns);
        List<UserAnswerDto> collect = findUserAns.stream()
                .map(m -> new UserAnswerDto(m.getAnswer(), m.getUser().getName(), m.getUser().getGender(), m.getUser().getBirth_year(), m.getStorycard().getId()))
                .collect(toList());
        return new Result(collect.size(), collect);
    }

    // 사용자의 기억카드 질문에 대한 답변 생성
    @PostMapping("/api/userAnswer")
    public CreateUserAnswerResponse createUserAnswer(@RequestBody @Valid CreateUserAnswerRequest request) {
        Long id = userAnswerService.answer(request.userId, request.storyCardId, request.answer);
        return new CreateUserAnswerResponse(id);
    }

    @Data
    private static class CreateUserAnswerRequest {
        @NotEmpty
        private String answer;

        @NotNull
        private Long userId;

        @NotNull
        private Long storyCardId;
    }

    @Data
    static class CreateUserAnswerResponse {
        private Long id;

        public CreateUserAnswerResponse(Long id) {
            this.id = id;
        }
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private Integer count;
        private T data;
    }

    @Data
    @AllArgsConstructor
    static class UserAnswerDto {
        private String answer;
        private String name;
        private Integer gender;
        private String birth_year;
        private Long storyCardId;
    }
}
