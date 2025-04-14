package jiwon.todo.controller;

import jakarta.validation.Valid;
import jiwon.todo.domain.Todo;
import jiwon.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final TodoService todoService;

    @GetMapping("/")
    public String home(Model model){
        List<Todo> todos = todoService.findTodos();
        model.addAttribute("todos", todos);
        model.addAttribute("form", new TodoForm()); // 입력 폼 추가 (검증 실패 시 데이터 유지)
        return "home";
    }

    @PostMapping("/todos")
    public String create(@Valid TodoForm form, BindingResult result, Model model) {
        //️ form 데이터 검증
        if (result.hasErrors()) {
            model.addAttribute("todos", todoService.findTodos());
            model.addAttribute("todoForm", form);
            System.out.println("!!!!!! 검증 실패: " + result.getAllErrors());
            return "home";
        }

        // DB에 저장
        Todo todo = new Todo(form.getName());
        todoService.saveTodo(todo);
        System.out.println("!!!!!! 새로운 할 일 저장: " + todo.getName());

        return "redirect:/";
    }


    @PostMapping("/todos/{todoId}/delete")
    public String deleteTodo(@PathVariable("todoId") Long todoId) {
        todoService.deleteTodo(todoId);
        return "redirect:/";
    }

    @PostMapping("/todos/{id}/update")
    public String updateTodo(@PathVariable Long id, @RequestParam String name) {
        todoService.updateTodo(id, name, false);
        return "redirect:/";
    }
}
