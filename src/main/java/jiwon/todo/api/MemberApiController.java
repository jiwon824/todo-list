package jiwon.todo.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jiwon.todo.domain.Member;
import jiwon.todo.service.MemberService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // @@Controller + @ResponseBody
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/api/members")
    public CreateMemberResponse saveMember(@RequestBody @Valid CreateMemberRequest request){
        Member member = new Member(request.getLoginId(), request.getPassword(),
                                    request.getName(), request.getEmail());

        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }

    @Data
    static class CreateMemberResponse {
        private Long id;

        public CreateMemberResponse(Long id) {
            this.id = id;
        }
    }

    @Data
    static class CreateMemberRequest {
        @NotEmpty(message = "이름을 입력해주세요")
        private String name; // 이름 혹은 닉네임

        @NotEmpty(message = "ID를 입력해주세요")
        private String loginId;

        @NotEmpty(message = "비밀번호를 입력해주세요")
        @Pattern(message = "비밀번호 형식이 올바르지 않습니다.",
                regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,}$")
        private String password; // 8자 이상, 대소문자 포함, 숫자 및 특수문자(@$!%*?&#) 포함

        @NotEmpty(message = "이메일을 입력해주세요")
        @Email(message = "이메일 형식이 올바르지 않습니다.")
        @Pattern(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$",
                message = "도메인은 최소 하나 이상의 점(.)을 포함해야 합니다.")
        private String email;
    }
}
