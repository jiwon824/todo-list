package jiwon.todo.controller;

import jakarta.validation.Valid;
import jiwon.todo.domain.Member;
import jiwon.todo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/members/new")
    public String createForm(Model model){
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(@Valid MemberForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "members/createMemberForm"; // 검증 실패 시 데이터 유지
        }

        try{
            Member member = new Member(
                    form.getLoginId(),
                    form.getPassword(),
                    form.getName(),
                    form.getEmail());

            memberService.join(member);
            return "redirect:/";
        } catch (IllegalStateException e){
            result.reject("joinError", e.getMessage());
            return "members/createMemberForm"; // 검증 실패 시 데이터 유지
        }
    }
}
