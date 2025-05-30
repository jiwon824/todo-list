package jiwon.todo.controller;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberForm {
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
    @Pattern(message = "도메인은 최소 하나 이상의 점(.)을 포함해야 합니다.",
            regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;
}
